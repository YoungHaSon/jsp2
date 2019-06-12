package kr.or.ddit.db.text.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.db.board.model.BoardVo;
import kr.or.ddit.db.board.service.BoardService;
import kr.or.ddit.db.board.service.IboardService;
import kr.or.ddit.db.text.model.TextVo;
import kr.or.ddit.db.text.service.ItextService;
import kr.or.ddit.db.text.service.TextService;
import kr.or.ddit.db.user.model.UsersVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class reply
 */
@WebServlet("/reply")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class reply extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ItextService textService;
	private IboardService boardService;
	
	@Override
	public void init() throws ServletException{
		textService = new TextService();
		boardService = new BoardService();
	}
	
	private static final Logger logger = LoggerFactory.getLogger(reply.class);

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int text_id = Integer.parseInt(request.getParameter("text_id"));
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		String userid = request.getParameter("userid");
		int group_num = Integer.parseInt(request.getParameter("group_num"));
		List<BoardVo> boardList = boardService.boardList();
		request.setAttribute("boardList", boardList);
		logger.debug("text_id : {}", text_id);
		logger.debug("board_id : {}", board_id);
		logger.debug("userid : {}", userid);
		logger.debug("group_num : {}", group_num);
		
		request.setAttribute("text_id", text_id);
		request.setAttribute("board_id", board_id);
		request.setAttribute("userid", userid);
		request.setAttribute("group_num", group_num);
		
		TextVo textVo = new TextVo(text_id, board_id, userid, group_num);
		
		HttpSession session = request.getSession();
		session.setAttribute("REPLY_INFO", textVo);
	
		request.getRequestDispatcher("/board/reply.jsp").forward(request,
				response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String text_title = request.getParameter("title");
		String text_content = request.getParameter("smarteditor");
		String profile = request.getParameter("profile");
		
		HttpSession session = request.getSession();
		TextVo textVo1 = (TextVo) session.getAttribute("REPLY_INFO");
		int board_id = textVo1.getBoard_id();
		int text_id2 = textVo1.getText_id();
		int group_num = textVo1.getGroup_num();
		String userid = textVo1.getUserid();
		
		logger.debug("textVo : {}", textVo1);
		logger.debug("title : {}", text_title);
		logger.debug("smarteditor : {}", text_content);
		logger.debug("profile : {}", profile);
		logger.debug("-----------------");
		logger.debug("Board_id : {}", board_id);
		logger.debug("text_id2 : {}", text_id2);
		logger.debug("group_num : {}", group_num);
		logger.debug("userid : {}", userid);
		
		TextVo textVo = new TextVo(text_id2, board_id, text_title, text_content, userid, group_num);
		
		textService.insertReply(textVo);
		TextVo text =textService.recentReply();
		int text1 = text.getText_id();
		
		response.sendRedirect(request.getContextPath() +"/text?textid="+text1);
		
		
	}
}
