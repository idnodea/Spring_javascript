package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetTodos
 */
@WebServlet("/GetTodos")
public class GetTodos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTodos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//할 일 목록을 가져오는 코드
		//이 예시에서는 단순히 두 개의 할 일을 반환합니다.
		List<String> todos = Arrays.asList("첫번째 할 일", "Second task");  //표시를 편하게
//		List<String> todos2 = Arrays.asList("설거지", "청소","공부");  //표시를 편하게
		
		response.setContentType("application/json");  //json
		//response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
	
		PrintWriter out = response.getWriter(); //import해줄 것
//		out.print("<h1>안녕</h1>");
//		out.println("[\"First task\", \"Second task\"]"); //불편한 표시
		out.print(new Gson().toJson(todos)); //gson라이브러리를 사용하여 json을 변환(편한표시가 사용될 수 있게)
		out.flush();
	}//0313 수정

	/**  
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
