package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; // 수정된 임포트 구문

public class MemberDao {
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs; // 수정된 타입
    
    public MemberDao() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public int login(String userID, String userPassword) {
        String SQL = "SELECT userPassword FROM WHERE userID = ?"; // 수정된 SQL 구문
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID);
            rs = pstmt.executeQuery(); // 수정된 호출 방식
            
            if(rs.next()) {
                if(rs.getString(1).equals(userPassword)) { // 컬럼 이름으로 접근
                    return 1; // 로그인 성공
                } else {
                    return 0; // 비밀번호 불일치
                }
            }
            return -1; // 아이디 없음
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -2; // 데이터베이스 오류
    }
}