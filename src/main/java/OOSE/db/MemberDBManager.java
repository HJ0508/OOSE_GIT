package OOSE.db;

import OOSE.model.Member;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDBManager extends OOSE.db.DBConnector
{
    private DBConnector dbManager=new DBConnector();      //어딘가에 생성된 DBConnect 객체를 가져와서 써야되는데 거기는 이해가 잘 안가서 일단 이렇게 새로 만드는 쪽으로 했음
    private int authority;      //권한정보, 미리 디폴트로 값이 저장되어 있어야함

    boolean registerMemberInfo(Member member)     //dB에 회원 정보를 저장
    {
        try
        {
            //회원 테이블에 정보 입력
            String query = "INSERT INTO member(memberId,memberName,password,authority,phoneNumber) VALUES (?,?,?,?,?)";
            dbManager.getPstmt().getConnection().prepareStatement(query);     //DBConnect의 패키지명이 잘못돼서 나는 오류임 ㅇㅇ
            dbManager.getPstmt().setString(1,member.getId());
            dbManager.getPstmt().setString(2,member.getName());
            dbManager.getPstmt().setString(3,member.getPassword());
            dbManager.getPstmt().setString(4,"1");        //권한 레벨은 추후에 정해지면 고칠것, 일단 임의로 1레벨 줬음. string값으로 줘야되는지, int값으로 줘야되는지 잘 모르겠음
            dbManager.getPstmt().setString(5,member.getPhoneNum());

            dbManager.getPstmt().executeUpdate();

            //사용자 테이블에 정보 입력
            query = "INSERT INTO user(userId, userIdentify) values(?,?)";
            dbManager.getPstmt().getConnection().prepareStatement(query);
            dbManager.getPstmt().setString(1, member.getId());
            dbManager.getPstmt().setString(2, "1");   //회원의 identify 임의로 1로 지정

            dbManager.getPstmt().executeUpdate();       //executeUpdate()의 insert 반환값은 저장된 레코드 수 이다
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return false;   //sql 오류로 등록 실패했으니 false return
        }
        return true;    //오류가 안나면 true를 return
    }
    boolean checkAuthority(String id)
    {
        try
        {
            String query="{call browseAuthority(?)}";       //저장 프로시저 사용
            dbManager.getPstmt().getConnection().prepareStatement(query);
            dbManager.getPstmt().setString(1,id);

            dbManager.setRes(dbManager.getPstmt().executeQuery());

            int authority = dbManager.getRes().getInt("authority");

            if(authority>this.authority)          //권한 레벨에 대한 정보에 따라 검사 내용이 달라지기 때문에 아직 안적음.
                return true;        //권한이 있다고 판정된 경우
            else
                return false;       //권한이 없다고 판정된 경우
            //
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return false;
        }
    }
}
