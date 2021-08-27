package cat.vo.ResultVO;

import java.util.Date;

import lombok.Data;

@Data
public class BabysitterResultVO {
    private Date crtrYm;
    private String childCareInstNm;
    private String ilnsSrvcYn;
    private String careDvsnNm;
    private String srvcDvsfctnNm;
    private String upChildCareInstNm;
    private Integer childCnt;
    private Integer boyChildCnt;
    private Integer girlChildCnt;
}
