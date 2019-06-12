package kr.or.ddit.db.comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.db.comment.model.CommentVo;
import kr.or.ddit.db.comment.service.ComService;
import kr.or.ddit.db.comment.service.icomService;

/**
 * Servlet implementation class delCom
 */
@WebServlet("/delCom")
public class delCom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(delCom.class);
	
	private icomService service;
	
	@Override
	public void init() throws ServletException {
		service = new ComService();
	} 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int com_id = Integer.parseInt(request.getParameter("com_id"));
		int textid = Integer.parseInt(request.getParameter("text_id"));
		logger.debug("com_id은???: {}" , com_id);
		
		service.changeCol(com_id);
		
		response.sendRedirect(request.getContextPath() + "/text?textid=" +textid);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
