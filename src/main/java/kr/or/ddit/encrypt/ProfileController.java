package kr.or.ddit.encrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.db.user.model.UsersVo;
import kr.or.ddit.db.user.service.IuserService;
import kr.or.ddit.db.user.service.UserService;

@WebServlet("/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private IuserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자 아이디를 파라미터로 부터 확인해서
		String userId = request.getParameter("userId");
		//사용자 정보(Path)를 조회
		UsersVo userVo = userService.getUser(userId);
		String path = userVo.getPath();
		//path 정보로 file을 읽어서 
		ServletOutputStream sos = response.getOutputStream();
		
		FileInputStream fis = null;
		String filePath = null;
		
		//사진 존재하는 경우
		if(userVo.getPath() != null){
			filePath = userVo.getPath();
		//사진이 없는경우
		}else{
			filePath = getServletContext().getRealPath("/img/재고없음.png");
		}
		
		//화면에 띄워주는 부분!
		File file = new File(filePath);
		fis = new FileInputStream(file);
		byte[] buffer = new byte[512];
		
		//다읽으면 -1 반환, 	
		//response 객체에 스트림으로 ? 써준다?
		while(fis.read(buffer, 0, 512) != -1){
			sos.write(buffer);
		}
		fis.close();
		sos.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
