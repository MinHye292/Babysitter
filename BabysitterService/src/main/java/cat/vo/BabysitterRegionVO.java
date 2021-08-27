package cat.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data

// 누적 data를 지역으로 묶은 데이터
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BabysitterRegionVO {
    private Integer seq;
    private Date crtrYm;
    private String childCareInstNo;
    private String childCareInstNm;
    private String ilnsSrvcYn;
    private String careDvsnNm;
    private String srvcDvsfctnNm;
    private String upChildCareInstNo;
    private String upChildCareInstNm;
    private String grAplyNocs;
    private Integer hr02AplyNocs;
    private Integer hr24AplyNocs;
    private Integer hr46AplyNocs;
    private Integer hr68AplyNocs;
    private Integer hr810AplyNocs;
    private Integer hr1012AplyNocs;
    private Integer hr1214AplyNocs;
    private Integer hr1416AplyNocs;
    private Integer hr1618AplyNocs;
    private Integer hr1820AplyNocs;
    private Integer hr2022AplyNocs;
    private Integer hr2224AplyNocs;
    private Date dataCrtYmd;

    private String date;
    private String region;
    private Integer acc;
}
