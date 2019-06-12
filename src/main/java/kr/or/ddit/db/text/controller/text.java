package kr.or.ddit.db.text.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.db.board.model.BoardVo;
import kr.or.ddit.db.board.service.BoardService;
import kr.or.ddit.db.board.service.IboardService;
import kr.or.ddit.db.comment.model.CommentVo;
import kr.or.ddit.db.comment.service.ComService;
import kr.or.ddit.db.comment.service.icomService;
import kr.or.ddit.db.file.model.FileVo;
import kr.or.ddit.db.file.service.FileService;
import kr.or.ddit.db.file.service.IfileService;
import kr.or.ddit.db.text.model.TextVo;
import kr.or.ddit.db.text.service.ItextService;
import kr.or.ddit.db.text.service.TextService;
import kr.or.ddit.db.user.model.UsersVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class text
 */
@WebServlet("/text")
public class text extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private static final Logger logger = LoggerFactory
			.getLogger(text.class);
	
	private ItextService textService;
	private icomService service;
	private IfileService fileService;
	private IboardService boardService;
	
	@Override
	public void init() throws ServletException {
		textService = new TextService();
		service = new ComService();
		fileService = new  FileService();
		boardService = new BoardService();
	}
	
	//게시물 하나클릭했을때 상세 조회로 넘어가는 곳!
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("textid");
		int text_id = Integer.parseInt(text);
		logger.debug("text_id : {}", text_id);
		List<BoardVo> boardList = boardService.boardList();
		request.setAttribute("boardList", boardList);
		
		UsersVo usersVo = (UsersVo) request.getSession().getAttribute("USER_INFO");
		request.setAttribute("usersVo", usersVo);
		String userid = request.getParameter("userid");
		logger.debug("userid 여기까지 들어오니? : {} ", userid);
		request.setAttribute("userid", userid);
		
		TextVo textVo =  textService.getText(text_id);
		logger.debug("textVo : {}", textVo);
		
		List<CommentVo> comList = service.Comselect(text_id);
		logger.debug("내가 바로! comList : {}", comList);
		List<FileVo> fileList = fileService.fileList(text_id);
		logger.debug("fileList : {}", fileList);
		
		//group_num 어쩌구 저쩌구
		
		request.setAttribute("fileList", fileList);
		request.setAttribute("comList", comList);
		request.setAttribute("textVo", textVo);
	
		request.getRequestDispatcher("/board/text.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String userid = request.getParameter("userid");
//		String board_id = request.getParameter("board_id");
//		String text_title = request.getParameter("text_title");
//		String text_content = request.getParameter("text_content");
//		
//		logger.debug("userid :  {}" , userid);
//		logger.debug("board_id :  {}" , board_id);
//		logger.debug("text_title :  {}" , text_title);
//		logger.debug("text_content :  {}" , text_content);
//		
//		request.setAttribute("userid",userid );
//		request.setAttribute("board_id",board_id);
//		request.setAttribute("text_title",text_title );
//		request.setAttribute("text_content",text_content );
//		
//		request.getRequestDispatcher("/board/modify.jp").forward(request, response);
//		
	}

}
