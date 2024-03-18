//package dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import dto.Member;
//
//public class MemberDao {
//    private static Connection conn;
//    private static MemberDao memberDao = new MemberDao();
//
//    private MemberDao() {
//    } // 생성자
//
//    public static MemberDao getInstance() {
//        MemberDao.getConnection();
//        return memberDao;
//    }
//
//    private static void getConnection() {
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            conn = DriverManager.getConnection(
//                    "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Member selectForLogin(String id, String email) {
//        Member member = null;
//        String mSql = "select * from member where id = ? and email = ?";
//        try (PreparedStatement pstmt = conn.prepareStatement(mSql)) {
//            pstmt.setString(1, id);
//            pstmt.setString(2, email);
//            ResultSet rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//                member = new Member(rs.getInt("memberno"), rs.getString("id"), rs.getString("email"),
//                        rs.getString("name"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return member;
//    }
//
//    public Member select(String id) {
//        Member member = null;
//        String mSql = "select * from member where id = ?";
//        try (PreparedStatement pstmt = conn.prepareStatement(mSql)) {
//            pstmt.setString(1, id);
//            ResultSet rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//                member = new Member(rs.getInt("memberno"), rs.getString("id"), rs.getString("email"),
//                        rs.getString("name"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return member;
//    }
//
//    public int insert(Member member) {
//        String mSql = "insert into member(id, email, name) values (?,?,?)";
//        try (PreparedStatement pstmt = conn.prepareStatement(mSql)) {
//
//            // 쿼리 실행
//            pstmt.setString(1, member.getId());
//            pstmt.setString(2, member.getEmail());
//            pstmt.setString(3, member.getName());
//            return pstmt.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    public int update(Member member) {
//        String mSql = "update member set email = ?, name = ? where id = ?";
//        try (PreparedStatement pstmt = conn.prepareStatement(mSql)) {
//
//            // 쿼리 실행
//            pstmt.setString(1, member.getEmail());
//            pstmt.setString(2, member.getName());
//            pstmt.setString(3, member.getId());
//            return pstmt.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    public Member selectMember(String id) { // 회원 정보 수정을 위한 값 가져오기
//        Member member = null;
//        String sql = "select * from member where id = ?";
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, id);
//            ResultSet rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//                member = new Member(rs.getInt("memeberno"), rs.getString("id"), rs.getString("email"),
//                        rs.getString("name"));
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return member;
//    }
//
//}
package dao;

