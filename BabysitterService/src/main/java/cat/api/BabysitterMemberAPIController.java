package cat.api;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
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

import cat.service.BabysitterMemberService;
import cat.vo.MemberVO.MemberVO;

@RestController
public class BabysitterMemberAPIController {
    @Autowired
    BabysitterMemberService service;
    @GetMapping("/api/member")
    public Map<String, Object> getMember(
        @RequestParam String crtrYmFrom, @RequestParam String crtrYmTo
        ) throws Exception{
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1383000/idis/memberService/getMemberList");
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

            System.out.println(getTagValue("crtrYm", elem));
            System.out.println(getTagValue("upChildCareInstNm", elem));
            System.out.println(getTagValue("childCareInstNo", elem));
            System.out.println(getTagValue("whlMbrCnt", elem));

            String upChildCareInstNm = getTagValue("upChildCareInstNm", elem);
            String childCareInstNo = getTagValue("childCareInstNo", elem);

            MemberVO vo = new MemberVO();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
            Date dt = formatter.parse(getTagValue("crtrYm", elem));
                
            vo.setCrtrYm(dt);

            vo.setUpChildCareInstNm(upChildCareInstNm);
            vo.setChildCareInstNo(childCareInstNo);
            vo.setWhlMbrCnt(Integer.parseInt(getTagValue("whlMbrCnt", elem)));

            service.insertBabysitterMember(vo);

        }
        resultMap.put("status", true);
        resultMap.put("message", "데이터가 입력되었습니다.");
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
