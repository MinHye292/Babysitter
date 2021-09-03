package cat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cat.vo.SitterVO.MapInfoVO;
import cat.vo.SitterVO.ProviderVO;
import cat.vo.SitterVO.SitterVO;

@Mapper
public interface SitterMapper {
    public void insertSitter(SitterVO vo);
    public MapInfoVO selectMap(Integer seq);
    public List<ProviderVO> selectProvider();
}
