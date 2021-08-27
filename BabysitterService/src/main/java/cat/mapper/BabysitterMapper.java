package cat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cat.vo.BabysitterMonthlyTimeVO;
import cat.vo.BabysitterRegionVO;
import cat.vo.BabysitterTimeVO;

@Mapper
public interface BabysitterMapper {
    public void insertBabysitterTime(BabysitterTimeVO vo);
    public List<BabysitterMonthlyTimeVO> selectBabysitterMonthlyTime(String date);
    public List<BabysitterRegionVO> selectBabysitterRegion(String date);
}