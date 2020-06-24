package OOSE.db;

import OOSE.model.Authority;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class AuthorityDBManager extends DBConnector
{
    public ArrayList<Authority> browseAuthority()
    {
        try
        {
            String query="select * from oose.authority";
            pstmt = conn.prepareStatement(query);

            ArrayList<Authority> list = new ArrayList<Authority>();
            res = pstmt.executeQuery();
            while(res.next())
            {
                Authority i = new Authority();
                i.setId(res.getInt("authorityId"));
                i.setName(res.getString("authorityName"));
                i.setAccessRange(res.getString("accessRange"));
                list.add(i);
            }
            return list;
        }
        catch(SQLException e)       //오류가 발생하면 null return
        {
            e.getStackTrace();
            return null;
        }
    }

    public boolean deleteAuthority(int authorityId)
    {
        try
        {
            String query="call deleteAuthority(?)";
            pstmt=conn.prepareStatement(query);
            pstmt.setString(1, Integer.toString(authorityId));
            pstmt.executeQuery();
            return true;
        }
        catch(SQLException e)
        {
            e.getStackTrace();
            return false;   //삭제 실패
        }
    }
    public int findAuthority()
    {
        try
        {
            String query = "select authorityId from oose.authority where accessRange like '%권한관리%'";
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
