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
import service.MemberService;

@WebServlet("/")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "index.jsp";

		// URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		// 주어진 URL에 따라 지정된 동작 수행
		if (com.equals("/list")) {
			String tmp = request.getParameter("page");
			int pageNo = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp) : 1;

			request.setAttribute("msgList", new BoardService().getMsgList(pageNo));
			request.setAttribute("pgnList", new BoardService().getPagination(pageNo));
			view = "list.jsp";

		} else if (com.equals("/view")) {
			int num = Integer.parseInt(request.getParameter("num"));
			request.setAttribute("msg", new BoardService().getMsg(num));
			view = "view.jsp";
			
		} else if (com.equals("/write")) {
			String tmp = request.getParameter("num");
			int boardno = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp) : 0;
			BoardDto dto = new BoardDto();
			String action = "insert";
			if (boardno > 0) {
				dto = new BoardService().getMsgForWrite(boardno);
				action = "update?boardno=" + boardno;
			}

			request.setAttribute("msg", dto);
			request.setAttribute("action", action);
			view = "write.jsp";

		} else if (com.equals("/insert")) {
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("name");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int memberno = Integer.parseInt(request.getParameter("num"));
			try {
				new BoardService().writeMsg(name, title, content, memberno);
				view = "redirect:list";

			} catch (Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				view = "errorBack.jsp";
			}

		} else if (com.equals("/update")) {
			request.setCharacterEncoding("utf-8");
			int num = Integer.parseInt(request.getParameter("boardno"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			try {
				new BoardService().updateMsg(title, content, num);
				view = "redirect:list";
			} catch (Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				view = "errorBack.jsp";
			}

		} else if (com.equals("/delete")) {
			int num = Integer.parseInt(request.getParameter("num"));
			new BoardService().deleteMsg(num);
			view = "redirect:list";
			
		} else if (com.equals("/loginForm")) {
			view = "loginForm.jsp";
		} else if (com.equals("/login")) {
			String id = request.getParameter("id");
			String email = request.getParameter("email");			
			MemberDto memberDto = new MemberDao().selectMember(id, email);
			if (memberDto.getMemberno() == 0) {
				System.out.println(id + email);
				System.out.println("로그인 실패");
				view = "redirect:loginForm";
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("member", memberDto);
				view = "redirect:list";
			}		
			
		} else if(com.equals("/mview")) {
			int num = Integer.parseInt(request.getParameter("num"));			
			request.setAttribute("member", new MemberService().getMember(num));
			view = "mview.jsp";
			
		} else if (com.equals("/mdelete")) {
			int num = Integer.parseInt(request.getParameter("num"));
			new MemberService().deleteMsg(num);
			view = "redirect:loginForm";
			
		} else if(com.equals("/mwrite")) {
			String tmp = request.getParameter("num");
			int memberno = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp) : 0;
			MemberDto dto = new MemberDto();
			
			if (memberno > 0) {
				dto = new MemberService().getMsgForWrite(memberno);				
			}
			request.setAttribute("member", dto);			
			view = "mwrite.jsp";
		}		
		else if (com.equals("/mupdate")) {			
			request.setCharacterEncoding("utf-8");
			int memberno = Integer.parseInt(request.getParameter("num"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			try {
				new MemberService().updateMember(name, email, memberno);
				view = "redirect:list";
			} catch (Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				view = "errorBack.jsp";			
			}
		} else if (com.equals("/minsert")) {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			try {
				new MemberService().signUp(id, email, name);
				view = "redirect:loginForm";
			} catch (Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				view = "errorBack.jsp";
			}
		} else if (com.equals("/aa")) {
			view = "index.jsp";
		}
		
		// view에 담긴 문자열에 따라 포워딩 또는 리다이렉팅
		if (view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}