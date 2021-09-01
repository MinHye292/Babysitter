package cat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cat.vo.MemberVO.LoginVO;
import cat.vo.MemberVO.MemberInfoVO;

@Mapper
public interface MemberMapper {
    public void insertMember(MemberInfoVO vo);
    public Integer selectMemberById(String id);
    public Integer selectMemberByEmail(String email);
    public List<MemberInfoVO> selectMemberAll();
    public void deleteMember(Integer seq);

    public Integer loginMember(LoginVO vo);
    public MemberInfoVO selectMemberInfo(String id);
}
