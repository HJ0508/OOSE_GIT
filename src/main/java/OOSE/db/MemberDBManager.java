package OOSE.db;

import OOSE.model.Member;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

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
            pstmt.setInt(4,1);        //1레벨
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

    public boolean checkDuplicationInfo(String id)      //회원정보 중복 체크
    {
        try {
            String query = "select memberId from oose.member where memberId=?";
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, id);
            res = pstmt.executeQuery();

            while (res.next())
            {
                if(res.getString("memberId").equals(id))
                    return true;       //중복 있음
            }
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return true;
        }
        return false;        //중복 없음
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
                return true;        //성공
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
            return true;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            System.out.println("error");
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
    public boolean checkMissingInfo(Member member)      //입력값 빠진거 확인
    {
        if(member.getId().equals(null) ||member.getId().equals(""))
            return false;
        if(member.getName().equals(null)||member.getName().equals(""))
            return false;
        if(member.getPassword().equals(null)||member.getPassword().equals(""))
            return false;
        if(member.getPhoneNum().equals(null)||member.getPhoneNum().equals(""))
            return false;
        return true;
    }
    public boolean checkFormat(Member member)       //형식 체크
    {
        if(member.getId().length()>20)  //db에 20글자 이상 안들어감
            return false;          //형식 안맞음
        if(member.getName().length()>20)
            return false;
        if(member.getPassword().length()>20)
            return false;
        if(member.getPhoneNum().length()>20)
            return false;
        String regExp="(\\d{3})-(\\d{4})-(\\d{4})";        //전화번호 체크 정규식
        if(!Pattern.matches(regExp,member.getPhoneNum()))    //형식에 안맞으면
            return false;

        return true;        //위의 형식을 모두 통과하면 true 반환
    }
    public int findAuthority(String range)
    {
        try
        {
            String query = "select authorityId from oose.authority where accessRange like '%" + range + "%'";
            pstmt = conn.prepareStatement(query);
            res= pstmt.executeQuery();

            ArrayList<Integer> authorityArray =new ArrayList<Integer>();

            while(res.next())
            {
                authorityArray.add(res.getInt("authorityId"));
            }
            return maxAuthority(authorityArray);
        }
        catch(SQLException e)
        {
            e.getStackTrace();
        }
        return -1;
    }
    public int maxAuthority(ArrayList<Integer> list)
    {
        Collections.sort(list);  //정렬
        return list.get(list.size()-1);   //가장 마지막 값이
    }
}
