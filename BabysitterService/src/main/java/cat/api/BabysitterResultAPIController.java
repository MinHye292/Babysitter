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

import cat.service.BabysitterResultService;
import cat.vo.ResultVO.BabysitterResultChildVO;
import cat.vo.ResultVO.BabysitterResultVO;
import cat.vo.ResultVO.ChildOldVO;
import cat.vo.ResultVO.OldVO;

@RestController
public class BabysitterResultAPIController {
    @Autowired
    BabysitterResultService service;

    @GetMapping("/api/result")
    public Map<String, Object> getResult(
        @RequestParam String crtrYmFrom, @RequestParam String crtrYmTo
        ) throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1383000/idis/childService/getChildList");
        urlBuilder.append("?"+URLEncoder.encode("serviceKey", "UTF-8") + "=M54YwZnptyTp%2BSC41J9eEEtgVC%2F0m7iVqubdl%2FDAMnTePASO3gqzn5eF5o7n5zp5rxRRezMsNC%2FuACsx2%2FdgFw%3D%3D");
        urlBuilder.append("&"+URLEncoder.encode("pageNo", "UTF-8")+"="+URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("&"+URLEncoder.encode("type", "UTF-8")+"="+URLEncoder.encode("xml", "UTF-8"));
        urlBuilder.append("&"+URLEncoder.encode("numOfRows", "UTF-8")+"="+URLEncoder.encode("100000", "UTF-8"));
        urlBuilder.append("&"+URLEncoder.encode("crtrYmFrom", "UTF-8")+"="+URLEncoder.encode(crtrYmFrom, "UTF-8"));
        urlBuilder.append("&"+URLEncoder.encode("crtrYmTo", "UTF-8")+"="+URLEncoder.encode(crtrYmTo, "UTF-8"));
        
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

            String childCareInstNm = getTagValue("childCareInstNm", elem);
            String ilnsSrvcYn = getTagValue("ilnsSrvcYn", elem);
            String careDvsnNm = getTagValue("careDvsnNm", elem);
            String srvcDvsfctnNm = getTagValue("srvcDvsfctnNm", elem);
            String upChildCareInstNm = getTagValue("upChildCareInstNm", elem);

            BabysitterResultVO vo = new BabysitterResultVO();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
            Date dt = formatter.parse(getTagValue("crtrYm", elem));
                
            vo.setCrtrYm(dt);

            vo.setChildCareInstNm(childCareInstNm);
            vo.setIlnsSrvcYn(ilnsSrvcYn);
            vo.setCareDvsnNm(careDvsnNm);
            vo.setSrvcDvsfctnNm(srvcDvsfctnNm);
            vo.setUpChildCareInstNm(upChildCareInstNm);
            vo.setChildCnt(Integer.parseInt(getTagValue("childCnt", elem)));
            vo.setBoyChildCnt(Integer.parseInt(getTagValue("boyChildCnt", elem)));
            vo.setGirlChildCnt(Integer.parseInt(getTagValue("girlChildCnt", elem)));
        
            service.insertBabysitterResult(vo);

        }
        resultMap.put("status", true);
        resultMap.put("message", "데이터가 입력되었습니다.");
        return resultMap;
    }

    @GetMapping("/api/acc_cnt")
    public Integer getAccCnt(@RequestParam String region, @RequestParam String date) {
        List<BabysitterResultChildVO> dataList = service.selectBabysitterChild(date, region);
        
        Integer acc = 0;

        for(int i=0;i<dataList.size(); i++) {
            acc += dataList.get(i).getAcc();
            System.out.println(acc);
            System.out.println(region);
            System.out.println(date);
        }
        return acc;
    }
    @GetMapping("/api/childGen")
    public Map<String, Object> getMonthlyregion(@RequestParam String date,@RequestParam String region) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        BabysitterResultChildVO data = service.selectBabysitterChildGen(date, region);
        resultMap.put("data", data);

        return resultMap;
    }

    @GetMapping("/api/child")
    public Map<String, Object> getChild(
        @RequestParam String crtrYmFrom, @RequestParam String crtrYmTo
        ) throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1383000/idis/incomeChildAgeService/getIncomeChildAgeList");
        urlBuilder.append("?"+URLEncoder.encode("serviceKey", "UTF-8") + "=M54YwZnptyTp%2BSC41J9eEEtgVC%2F0m7iVqubdl%2FDAMnTePASO3gqzn5eF5o7n5zp5rxRRezMsNC%2FuACsx2%2FdgFw%3D%3D");
        urlBuilder.append("&"+URLEncoder.encode("pageNo", "UTF-8")+"="+URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("&"+URLEncoder.encode("type", "UTF-8")+"="+URLEncoder.encode("xml", "UTF-8"));
        urlBuilder.append("&"+URLEncoder.encode("numOfRows", "UTF-8")+"="+URLEncoder.encode("100000", "UTF-8"));
        urlBuilder.append("&"+URLEncoder.encode("crtrYmFrom", "UTF-8")+"="+URLEncoder.encode(crtrYmFrom, "UTF-8"));
        urlBuilder.append("&"+URLEncoder.encode("crtrYmTo", "UTF-8")+"="+URLEncoder.encode(crtrYmTo, "UTF-8"));
        
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

            String childCareInstNm = getTagValue("childCareInstNm", elem);

            ChildOldVO vo = new ChildOldVO();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
            Date dt = formatter.parse(getTagValue("crtrYm", elem));

            // System.out.println(getTagValue("age1aAtypeChildCnt", elem));
                
            vo.setCrtrYm(dt);
            vo.setChildCareInstNm(childCareInstNm);

            vo.setAge0aAtypeChildCnt(Integer.parseInt(getTagValue("age0aAtypeChildCnt", elem)));
            vo.setAge1aAtypeChildCnt(Integer.parseInt(getTagValue("age1aAtypeChildCnt", elem)));
            vo.setAge2aAtypeChildCnt(Integer.parseInt(getTagValue("age2aAtypeChildCnt", elem)));
            vo.setAge3aAtypeChildCnt(Integer.parseInt(getTagValue("age3aAtypeChildCnt", elem)));
            vo.setAge4aAtypeChildCnt(Integer.parseInt(getTagValue("age4aAtypeChildCnt", elem)));
            vo.setAge5aAtypeChildCnt(Integer.parseInt(getTagValue("age5aAtypeChildCnt", elem)));
            vo.setAge6aAtypeChildCnt(Integer.parseInt(getTagValue("age6aAtypeChildCnt", elem)));
            vo.setAge7aAtypeChildCnt(Integer.parseInt(getTagValue("age7aAtypeChildCnt", elem)));
            vo.setAge8aAtypeChildCnt(Integer.parseInt(getTagValue("age8aAtypeChildCnt", elem)));
            vo.setAge9aAtypeChildCnt(Integer.parseInt(getTagValue("age9aAtypeChildCnt", elem)));
            vo.setAge10aAtypeChildCnt(Integer.parseInt(getTagValue("age10aAtypeChildCnt", elem)));
            vo.setAge11aAtypeChildCnt(Integer.parseInt(getTagValue("age11aAtypeChildCnt", elem)));
            vo.setAge12aAtypeChildCnt(Integer.parseInt(getTagValue("age12aAtypeChildCnt", elem)));

            vo.setAge0aBtypeChildCnt(Integer.parseInt(getTagValue("age0aBtypeChildCnt", elem)));
            vo.setAge1aBtypeChildCnt(Integer.parseInt(getTagValue("age1aBtypeChildCnt", elem)));
            vo.setAge2aBtypeChildCnt(Integer.parseInt(getTagValue("age2aBtypeChildCnt", elem)));
            vo.setAge3aBtypeChildCnt(Integer.parseInt(getTagValue("age3aBtypeChildCnt", elem)));
            vo.setAge4aBtypeChildCnt(Integer.parseInt(getTagValue("age4aBtypeChildCnt", elem)));
            vo.setAge5aBtypeChildCnt(Integer.parseInt(getTagValue("age5aBtypeChildCnt", elem)));
            vo.setAge6aBtypeChildCnt(Integer.parseInt(getTagValue("age6aBtypeChildCnt", elem)));
            vo.setAge7aBtypeChildCnt(Integer.parseInt(getTagValue("age7aBtypeChildCnt", elem)));
            vo.setAge8aBtypeChildCnt(Integer.parseInt(getTagValue("age8aBtypeChildCnt", elem)));
            vo.setAge9aBtypeChildCnt(Integer.parseInt(getTagValue("age9aBtypeChildCnt", elem)));
            vo.setAge10aBtypeChildCnt(Integer.parseInt(getTagValue("age10aBtypeChildCnt", elem)));
            vo.setAge11aBtypeChildCnt(Integer.parseInt(getTagValue("age11aBtypeChildCnt", elem)));
            vo.setAge12aBtypeChildCnt(Integer.parseInt(getTagValue("age12aBtypeChildCnt", elem)));

            vo.setAge0aCtypeChildCnt(Integer.parseInt(getTagValue("age0aCtypeChildCnt", elem)));
            vo.setAge1aCtypeChildCnt(Integer.parseInt(getTagValue("age1aCtypeChildCnt", elem)));
            vo.setAge2aCtypeChildCnt(Integer.parseInt(getTagValue("age2aCtypeChildCnt", elem)));
            vo.setAge3aCtypeChildCnt(Integer.parseInt(getTagValue("age3aCtypeChildCnt", elem)));
            vo.setAge4aCtypeChildCnt(Integer.parseInt(getTagValue("age4aCtypeChildCnt", elem)));
            vo.setAge5aCtypeChildCnt(Integer.parseInt(getTagValue("age5aCtypeChildCnt", elem)));
            vo.setAge6aCtypeChildCnt(Integer.parseInt(getTagValue("age6aCtypeChildCnt", elem)));
            vo.setAge7aCtypeChildCnt(Integer.parseInt(getTagValue("age7aCtypeChildCnt", elem)));
            vo.setAge8aCtypeChildCnt(Integer.parseInt(getTagValue("age8aCtypeChildCnt", elem)));
            vo.setAge9aCtypeChildCnt(Integer.parseInt(getTagValue("age9aCtypeChildCnt", elem)));
            vo.setAge10aCtypeChildCnt(Integer.parseInt(getTagValue("age10aCtypeChildCnt", elem)));
            vo.setAge11aCtypeChildCnt(Integer.parseInt(getTagValue("age11aCtypeChildCnt", elem)));
            vo.setAge12aCtypeChildCnt(Integer.parseInt(getTagValue("age12aCtypeChildCnt", elem)));

            vo.setAge0aDtypeChildCnt(Integer.parseInt(getTagValue("age0aDtypeChildCnt", elem)));
            vo.setAge1aDtypeChildCnt(Integer.parseInt(getTagValue("age1aDtypeChildCnt", elem)));
            vo.setAge2aDtypeChildCnt(Integer.parseInt(getTagValue("age2aDtypeChildCnt", elem)));
            vo.setAge3aDtypeChildCnt(Integer.parseInt(getTagValue("age3aDtypeChildCnt", elem)));
            vo.setAge4aDtypeChildCnt(Integer.parseInt(getTagValue("age4aDtypeChildCnt", elem)));
            vo.setAge5aDtypeChildCnt(Integer.parseInt(getTagValue("age5aDtypeChildCnt", elem)));
            vo.setAge6aDtypeChildCnt(Integer.parseInt(getTagValue("age6aDtypeChildCnt", elem)));
            vo.setAge7aDtypeChildCnt(Integer.parseInt(getTagValue("age7aDtypeChildCnt", elem)));
            vo.setAge8aDtypeChildCnt(Integer.parseInt(getTagValue("age8aDtypeChildCnt", elem)));
            vo.setAge9aDtypeChildCnt(Integer.parseInt(getTagValue("age9aDtypeChildCnt", elem)));
            vo.setAge10aDtypeChildCnt(Integer.parseInt(getTagValue("age10aDtypeChildCnt", elem)));
            vo.setAge11aDtypeChildCnt(Integer.parseInt(getTagValue("age11aDtypeChildCnt", elem)));
            vo.setAge12aDtypeChildCnt(Integer.parseInt(getTagValue("age12aDtypeChildCnt", elem)));

            service.insertBabysitterChildOld(vo);

        }
        resultMap.put("status", true);
        resultMap.put("message", "데이터가 입력되었습니다.");
        return resultMap;
    }
    // localhost:8888/api/childOld?data=asd
    @GetMapping("/api/childOld")
    public Map<String, Object> getChildOld(@RequestParam String date) {
        System.out.println(date);
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        List<OldVO> list = service.selectBabysitterChildOld(date);
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
