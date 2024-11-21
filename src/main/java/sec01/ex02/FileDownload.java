package sec01.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/download.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
 
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
        //upload한 이미지를 다운로드 할 예정이다.
		//input위치 
		String file_repo = getServletContext().getRealPath("./uploadLocation") ;		
		String fileName = (String) request.getParameter("fileName");
		System.out.println("fileName=" + fileName);
		OutputStream out = response.getOutputStream(); //Browser의 down위치에 출력할 예정 
		String downFile = file_repo + "\\" + fileName;
		File f = new File(downFile); //읽을 파일이다. 
		//응답의 header에 다운로드할 파일의 정보를 추가한다. 
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName=" + fileName);
		
		FileInputStream in = new FileInputStream(f);
		
		byte[] buffer = new byte[1024 * 8];
		while (true) {
			int count = in.read(buffer);
			if (count == -1)
				break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}

}
