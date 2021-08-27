package cat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.mapper.BabysitterMemberMapper;
import cat.vo.MemberVO.MemberVO;

@Service
public class BabysitterMemberService {
    @Autowired
    BabysitterMemberMapper mapper;
    public void insertBabysitterMember(MemberVO vo){
        mapper.insertBabysitterMember(vo);
    }
}
