package cat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.mapper.BabysitterMemberMapper;
import cat.vo.MemberVO.MemberCntVO;
import cat.vo.MemberVO.MemberVO;

@Service
public class BabysitterMemberService {
    @Autowired
    BabysitterMemberMapper mapper;
    public void insertMember(MemberVO vo){
        mapper.insertMember(vo);
    }
    public List<MemberCntVO> selectregionCnt(String date){
        return mapper.selectregionCnt(date);
    }
}
