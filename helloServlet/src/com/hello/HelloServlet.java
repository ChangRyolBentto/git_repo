package com.hello;
//Servlet(인터페이스)
		//GenericServlet
			//HttpServlet
				//HelloServlet

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/HelloServlet")  <-- annotation 방식. web.xml에서 환결성정 해줬기 때문에 얜 안써도 됨
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//GenericServlet 오버라이드
	//맨 처음에 불러짐(Tomcat에 의해 Callback됨)
	public void init() {
		System.out.println("init()");
	}

	//서블릿이 종료되어 끝날 때 불러짐 (자바 파일 내용이 바뀌면 톰켓이 꺼질 때 Callback되고 다시 켜지므로 destroy() 찍힘)
	public void destroy() {
		System.out.println("destroy()");
	}
	
	//HttpServlet 오버라이드
	//송수신할 때 불러져서 계속 불러짐(일종의 스레드 - 그래서 서블릿은 딱 하나만 있는게 안정적임)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		
		//response(응답)을 자바에서 html로 바꿔줌
		response.setContentType("text/html;charset=UTF-8");
		//웹으로 보내주는 출력 스트림
		//서블릿 기반 자체는 자바지만 웹으로 결과물을 보여주기 위해 자바 안에 html을 씀 
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Hello Servlet!!<br>");
		out.println("안녕하세유<br>");
		out.println("</body>");
		out.println("</html>");
		//여기서 ln 안찍어주면 웹에선 똑같이 나오지만 우클-소스보기 해보면 다 연이어서 나옴
	}

}
