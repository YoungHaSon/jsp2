package kr.or.ddit.db.text.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.jsp.PageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.db.board.service.BoardService;
import kr.or.ddit.db.board.service.IboardService;
import kr.or.ddit.db.comment.service.ComService;
import kr.or.ddit.db.comment.service.icomService;
import kr.or.ddit.db.file.model.FileVo;
import kr.or.ddit.db.file.service.FileService;
import kr.or.ddit.db.file.service.IfileService;
import kr.or.ddit.db.text.model.TextVo;
import kr.or.ddit.db.text.service.ItextService;
import kr.or.ddit.db.text.service.TextService;
import kr.or.ddit.db.user.model.PageVo;
import kr.or.ddit.util.PartUtil;

/**
 * Servlet implementation class createText
 */
@WebServlet("/createText")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class createText extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(createText.class);

	private ItextService textService;
	private IboardService boardService;
	private IfileService fileService;

	@Override
	public void init() throws ServletException {
		textService = new TextService();
		boardService = new BoardService();
		fileService = new FileService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int board_id = (Integer.parseInt(request.getParameter("board_id")));
		String userid = request.getParameter("userid");
		logger.debug("userid : {}", userid);

		boardService.getBoard(board_id);
		request.setAttribute("boardList", boardService.boardAllList());

		request.setAttribute("board_id", board_id);
		request.setAttribute("userid", userid);

		logger.debug("board_id {}", board_id);
		request.setAttribute("allText", textService.allText(board_id));
		request.getRequestDispatcher("/board/createText.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userid = request.getParameter("userid");
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		String text_title = request.getParameter("title");
		String text_content = request.getParameter("smarteditor");

		logger.debug("userid : {}", userid);
		logger.debug("board_id : {}", board_id);
		logger.debug("title : {}", text_title);
		logger.debug("smarteditor : {}", text_content);

		TextVo textVo = new TextVo(board_id, text_title, text_content, userid);
		textService.insertText(textVo);

		//최근글 text_id 가져오는 메서드
		TextVo textVo1 = textService.recentReply();
		int text_id = textVo1.getText_id();

		// 첨부파일?
		String profile = request.getParameter("profile");
		List<Part> parts = (List<Part>) request.getParts();
		logger.debug("첨부파일!!part : {}", parts);

		for (Part part : request.getParts()) {

			if (part.getSize() > 0 ) {

				Collection<String> headerNames = part.getHeaderNames();
				String contentDisposition = part.getHeader("content-disposition");
				String file_name = PartUtil.getFileName(contentDisposition);
				if(file_name !=""){
					
					for (String header : headerNames)
						logger.debug("{} : {} ", header, part.getHeader(header));
					
					// 파일 디스크에 쓰기? jsp에서 입력받은 이미지 파일을 해당 경로에 저장 시키는!
					// 같은 파일명이 있으면 덮어 씌워짐...가짜 이름을 만들어줘야함...
					
					// 확장자 붙여주기! --> 업로드하는 파일의 확장자를 떼어서 붙이는?..
					// String str = fileName.substring(fileName.lastIndexOf("."));
					String ext = PartUtil.getExt(file_name);
					
					// File.separator --> "\\"
					String uploadPath = PartUtil.getUploadPath();
					File uploadFolder = new File(uploadPath);
					
					String file_path = uploadPath + File.separator
							+ UUID.randomUUID().toString() + ext;
					if (uploadFolder.exists()) {
						part.write(file_path);
						// 임시적으로 생긴 파일의 공간을 지우는
						part.delete();
					}
					
					FileVo fileVo = new FileVo(text_id, file_path, file_name);
					fileService.insertFile(fileVo);
					request.setAttribute("fileVo", fileVo);
				}
			}
		}
		request.setAttribute("userid", userid);
		request.setAttribute("board_id", board_id);
		request.setAttribute("text_title", text_title);
		request.setAttribute("text_content", text_content);

		request.setAttribute("textVo", textVo);

		response.sendRedirect(request.getContextPath() + "/text?textid="+ text_id);

	}

}
