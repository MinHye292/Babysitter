package cat.vo.ResultVO;

import java.util.Date;

import lombok.Data;

@Data
public class BabysitterResultChildVO {
    private Date crtrYm;
    private String region;
    private Integer acc;

    private Integer boyacc;
    private Integer girlacc;
}
