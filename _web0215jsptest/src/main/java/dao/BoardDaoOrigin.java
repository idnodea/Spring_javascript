package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Board;

public class BoardDaoOrigin {
	
	private static BoardDaoOrigin dao = new BoardDaoOrigin();
	private BoardDaoOrigin() {} // 생성자
	public static BoardDaoOrigin getInstance() {
		return dao;
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
        		"jdbc:mysql://localhost:3306/project1", "root", "mysql");
		return conn;
	}
	
	//던지기나 필드하면 된다는 건 알지만...
	//문자열이기 때문에, 자바설계상 일단 찾아보기 때문임->
	//mysql문구지만. 문구인걸 알아서 api처리는 해주지만.
	
	//여기서의 this는
	//Class.forName("com.mysql.cj.jdbc.Driver");
	//Connection conn = DriverManager.getConnection(
    //"jdbc:mysql://localhost:3306/project1", "root", "mysql");
    //PreparedStatement pstmt = this.getConnection.prepareStatement(sql);

	public ArrayList<Board> selectList() {
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select * from board order by num desc";
		PreparedStatement pstmt;
		try {
			pstmt = this.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Board board = new Board(rs.getInt("num"), rs.getString("writer"), 
						rs.getString("title"), rs.getString("content"),
						rs.getString("regtime"), 0);
				list.add(board);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	
}
















