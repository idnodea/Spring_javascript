package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dto.BoardDto;
import dto.MemberDto;
import service.BoardService;

@WebServlet("/")
public class BoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BoardController() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                                 throws ServletException, IOException {
        String view = null;

        // URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
        String uri = request.getRequestURI();
        String conPath = request.getContextPath();
        String com = uri.substring(conPath.length());

        // 주어진 URL에 따라 지정된 동작 수행
        if (com.equals("/list") || com.equals("/")) { // 게시글 목록을 보여주는 페이지
            String tmp = request.getParameter("page");
            int pageNo = (tmp != null && tmp.length() > 0)
                    ? Integer.parseInt(tmp) : 1;

            request.setAttribute("msgList",
                    new BoardService().getMsgList(pageNo)); // 게시글 목록을 가져와서 request에 저장
            request.setAttribute("pgnList",
                    new BoardService().getPagination(pageNo)); // 페이네이션 정보를 가져와서 request에 저장
            view = "list.jsp"; // 목록을 보여줄 JSP 페이지로 이동

        } else if (com.equals("/view")) { // 특정 게시글을 보여주는 페이지
            int num = Integer.parseInt(request.getParameter("num"));

            request.setAttribute("msg", new BoardService().getMsg(num)); // 특정 게시글을 가져와서 request에 저장
            view = "view.jsp"; // 게시글 내용을 보여줄 JSP 페이지로 이동

        } else if (com.equals("/write")) { // 게시글 작성 페이지
            String tmp = request.getParameter("num");
            int num = (tmp != null && tmp.length() > 0)
                    ? Integer.parseInt(tmp) : 0;

            BoardDto dto = new BoardDto();
            String action = "insert";

            if (num > 0) { // 수정하기 위해 게시글을 작성하는 경우
                dto = new BoardService().getMsgForWrite(num);
                action = "update?num=" + num;
            }

            request.setAttribute("msg", dto); // 게시글 정보를 request에 저장
            request.setAttribute("action", action); // 작성 또는 수정 액션을 request에 저장
            view = "write.jsp"; // 게시글을 작성할 JSP 페이지로 이동

        } else if (com.equals("/insert")) { // 게시글 작성 액션
            request.setCharacterEncoding("utf-8");
            String writer  = request.getParameter("writer" );
            String title   = request.getParameter("title"  );
            String content = request.getParameter("content");
            String num = request.getParameter("memberno"); //추가 
            int memberno = Integer.parseInt(num);  //추가

            try {
//                new BoardService().writeMsg(writer, title, content); // 게시글 작성 메서드 호출
                new BoardService().writeMsg(writer, title, content,memberno); // memberno추가
                view = "redirect:list"; // 게시글 목록 페이지로 리다이렉트

            } catch(Exception e) {
                request.setAttribute("errorMessage", e.getMessage()); // 에러 메시지를 request에 저장
                view = "errorBack.jsp"; // 에러 발생 시 돌아갈 JSP 페이지로 이동
            }

        } else if (com.equals("/update")) { // 게시글 수정 액션
            request.setCharacterEncoding("utf-8");
            int num = Integer.parseInt(request.getParameter("num"));
            String writer  = request.getParameter("writer" );
            String title   = request.getParameter("title"  );
            String content = request.getParameter("content");

            try {
                new BoardService().updateMsg(writer, title, content, num); // 게시글 수정 메서드 호출
                view = "redirect:list"; // 게시글 목록 페이지로 리다이렉트

            } catch(Exception e) {
                request.setAttribute("errorMessage", e.getMessage()); // 에러 메시지를 request에 저장
                view = "errorBack.jsp"; // 에러 발생 시 돌아갈 JSP 페이지로 이동
            }

        } else if (com.equals("/delete")) { // 게시글 삭제 액션
            int num = Integer.parseInt(request.getParameter("num"));

            new BoardService().deleteMsg(num); // 게시글 삭제 메서드 호출
            view = "redirect:list"; // 게시글 목록 페이지로 리다이렉트
        } else if (com.equals("/loginForm")) { // 로그인 폼 페이지
            view = "redirect:loginForm.jsp"; // 로그인 폼으로 리다이렉트
        } else if (com.equals("/login")) { // 로그인 액션
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            MemberDto memberDto = new MemberDao().selectMember(id, pw); // 회원 정보 조회

            if(memberDto.getMemberno() == 0) { // 로그인 실패 시
                view = "redirect:loginForm"; // 로그인 폼으로 리다이렉트
            } else { // 로그인 성공 시
                HttpSession session = request.getSession();
                session.setAttribute("member", memberDto); // 세션에 회원 정보 저장
                view = "list"; // 게시글 목록 페이지로 이동
            }
        }

        // view에 담긴 문자열에 따라 포워딩 또는 리다이렉팅
        if (view.startsWith("redirect:")) { // 리다이렉트 시
            response.sendRedirect(view.substring(9)); // 해당 URL로 리다이렉트
        } else { // 포워딩 시
            request.getRequestDispatcher(view).forward(request, response); // 해당 JSP 페이지로 포워딩
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                                  throws ServletException, IOException {
        doGet(request, response); // doPost 메서드에서는 doGet 메서드를 호출하여 동일한 작업 수행
    }
}