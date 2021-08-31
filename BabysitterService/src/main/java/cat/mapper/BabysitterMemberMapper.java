package cat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cat.vo.MemberVO.MemberCntVO;
import cat.vo.MemberVO.MemberVO;

@Mapper
public interface BabysitterMemberMapper {
    public void insertMember(MemberVO vo);
    public List<MemberCntVO> selectregionCnt(String region, String date);
}
