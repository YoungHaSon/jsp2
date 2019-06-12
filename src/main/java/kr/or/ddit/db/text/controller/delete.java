package kr.or.ddit.db.text.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.db.board.service.BoardService;
import kr.or.ddit.db.text.service.ItextService;
import kr.or.ddit.db.text.service.TextService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory
			.getLogger(delete.class);
	
	private ItextService service;
	
	public void init() throws ServletException{
		service = new TextService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("delete!!");
		int text_id = Integer.parseInt(request.getParameter("text_id"));
		logger.debug("text_id : {}" , text_id);
		
		service.changeCol(text_id);
		
//		response.sendRedirect(request.getContextPath() +"/primaryBoard");
		request.getRequestDispatcher("/primaryBoard").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
