package cat.api;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cat.service.BabysitterService;
import cat.vo.BabysitterMonthlyTimeVO;
import cat.vo.BabysitterRegionVO;
import cat.vo.BabysitterTimeVO;

@RestController
public class BabysitterAPIController {
    @Autowired
    BabysitterService service;

    // 데이터 뽑기
    @GetMapping("/api/babysitter_request")
    public Map<String, Object> getbabysitter(
        @RequestParam String crtrYmFrom, @RequestParam String crtrYmTo
    ) throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1383000/idis/hourlyAplyService/getHourlyAplyList");
        urlBuilder.append("?"+URLEncoder.encode("serviceKey", "UTF-8") + "=M54YwZnptyTp%2BSC41J9eEEtgVC%2F0m7iVqubdl%2FDAMnTePASO3gqzn5eF5o7n5zp5rxRRezMsNC%2FuACsx2%2FdgFw%3D%3D");
        urlBuilder.append("&"+URLEncoder.encode("pageNo", "UTF-8")+"="+URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("&"+URLEncoder.encode("type", "UTF-8")+"="+URLEncoder.encode("xml", "UTF-8"));
        urlBuilder.append("&"+URLEncoder.encode("numOfRows", "UTF-8")+"="+URLEncoder.encode("100000", "UTF-8"));
        urlBuilder.append("&"+URLEncoder.encode("crtrYmFrom", "UTF-8")+"="+URLEncoder.encode(crtrYmFrom, "UTF-8"));
        urlBuilder.append("&"+URLEncoder.encode("crtrYmTo", "UTF-8")+"="+URLEncoder.encode(crtrYmTo, "UTF-8"));
        
        System.out.println(urlBuilder.toString());
        
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(urlBuilder.toString());

        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("item");
        if(nList.getLength() <= 0){
            resultMap.put("status", false);
            resultMap.put("message", "데이터가 없습니다.");
            return resultMap;
        }
        for(int i=0; i<nList.getLength(); i++) {
            Node node = nList.item(i);
            Element elem = (Element) node;

            String childCareInstNo = getTagValue("childCareInstNo", elem);
            String childCareInstNm = getTagValue("childCareInstNm", elem);
            String ilnsSrvcYn = getTagValue("ilnsSrvcYn", elem);
            String careDvsnNm = getTagValue("careDvsnNm", elem);
            String srvcDvsfctnNm = getTagValue("srvcDvsfctnNm", elem);
            String upChildCareInstNo = getTagValue("upChildCareInstNo", elem);
            String upChildCareInstNm = getTagValue("upChildCareInstNm", elem);
            String grAplyNocs = getTagValue("grAplyNocs", elem);

            BabysitterTimeVO vo = new BabysitterTimeVO();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
            Date dt = formatter.parse(getTagValue("crtrYm", elem));
            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMdd");
            Date dt1 = formatter1.parse(getTagValue("dataCrtrYmd", elem));
                
            vo.setCrtrYm(dt);
            vo.setDataCrtYmd(dt1);

            vo.setChildCareInstNo(childCareInstNo);
            vo.setChildCareInstNm(childCareInstNm);
            vo.setIlnsSrvcYn(ilnsSrvcYn);
            vo.setCareDvsnNm(careDvsnNm);
            vo.setSrvcDvsfctnNm(srvcDvsfctnNm);
            vo.setUpChildCareInstNo(upChildCareInstNo);
            vo.setUpChildCareInstNm(upChildCareInstNm);
            vo.setGrAplyNocs(grAplyNocs);
            vo.setHr02AplyNocs(Integer.parseInt(getTagValue("hr02AplyNocs", elem)));
            vo.setHr24AplyNocs(Integer.parseInt(getTagValue("hr24AplyNocs", elem)));
            vo.setHr46AplyNocs(Integer.parseInt(getTagValue("hr46AplyNocs", elem)));
            vo.setHr68AplyNocs(Integer.parseInt(getTagValue("hr68AplyNocs", elem)));
            vo.setHr810AplyNocs(Integer.parseInt(getTagValue("hr810AplyNocs", elem)));
            vo.setHr1012AplyNocs(Integer.parseInt(getTagValue("hr1012AplyNocs", elem)));
            vo.setHr1214AplyNocs(Integer.parseInt(getTagValue("hr1214AplyNocs", elem)));
            vo.setHr1416AplyNocs(Integer.parseInt(getTagValue("hr1416AplyNocs", elem)));
            vo.setHr1618AplyNocs(Integer.parseInt(getTagValue("hr1618AplyNocs", elem)));
            vo.setHr1820AplyNocs(Integer.parseInt(getTagValue("hr1820AplyNocs", elem)));
            vo.setHr2022AplyNocs(Integer.parseInt(getTagValue("hr2022AplyNocs", elem)));
            vo.setHr2224AplyNocs(Integer.parseInt(getTagValue("hr2224AplyNocs", elem)));
        
            service.insertBabysitterTime(vo);
        }
        resultMap.put("status", true);
        resultMap.put("message", "데이터가 입력되었습니다.");
        return resultMap;
    }

    @GetMapping("/api/monthly")
    public Map<String, Object> getMonthlyTime(
        @RequestParam String date
    ) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<BabysitterMonthlyTimeVO> list = service.selectBabysitterMonthlyTime(date);
        resultMap.put("list", list);

        return resultMap;
    }

    @GetMapping("/api/region")
    public Map<String, Object> getMonthlyregion(@RequestParam String date) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<BabysitterRegionVO> list = service.selectBabysitterRegion(date);
        resultMap.put("list", list);

        return resultMap;
    }

    public static String getTagValue(String tag, Element elem) {
        if(elem.getElementsByTagName(tag).item(0) == null) return null;
        NodeList nlList = elem.getElementsByTagName(tag).item(0).getChildNodes();
        if(nlList == null) return null;
        Node node = (Node) nlList.item(0);
        if(node == null) return null;
        return node.getNodeValue();
    }
}