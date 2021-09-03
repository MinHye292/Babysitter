package cat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.mapper.SitterMapper;
import cat.vo.SitterVO.MapInfoVO;
import cat.vo.SitterVO.ProviderVO;
import cat.vo.SitterVO.SitterVO;

@Service
public class SitterService {
    @Autowired
    SitterMapper mapper;
    
    public void insertSitter(SitterVO vo){
        mapper.insertSitter(vo);
    }
    public MapInfoVO selectMap(Integer seq){
        return mapper.selectMap(seq);
    }
    public List<ProviderVO> selectProvider(){
        return mapper.selectProvider();
    }
}
