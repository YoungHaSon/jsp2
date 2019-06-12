package kr.or.ddit.db.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.db.comment.model.CommentVo;
import kr.or.ddit.db.comment.service.ComService;
import kr.or.ddit.db.comment.service.icomService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class comment
 */
@WebServlet("/comment")
public class comment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(comment.class);
	
	private icomService service;

	@Override
	public void init() throws ServletException {
		service = new ComService();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int text_id = Integer.parseInt(request.getParameter("text_id")); 
		String userid = request.getParameter("userid");
		String com_content = request.getParameter("com_content");
		
		logger.debug("찍히는거니??? text_id : {}", text_id);
		logger.debug("userid : {}", userid);
		logger.debug("com_content : {}", com_content);
		
		CommentVo comVo = new CommentVo(text_id, userid, com_content);
		service.insertCom(comVo);
		
		request.setAttribute("text_id", text_id);
//		request.getRequestDispatcher("/text").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/text?textid="+ text_id);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
