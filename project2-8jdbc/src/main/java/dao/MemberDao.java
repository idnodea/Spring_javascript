package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.Member;
import mvjsp.jdbc.JdbcUtil;

public class MemberDao {
    // 싱글턴
    private static MemberDao instance = new MemberDao();

    public static MemberDao getInstance() {
        return instance;
    }

    private MemberDao() {
    }

    private static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // 예외 처리 필요
        }
        return conn;
    }
    
    public int selectCount(Connection conn) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select count(*) from member");
            rs.next();
            return rs.getInt(1);
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(stmt);
        }
    }

    public ArrayList<Member> selectAll() {
        ArrayList<Member> mList = new ArrayList<>();
        String mSql = "select * from member";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(mSql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Member member = new Member(rs.getInt("memberno"), rs.getString("id"), rs.getString("email"),
                        rs.getString("name"));
                mList.add(member);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
            JdbcUtil.close(conn);
        }
        return mList;
    }

    public int insert(Member member) {
        String mSql = "insert into member(memberno,id, email, name) values (seq_member.nextval,?,?,?)";
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(mSql);
            // 쿼리 실행
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getName());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn);
        }
        return 0;
    }

    public int update(Member member) {
        String mSql = "update member set email = ?, name = ? where memberno = ?";
        Connection conn = null;
        // 프라이머리키로 업데이트
        try {
            conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(mSql);
            // 쿼리 실행
            pstmt.setInt(3, member.getMemberno()); // 위의 3번 물음표.
            // pstmt.setString(1, member.getId());
            pstmt.setString(1, member.getEmail());
            pstmt.setString(2, member.getName());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn);
        }
        return 0;
    }

    public int delete(int memberno) {
        String mSql = "delete from member where memberno=?";
        Connection conn = null;
        // 프라이머리키로 업데이트
        try {
            conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(mSql);
            // 쿼리 실행
            pstmt.setInt(1, memberno);
            // pstmt.setString(1, member.getId());
            // pstmt.setString(1, member.getEmail());
            // pstmt.setString(2, member.getName());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn);
        }
        return 0;
    }

    public Member select(int memberno) {
        Member member = null;
        ResultSet rs = null;
        String mSql = "select * from member where memberno = ?";
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(mSql);
            pstmt.setInt(1, memberno);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                member = new Member(rs.getInt("memberno"), rs.getString("id"), rs.getString("email"),
                        rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(conn);
        }
        return member;
    }
    public Member selectMember(int memberno) {
        Member member = null;
        ResultSet rs = null;
        String mSql = "select * from member where memberno = ?";
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(mSql);
            pstmt.setInt(1, memberno);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                member = new Member(rs.getInt("memberno"), rs.getString("id"), rs.getString("email"),
                        rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(conn);
        }
        return member;
    }
    
    
    // 새로운 쿼리 추가
    public Member selectForLogin(String id, String email) {
        Member member = null;
        String mSql = "select * from member where id = ? and email = ?";
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(mSql);
            pstmt.setString(1, id);
            pstmt.setString(2, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                member = new Member(rs.getInt("memberno"), rs.getString("id"), rs.getString("email"),
                        rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn);
        }
        return member;
    }
}