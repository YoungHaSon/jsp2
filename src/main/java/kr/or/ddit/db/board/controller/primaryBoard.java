package kr.or.ddit.db.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.db.board.model.BoardVo;
import kr.or.ddit.db.board.service.BoardService;
import kr.or.ddit.db.board.service.IboardService;
import kr.or.ddit.db.text.model.TextVo;
import kr.or.ddit.db.text.service.ItextService;
import kr.or.ddit.db.text.service.TextService;
import kr.or.ddit.db.user.model.PageVo;
import kr.or.ddit.db.user.service.IuserService;
import kr.or.ddit.db.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class free_board
 */
@WebServlet("/primaryBoard")
public class primaryBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory
			.getLogger(create_board.class);
	
	private IboardService boardService;
	private ItextService textService;
	private IuserService userService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		textService = new TextService();
		userService = new UserService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//left.jsp에서 board_id 값
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		textService.allText(board_id);
		String userid = request.getParameter("userid");
		logger.debug("userid는 입니다 : {}" , userid);
		
		request.setAttribute("userid", userid);
		request.setAttribute("board_id", board_id);
		
		BoardVo boardVo = boardService.getBoard(board_id);
		
			String pageString = request.getParameter("page");
			String pageSizeString = request.getParameter("pageSize");
			
			int page = pageString == null ? 1 : Integer.parseInt(pageString);
			int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
			PageVo pageVo = new PageVo(page,pageSize);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("page", page);
			map.put("pageSize", pageSize);
			map.put("board_id", board_id);
			
			Map<String, Object> resultMap = userService.textPagingList(map);
			int paginationSize = (Integer)resultMap.get("paginationSize");
			List<TextVo> textList = (List<TextVo>) resultMap.get("textList");
			
			request.setAttribute("paginationSize", paginationSize);
			request.setAttribute("pageVo", pageVo);
			
			//메뉴 띄울라고 boardList 정보
			request.setAttribute("boardList", boardService.boardList());
			//해당 게시판의 모든 게시글
			request.setAttribute("textList", textList);
			//해당 게시판 번호
			
			logger.debug("page : {}", page);
			logger.debug("pageSize : {}", pageSize);
			logger.debug("map : {}", map);
			logger.debug("board_id : {}", board_id);
			logger.debug("boardList : {}", boardService.boardList());
			logger.debug("allText : {}", textService.allText(board_id));
			
			request.setAttribute("boardVo", boardVo);
			
			request.getRequestDispatcher("/board/freeBoard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
