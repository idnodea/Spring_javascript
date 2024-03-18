package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; // 수정된 임포트 구문

import dto.Member;


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
    
    public int login(String memberID, String memberPassword) {
        // SQL 쿼리 수정: memberID를 사용하여 사용자 검색
        String sql ="SELECT memberPassword FROM member0305 WHERE memberID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberID); // memberID로 사용자 검증
            rs = pstmt.executeQuery(); // 쿼리 실행
            
            if(rs.next()) {
                if(rs.getString("memberPassword").equals(memberPassword)) { // 비밀번호 일치 확인
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
    
    public int join(Member member) {
        // SQL 쿼리 수정: 컬럼 이름에 대한 인용 부호 제거 및 올바른 컬럼 이름 사용
    	String sql = "INSERT INTO member0305 (memberno, memberId, memberPassword, memberName, memberGender, memberEmail) "
    	           + "VALUES (seq_member0305.nextval, ?, ?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getMemberID()); // 수정된 메소드 호출 방식
            pstmt.setString(2, member.getMemberPassword());
            pstmt.setString(3, member.getMemberName());
            pstmt.setString(4, member.getMemberGender());
            pstmt.setString(5, member.getMemberEmail());

            return pstmt.executeUpdate(); // SQL 실행 후 영향 받은 행의 수 반환
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1; // 데이터베이스 오류
    }
    
}