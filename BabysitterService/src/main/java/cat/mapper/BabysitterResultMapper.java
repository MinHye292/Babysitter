package cat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cat.vo.ResultVO.BabysitterResultVO;
import cat.vo.ResultVO.ChildOldVO;
import cat.vo.ResultVO.OldVO;
import cat.vo.ResultVO.BabysitterResultChildVO;

@Mapper
public interface BabysitterResultMapper {
    public void insertBabysitterResult(BabysitterResultVO vo);
    public List<BabysitterResultChildVO> selectBabysitterChild(String date, String region);
    // 결과가 1개로 나오니까 리스트로 받을 필요가 없고..
    public BabysitterResultChildVO selectBabysitterChildGen(String date, String region);
    public List<String> selectBabysitterResultDates();
    public void insertBabysitterChildOld(ChildOldVO vo);
    public List<OldVO> selectBabysitterChildOld(String date);
}
