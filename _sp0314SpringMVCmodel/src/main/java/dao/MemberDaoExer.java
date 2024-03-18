//package dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import dto.MemberDto;
//import lombok.AllArgsConstructor;
//
//@AllArgsConstructor
//public class MemberDao {
//	private static Connection conn;
//    private static MemberDao boardDao = new MemberDao();
//	
//	
//	public static MemberDao getInstance() {
//        if (conn == null) {
//            getConnection();
//            
//        }
//        return MemberDao;
//    }
//
//    private static void getConnection() {
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            conn = DriverManager.getConnection(
//                    "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            // 예외 처리 필요
//        }
//    }
//
//	
//	public getNumRecords(MemberDto memberdto){
//		
//	}
//}
package dao;


