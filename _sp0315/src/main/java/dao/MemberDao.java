package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;



import dto.MemberDto;
import jdbcUtill.JdbcUtil;



@Repository  //dao는 컴포말고 리포지토리를 자주 쓴다
public class MemberDao {

//    public static BoardDao getInstance() {   싱글톤접속 안 쓴다.
//        return instance;
//    }
	
	
	private Connection getConnection() throws Exception {
	    Statement stmt = null;
	    ResultSet rs = null;
	    PreparedStatement pstmt = null;
	    Connection conn = null; // conn을 try 블록 바깥에 선언
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/project2", "root", "mysql");
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        JdbcUtil.close(rs);
	        JdbcUtil.close(stmt);
	        JdbcUtil.close(pstmt);
	    }
	    return conn; // 수정된 위치
	}

	// 현재 시간을 문자열 형태로 반환
    //private String getCurrentTime() {
    //    return LocalDate.now() + " " +
    //           LocalTime.now().toString().substring(0, 8);
    //}

    // 멤버인원수
    public int getNumRecords() {
        int numRecords = 0;

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "select count(*) from member");
        ) {
            if (rs.next()) {
                numRecords =  rs.getInt(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return numRecords;
    }

    // 멤버 리스트 읽기
    public ArrayList<MemberDto> selectList(int start, int listSize) {

        ArrayList<MemberDto> dtoList = new ArrayList<MemberDto>();

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(String.format(
                    "select * from member order by memberno desc limit %d, %d",
                    start, listSize));
        ) {
            while (rs.next()) {

                // 새 DTO 객체를 만들고 멤버 데이터를 이 객체에 저장
            	MemberDto dto = new MemberDto();

                dto.setMemberno    (rs.getInt   ("memberno" ));
                dto.setId (rs.getString("id" ));
                dto.setPw  (rs.getString("pw"  ));
                dto.setName(rs.getString("name"));

                // 이 DTO 객체를 ArrayList에 추가
                dtoList.add(dto);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return dtoList;
    }

    // 지정된 멤버 번호를 가진 레코드 읽기
    public MemberDto selectOne(int memberno) {
    	MemberDto dto = null;
        //MemberDto dto = new MemberDto();
        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "select * from member where memberno=" + memberno);
        ) {
            if (rs.next()) {
                 dto = new MemberDto();
                // 글 데이터를 DTO에 저장
            	dto.setMemberno    (rs.getInt   ("memberno" ));
                dto.setId (rs.getString("id" ));
                dto.setPw  (rs.getString("pw"  ));
                dto.setName(rs.getString("name"));

            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return dto;
    }

    //지정된 id, pw를 가진 레코드 읽기
    public MemberDto selectMember(String id, String pw) {

    	MemberDto dto = new MemberDto();
        String sql = "select * from member where id =? and pw=? ";
        try (
            Connection conn = getConnection();
//            PreparedStatement pstmt = conn.createStatement();
        		 PreparedStatement pstmt = conn.prepareStatement(sql);
        		
//        		pstmt.setString(1, id);
//        		pstmt.setString(2, pw);
//        		
//        			ResultSet rs = pstmt.executeQuery();
        ) {
        	 
        	pstmt.setString(1, id);
    		pstmt.setString(2, pw);
    		ResultSet rs = pstmt.executeQuery();
    		
            if (rs.next()) {

                // 글 데이터를 DTO에 저장
            	dto.setMemberno    (rs.getInt   ("memberno" ));
                dto.setId (rs.getString("id" ));
                dto.setPw  (rs.getString("pw"  ));
                dto.setName(rs.getString("name"));

            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return dto;
    }
    
    // DTO에 담긴 내용으로 새로운 레코드 저장
    public void insertOne(MemberDto dto) {

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(String.format(
                    "insert into member " +
                    "(id,pw,name)" +
                    "values ('%s', '%s', '%s')",
                    dto.getId(), dto.getPw(), dto.getName()));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // DTO에 담긴 내용으로 게시글 데이터 업데이트
    public void updateOne(MemberDto dto) {

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(String.format(
                    "update member set pw='%s', name ='%s' where memberno=%d",
                    
                    dto.getPw(), dto.getName(), dto.getMemberno()));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // 지정된 글 번호의 레코드 삭제
    public void deleteOne(int memberno) {

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate("delete from member where memberno=" +memberno);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
		
}
