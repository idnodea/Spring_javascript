package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.board.BoardDto;

import dto.Board;


public class BoardDao2 {
//	private Connection conn;
	public Connection conn;
	   // private PreparedStatement pstmt;
	    private ResultSet rs; // 수정된 타입
	    
	    public BoardDao2() {
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            conn = DriverManager.getConnection(
	                    "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	 // 현재 시간을 문자열 형태로 반환
//	    private String getCurrentTime() {
//	        return LocalDate.now() + " " +
//	               LocalTime.now().toString().substring(0, 8);
//	    }
	    
	    public String getDate() {
//	    	String sql ="select now()";
//	    	String SQL = "SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') FROM DUAL";
	    	String sql ="SELECT SYSDATE FROM DUAL";
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
	    	String sql ="select boardID from board0305 order by boardID DESC";
	      
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
	    
	    public int write(String boardTitle,String memberID, String boardContent) {
//	    	String sql ="INSERT into board values(?,?,?,?,?,?)";
	    	String sql = "INSERT INTO board0305 (boardID, boardTitle, memberID, boardDate, boardContent, boardAvailable) "
	                   + "VALUES (?, ?, ?, ?, ?, ?)";
	    	try {
	    		 PreparedStatement pstmt = conn.prepareStatement(sql);
	    		 pstmt.setInt(1, getNext());
	    		 pstmt.setString(2, boardTitle);
	    		 pstmt.setString(3, memberID);
	    		 pstmt.setString(4, getDate());
	    		 pstmt.setString(5, boardContent);
	    		 pstmt.setInt(6, 1);   //어베일러블, 첫작성시 보여지게끔 1

	    		return pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return -1;  //데이터베이스 오류
	    	
	    }
	    
	    
	    public ArrayList<Board> getList(int pageNumber){
	        int itemsPerPage = 10;
	        int startRow = (pageNumber - 1) * itemsPerPage + 1;
	        int endRow = pageNumber * itemsPerPage;

	        String sql = 
	            "SELECT * FROM (" + 
	            "  SELECT temp.*, ROWNUM rnum FROM (" + 
	            "    SELECT * FROM board0305 WHERE boardAvailable = 1 ORDER BY boardID DESC" + 
	            "  ) temp WHERE ROWNUM <= ?" + 
	            ") WHERE rnum >= ?";

	        ArrayList<Board> list = new ArrayList<Board>();
	        
	        try {
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, endRow);
	            pstmt.setInt(2, startRow);
	            rs = pstmt.executeQuery();
	            while(rs.next()){
	                Board board = new Board();
	                board.setBoardID(rs.getInt("boardID"));
	                board.setBoardTitle(rs.getString("boardTitle"));
	                board.setMemberID(rs.getString("memberID"));
	                board.setBoardDate(rs.getString("boardDate"));
	                board.setBoardContent(rs.getString("boardContent"));
	                board.setBoardAvailable(rs.getInt("boardAvailable"));
	                list.add(board);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	    
//	    public ArrayList<Board> getList(int pageNumber){
//	    	String sql ="select * from board where boardID"
//	    			+ "< ? AND boardAvailable = 1 ORDER BY boardID DESC LIMIT 10";
//	    	ArrayList<Board> list = new ArrayList<Board>();
//	        
//	    	try {
//	    		 PreparedStatement pstmt = conn.prepareStatement(sql);
//	    		 //
//	    		 pstmt.setInt(1, getNext()- (pageNumber - 1) * 10); 
//	    		
//	    		 rs = pstmt.executeQuery();
//	    		while(rs.next()) {   //결과가 나올때마다 인스턴스를 만들게끔
//	    			Board board = new Board();
//	    			board.setBoardID(rs.getInt(1));
//	    			board.setBoardTitle(rs.getString(2));
//	    			board.setMemberID(rs.getString(3));
//	    			board.setBoardDate(rs.getString(4));
//	    			board.setBoardContent(rs.getString(5));
//	    			board.setBoardAvailable(rs.getInt(6));
//	    				
//	    			list.add(board);
//	    		}
//	    		
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//	    	return list;  //데이터베이스 오류
//	    }
	    
	    //10페이지 넘어가거나 다음페이지 없을때
	    public boolean nextPage(int pageNumber) {
	    	String sql ="select * from board0305 where boardID < ? AND boardAvailable = 1";
	    	ArrayList<Board> list = new ArrayList<Board>();
	        
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
	    
	    public Board getBoard(int boardID) {
	    	String sql ="select * from board0305 where boardID = ?";
	    	
	    	try {
	    		 PreparedStatement pstmt = conn.prepareStatement(sql); 
	    		 pstmt.setInt(1,boardID); 
	    		 rs = pstmt.executeQuery();
	    		 
	    		if(rs.next()) {  //하나라도 존재하면
	    			Board board = new Board();
	    			board.setBoardID(rs.getInt(1));
	    			board.setBoardTitle(rs.getString(2));
	    			board.setMemberID(rs.getString(3));
	    			board.setBoardDate(rs.getString(4));
	    			board.setBoardContent(rs.getString(5));
	    			board.setBoardAvailable(rs.getInt(6));
	    			
	    			return board;
	    		}
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return null;  //데이터베이스 오류
	    }
	    
	 // 지정된 글 번호를 가진 레코드 읽기
	    // hitsIncreased가 true이면 해당 글의 조회수를 1 증가시킴
	    //                 false이면 조회수를 증가시키지 않음
	    public Board selectOne(int num, boolean hitsIncreased) {

	        Board dto = new Board();

	        try (
	            Connection conn = getConnection();
	            PreparedStatement pstmt = conn.prepareStatement();

	            ResultSet rs = pstmt.executeQuery(
	                    "select * from board0305 where num=" + num);
	        ) {
	            if (rs.next()) {

	                // 글 데이터를 DTO에 저장
//	                dto.setNum    (rs.getInt   ("num"    ));
//	                dto.setWriter (rs.getString("writer" ));
//	                dto.setTitle  (rs.getString("title"  ));
//	                dto.setContent(rs.getString("content"));
//	                dto.setRegtime(rs.getString("regtime"));
//	                dto.setHits   (rs.getInt   ("hits"   ));
	            	board.setBoardID(rs.getInt(1));
	    			board.setBoardTitle(rs.getString(2));
	    			board.setMemberID(rs.getString(3));
	    			board.setBoardDate(rs.getString(4));
	    			board.setBoardContent(rs.getString(5));
	    			board.setBoardAvailable(rs.getInt(6));
	    			board.setHits   (rs.getInt   ("hits"   ));
	            		
	                // 이글의 조회수를 증가시켜야 하는 경우
	                // (글 보기 화면을 위해 읽을 때)이면 조회수 1 증가
	                if (hitsIncreased) {
	                    pstmt.executeUpdate(
	                          "update board0305 set hits=hits+1 where boardID=" + 1);
	                }
	            }
	        } catch(Exception e) {
	            e.printStackTrace();
	        }

	        return board;
	    }
	    
	    
	    public int update(int boardID, String boardTitle, String boardContent) {
	    	String sql ="UPDATE board0305 SET boardTitle=?, boardContent=?, where boardID =?";
	        
	    	try {
	    		 PreparedStatement pstmt = conn.prepareStatement(sql);
	    		 
	    		 pstmt.setString(1, boardTitle);
	    		 pstmt.setString(2, boardContent);
	    		 pstmt.setInt(3, boardID);
	    		return pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return -1;  //데이터베이스 오류
	    	
	    }
	    
	    public int delete(int boardID) {
	    	String sql ="UPDATE board0305 SET boardAvailable=0 where boardID =?";
	        
	    	try {
	    		 PreparedStatement pstmt = conn.prepareStatement(sql);
	    		 
	    		 pstmt.setInt(1, boardID);
	    		return pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return -1;  //데이터베이스 오류
	    }
}
