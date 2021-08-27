package cat.mapper;

import org.apache.ibatis.annotations.Mapper;

import cat.vo.MemberVO.MemberVO;

@Mapper
public interface BabysitterMemberMapper {
    public void insertBabysitterMember(MemberVO vo);
    }

