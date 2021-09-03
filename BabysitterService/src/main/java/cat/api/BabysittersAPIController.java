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

import cat.service.SitterService;
import cat.vo.SitterVO.MapInfoVO;
import cat.vo.SitterVO.ProviderVO;
import cat.vo.SitterVO.SitterVO;

@RestController
public class BabysittersAPIController {
    @Autowired
    SitterService service;

    // 데이터 뽑기
    @GetMapping("/api/sitter")
    public Map<String, Object> getsitter() throws Exception {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1383000/idis/serviceInstitutionService/getServiceInstitutionList");
        urlBuilder.append("?"+URLEncoder.encode("serviceKey", "UTF-8") + "=M54YwZnptyTp%2BSC41J9eEEtgVC%2F0m7iVqubdl%2FDAMnTePASO3gqzn5eF5o7n5zp5rxRRezMsNC%2FuACsx2%2FdgFw%3D%3D");
        urlBuilder.append("&"+URLEncoder.encode("pageNo", "UTF-8")+"="+URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("&"+URLEncoder.encode("type", "UTF-8")+"="+URLEncoder.encode("xml", "UTF-8"));
        urlBuilder.append("&"+URLEncoder.encode("numOfRows", "UTF-8")+"="+URLEncoder.encode("100000", "UTF-8"));
        
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

            String ctpvNm = getTagValue("ctpvNm", elem);
            String childCareInstNm = getTagValue("childCareInstNm", elem);
            String rprsTelno = getTagValue("rprsTelno", elem);
            String drtlnTelno = getTagValue("drtlnTelno", elem);
            String fxno = getTagValue("fxno", elem);
            String zip = getTagValue("zip", elem);
            String addr = getTagValue("addr", elem);
            String lot = getTagValue("lot", elem);
            String lat = getTagValue("lat", elem);

            SitterVO vo = new SitterVO();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
            Date dt = formatter.parse(getTagValue("dataCrtrYmd", elem));
                
            vo.setDataCrtrYmd(dt);

            vo.setCtpvNm(ctpvNm);
            vo.setChildCareInstNm(childCareInstNm);
            vo.setRprsTelno(rprsTelno);
            vo.setDrtlnTelno(drtlnTelno);
            vo.setFxno(fxno);
            vo.setZip(zip);
            vo.setAddr(addr);
            vo.setLot(lot);
            vo.setLat(lat);

            service.insertSitter(vo);
        }
        resultMap.put("status", true);
        resultMap.put("message", "데이터가 입력되었습니다.");
        return resultMap;
    }
    // /api/map?seq=1
    @GetMapping("/api/map")
    public Map<String, Object> getSitterMap(@RequestParam Integer seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        MapInfoVO vo = service.selectMap(seq);
        if(vo == null) {
            resultMap.put("status", false);
            resultMap.put("data", null);
            resultMap.put("message", "데이터가 없습니다.");
            return resultMap;
        }
        resultMap.put("status", true);
        resultMap.put("data", vo);

        return resultMap;
    }
    @GetMapping("/api/provider")
    public Map<String, Object> getProvider() {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<ProviderVO> list = service.selectProvider();
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
