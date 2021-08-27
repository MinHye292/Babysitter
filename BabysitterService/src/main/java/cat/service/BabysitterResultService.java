package cat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.mapper.BabysitterResultMapper;
import cat.vo.ResultVO.BabysitterResultChildVO;
import cat.vo.ResultVO.BabysitterResultVO;
import cat.vo.ResultVO.ChildOldVO;
import cat.vo.ResultVO.OldVO;
import cat.vo.ResultVO.TypeVO;

@Service
public class BabysitterResultService {
    @Autowired
    BabysitterResultMapper mapper;
    public void insertBabysitterResult(BabysitterResultVO vo){
        mapper.insertBabysitterResult(vo);
    }
    public List<BabysitterResultChildVO> selectBabysitterChild(String date, String region){
        return mapper.selectBabysitterChild(date, region);
    }
    public List<String> selectBabysitterResultDates() {
        return mapper.selectBabysitterResultDates();
    }
    public BabysitterResultChildVO selectBabysitterChildGen(String date, String region){
        return mapper.selectBabysitterChildGen(date, region);
    }
    public void insertBabysitterChildOld(ChildOldVO vo){
        mapper.insertBabysitterChildOld(vo);
    }
    public List<OldVO> selectBabysitterChildOld(String date){
        return mapper.selectBabysitterChildOld(date);
    }
    public List<TypeVO> selectBabysitterType(String date){
        return mapper.selectBabysitterType(date);
    }
}
