package cat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.mapper.BabysitterMapper;
import cat.vo.BabysitterMonthlyTimeVO;
import cat.vo.BabysitterRegionVO;
import cat.vo.BabysitterTimeVO;

@Service
public class BabysitterService {
    @Autowired
    BabysitterMapper mapper;
    public void insertBabysitterTime(BabysitterTimeVO vo){
        mapper.insertBabysitterTime(vo);
    }
    public List<BabysitterMonthlyTimeVO> selectBabysitterMonthlyTime(String date){
        return mapper.selectBabysitterMonthlyTime(date);
    }
    public List<BabysitterRegionVO> selectBabysitterRegion(String date){
        return mapper.selectBabysitterRegion(date);
    }
}
