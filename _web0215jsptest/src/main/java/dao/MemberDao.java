package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mvjsp.board.model.Member;
import mvjsp.jdbc.JdbcUtil;

public class MemberDao {
    // 싱글턴
    private static MemberDao instance = new MemberDao();

    public static MemberDao getInstance() {
        return instance;
    }

    private MemberDao() {
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

    public ArrayList<Member> selectAll(Connection conn) {
        ArrayList<Member> mList = new ArrayList<>();
        String mSql = "select * from member";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
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
        }
        return mList;
    }

    public int insert(Connection conn, Member member) {
        String mSql = "insert into member(memberno,id, email, name) values (seq_member.nextval,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(mSql)) {

            // 쿼리 실행
            pstmt.setString(1, member.getId());

            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getName());
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Connection conn, Member member) {
        String mSql = "update member set email = ?, name = ? where memberno = ?";
        // 프라이머리키로 업데이트
        try (PreparedStatement pstmt = conn.prepareStatement(mSql)) {

            // 쿼리 실행
            pstmt.setInt(3, member.getMemberno()); // 위의 3번 물음표.
            // pstmt.setString(1, member.getId());

            pstmt.setString(1, member.getEmail());
            pstmt.setString(2, member.getName());
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(Connection conn, int memberno) {
        String mSql = "delete from member where memberno=?";
        // 프라이머리키로 업데이트
        try (PreparedStatement pstmt = conn.prepareStatement(mSql)) {

            // 쿼리 실행
            pstmt.setInt(1, memberno);
            // pstmt.setString(1, member.getId());
            // pstmt.setString(1, member.getEmail());
            // pstmt.setString(2, member.getName());
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Member select(Connection conn, int memberno) {
        Member member = null;
        ResultSet rs = null;
        String mSql = "select * from member where memberno = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(mSql)) {

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

        }
        return member;

    }

    // 새로운 쿼리 추가
    public Member selectForLogin(Connection conn, String id, String email) {
        Member member = null;
        String mSql = "select * from member where id = ? and email = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(mSql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                member = new Member(rs.getInt("memberno"), rs.getString("id"), rs.getString("email"),
                        rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }
}