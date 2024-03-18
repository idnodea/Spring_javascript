package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDao {
	private Connection conn;
   // private PreparedStatement pstmt;
    private ResultSet rs; // 수정된 타입
    
    public BbsDao() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
//    public String getDate() {
//    	String sql ="select now()";
//      
//    	try {
//    		 PreparedStatement pstmt = conn.prepareStatement(sql);
//    		rs = pstmt.executeQuery();
//    		if(rs.next()) {
//    			return rs.getString(1);
//    		}
//    		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    	return "";  //데이터베이스 오류
//    }
    public String getDate() {
        String sql ="SELECT CURRENT_TIMESTAMP FROM DUAL";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";  //데이터베이스 오류
    }
    
    
    public int getNext() {
    	String sql ="select bbsID from bbs order by bbsID DESC";
      
    	try {
    		 PreparedStatement pstmt = conn.prepareStatement(sql);
    		rs = pstmt.executeQuery();
    		if(rs.next()) {
    			return rs.getInt(1)+1;
    		}
    		return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return -1;  //데이터베이스 오류
    }
    
    public int write(String bbsTitle,String userID, String bbsContent) {
    	String sql ="INSERT into bbs values(?,?,?,?,?,?)";
        
    	try {
    		 PreparedStatement pstmt = conn.prepareStatement(sql);
    		 pstmt.setInt(1, getNext());
    		 pstmt.setString(2, bbsTitle);
    		 pstmt.setString(3, userID);
    		 pstmt.setString(4, getDate());
    		 pstmt.setString(5, bbsContent);
    		 pstmt.setInt(6, 1);   //어베일러블, 첫작성시 보여지게끔 1

    		return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return -1;  //데이터베이스 오류
    	
    }
    
    public ArrayList<Bbs> getList(int pageNumber){
        String sql ="SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM bbs WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC) a WHERE ROWNUM <= 10) WHERE rnum >= ?";
        ArrayList<Bbs> list = new ArrayList<Bbs>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            int next = getNext() - (pageNumber - 1) * 10;
            pstmt.setInt(1, next);
            pstmt.setInt(2, (pageNumber-1)*10+1);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Bbs bbs = new Bbs();
                // 컬럼 값 설정
                list.add(bbs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;  //데이터베이스 오류
    }
    
//    public ArrayList<Bbs> getList(int pageNumber){
//    	String sql ="select * from bbs where bbsID"
//    			+ "< ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10";
//    	ArrayList<Bbs> list = new ArrayList<Bbs>();
//        
//    	try {
//    		 PreparedStatement pstmt = conn.prepareStatement(sql);
//    		 //
//    		 pstmt.setInt(1, getNext()- (pageNumber - 1) * 10); 
//    		
//    		 rs = pstmt.executeQuery();
//    		while(rs.next()) {   //결과가 나올때마다 인스턴스를 만들게끔
//    			Bbs bbs = new Bbs();
//    			bbs.setBbsID(rs.getInt(1));
//    			bbs.setBbsTitle(rs.getString(2));
//    			bbs.setUserID(rs.getString(3));
//    			bbs.setBbsDate(rs.getString(4));
//    			bbs.setBbsContent(rs.getString(5));
//    			bbs.setBbsAvailable(rs.getInt(6));
//    				
//    			list.add(bbs);
//    		}
//    		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    	return list;  //데이터베이스 오류
//    }
    
    //10페이지 넘어가거나 다음페이지 없을때
    public boolean nextPage(int pageNumber) {
    	String sql ="select * from bbs where bbsID < ? AND bbsAvailable = 1";
    	ArrayList<Bbs> list = new ArrayList<Bbs>();
        
    	try {
    		 PreparedStatement pstmt = conn.prepareStatement(sql); 
    		 pstmt.setInt(1, getNext()- (pageNumber - 1) * 10); 
    		 rs = pstmt.executeQuery();
    		 
    		if(rs.next()) {  //하나라도 존재하면
    			return true;
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return false;  //데이터베이스 오류

    }
    
    public Bbs getBbs(int bbsID) {
    	String sql ="select * from bbs where bbsID = ?";
    	
    	try {
    		 PreparedStatement pstmt = conn.prepareStatement(sql); 
    		 pstmt.setInt(1,bbsID); 
    		 rs = pstmt.executeQuery();
    		 
    		if(rs.next()) {  //하나라도 존재하면
    			Bbs bbs = new Bbs();
    			bbs.setBbsID(rs.getInt(1));
    			bbs.setBbsTitle(rs.getString(2));
    			bbs.setUserID(rs.getString(3));
    			bbs.setBbsDate(rs.getString(4));
    			bbs.setBbsContent(rs.getString(5));
    			bbs.setBbsAvailable(rs.getInt(6));
    			
    			return bbs;
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;  //데이터베이스 오류
    }
    
    public int update(int bbsID, String bbsTitle, String bbsContent) {
    	String sql ="UPDATE bbs SET bbsTitle=?, bbsContent=?, where bbsID =?";
        
    	try {
    		 PreparedStatement pstmt = conn.prepareStatement(sql);
    		 
    		 pstmt.setString(1, bbsTitle);
    		 pstmt.setString(2, bbsContent);
    		 pstmt.setInt(3, bbsID);
    		return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return -1;  //데이터베이스 오류
    	
    }
    
    public int delete(int bbsID) {
    	String sql ="UPDATE bbs SET bbsAvailable=0 where bbsID =?";
        
    	try {
    		 PreparedStatement pstmt = conn.prepareStatement(sql);
    		 
    		 pstmt.setInt(1, bbsID);
    		return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return -1;  //데이터베이스 오류
    }
}
