package OOSE.db;

import OOSE.model.Member;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDBManager extends DBConnector
{
    private int authority=2;      //권한정보, 미리 디폴트로 값이 저장되어 있어야함

    public boolean registerMemberInfo(Member member)     //dB에 회원 정보를 저장
    {
        try
        {
            String query = "INSERT INTO oose.user(userId, userIdentify) values(?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, member.getId());
            pstmt.setInt(2, 1);   //회원의 identify 임의로 1로 지정
            pstmt.executeUpdate();

            //회원 테이블에 정보 입력
            query = "INSERT INTO oose.member(memberId,memberName,password,authority,phoneNumber) VALUES (?,?,?,?,?)";
            pstmt=conn.prepareStatement(query);
            pstmt.setString(1,member.getId());
            pstmt.setString(2,member.getName());
            pstmt.setString(3,member.getPassword());
            pstmt.setInt(4,1);        //1레벨 줬음. string값으로 줘야되는지, int값으로 줘야되는지 잘 모르겠음
            pstmt.setString(5,member.getPhoneNum());


            pstmt.executeUpdate();

            //사용자 테이블에 정보 입력
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return false;   //sql 오류로 등록 실패했으니 false return
        }
        return true;    //오류가 안나면 true를 return
    }

    public boolean modifyMemberInfo(Member member)
    {
        try
        {
            String query="UPDATE oose.member set memberName=?,password=?,authority=?,phoneNumber=? where memberId=?";
            pstmt=conn.prepareStatement(query);

            pstmt.setString(1,member.getName());
            pstmt.setString(2, member.getPassword());
            pstmt.setInt(3, member.getAuthority());
            pstmt.setString(4, member.getPhoneNum());
            pstmt.setString(5, member.getId());

            if(pstmt.executeUpdate()!=0)
                return true;
            else
                return false;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return false;
        }
    }

    public boolean deleteMemberInfo(Member member)
    {
        try
        {
            String query = "delete from oose.member where memberId=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, member.getId());
            int result = pstmt.executeUpdate();

            query = "delete from oose.user where userId=?";     //사용자 테이블에서도 정보 삭제
            pstmt=conn.prepareStatement(query);
            pstmt.setString(1, member.getId());
            pstmt.executeUpdate();
//            if(pstmt.executeUpdate()!=0)       //업데이트에 성공했을 경우
//                return true;
//            else
//                return false;
            return true;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            System.out.println("error");
            return false;
        }
    }

    public boolean checkAuthority(String id)
    {
        try
        {
            String query="{call browseAuthority(?)}";       //저장 프로시저 사용
            pstmt=conn.prepareStatement(query);
            pstmt.setString(1,id);
            res=pstmt.executeQuery();

            int authority = res.getInt("authority");

            if(authority>this.authority)          //권한 레벨에 대한 정보에 따라 검사 내용이 달라지기 때문에 아직 안적음.
                return true;        //권한이 있다고 판정된 경우
            else
                return false;       //권한이 없다고 판정된 경우
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return false;
        }
    }

    public ArrayList<Member> browseMemberList()
    {
        try
        {
            String query="SELECT * from oose.member";
            pstmt=conn.prepareStatement(query);
            res=pstmt.executeQuery();

            ArrayList<Member> list=new ArrayList<Member>();     //실행한 객체를 담을 list

            while(res.next())       //얻어온 테이블의 행이 끝날때 까지
            {
                Member member=new Member();

                member.setId(res.getString("memberId"));
                member.setPassword(res.getString("password"));
                member.setName(res.getString("memberName"));
                member.setAuthority(res.getInt("authority"));
                member.setPhoneNum(res.getString("phoneNumber"));

                list.add(member);
            }
            return list;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }
    public Member browseMemberInfo(Member member)
    {
        try
        {
            String query= "select * from oose.member where memberId=?";
            pstmt=conn.prepareStatement(query);
            pstmt.setString(1, member.getId());

            res = pstmt.executeQuery();

            while(res.next())
            {
                member.setName(res.getString("memberName"));
                member.setAuthority(res.getInt("authority"));
                member.setPassword(res.getString("password"));
                member.setPhoneNum(res.getString("phoneNumber"));
            }
            return member;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return null;
        }
    }
}
