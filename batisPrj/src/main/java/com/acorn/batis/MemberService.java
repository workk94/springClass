package com.acorn.batis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    public int getTotalMemberCount() throws Exception {
        return memberDao.count();
    }

    
    public List<Member> getAllMembers() throws Exception {
        return memberDao.selectAll();
    }

    public int deleteAllMembers() throws Exception {
        return memberDao.deleteAll();
    }

    public int deleteMemberById(String memberId) throws Exception {
        return memberDao.delete(memberId);
    }

   
    public int registerNewMember(Member member) throws Exception {
         int rCnt=   memberDao.insert(member);         
          return rCnt;
    }

    public Member getMemberById(Integer memberId) throws Exception {
        return memberDao.select(memberId);
    }

    public int modifyMemberInfo(Member member) throws Exception {
        return memberDao.update(member);
    }
}
