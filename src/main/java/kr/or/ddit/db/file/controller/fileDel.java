package kr.or.ddit.db.file.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.db.file.service.FileService;
import kr.or.ddit.db.file.service.IfileService;
import kr.or.ddit.db.text.model.TextVo;
import kr.or.ddit.db.text.service.ItextService;
import kr.or.ddit.db.text.service.TextService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class addDel
 */
@WebServlet("/fileDel")
public class fileDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static final Logger logger = LoggerFactory
			.getLogger(fileDel.class);
	
    private IfileService fileService;
    private ItextService textService;
    
    @Override
	public void init() throws ServletException {
    	fileService = new FileService();
    	textService = new TextService();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int file_id = Integer.parseInt(request.getParameter("file_id"));
		int text_id = Integer.parseInt(request.getParameter("text_id"));
		
		logger.debug("file_id : {}",file_id);
		logger.debug("text_id : {}",text_id);
		
		TextVo textVo = textService.getText(text_id);
		int board_id = textVo.getBoard_id();
		
		fileService.del(file_id);
		request.setAttribute("text_id", text_id);
		logger.debug("삭제완료!");
		response.sendRedirect(request.getContextPath() +"/modify?text_id="+text_id);
//		request.getRequestDispatcher("/modify").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
