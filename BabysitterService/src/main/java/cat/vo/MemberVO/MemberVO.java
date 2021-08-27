package cat.vo.MemberVO;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
    private Date crtrYm;
    private String childCareInstNo;
    private String upChildCareInstNm;
    private Integer whlMbrCnt;
}
