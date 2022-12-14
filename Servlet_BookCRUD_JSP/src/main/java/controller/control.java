package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookVo;
import service.EventService;

/**
 * Servlet implementation class control
 */
@WebServlet("/control")
public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8"); 
		PrintWriter out= response.getWriter();
		String type= request.getParameter("type");
		String resultView= "book/";
		EventService service = new EventService();
		
		if(type.equals("insert")) {
			String author=request.getParameter("author");
			String title=request.getParameter("title");
			String publisher=request.getParameter("publisher");
			String content=request.getParameter("content");
			BookVo p = new BookVo(0,author,title,publisher,content);
			service.insert(p); 
			resultView+="index.jsp";
		} else if(type.equals("list")) {
			 ArrayList<BookVo> data= service.list();
			 request.setAttribute("data",data);
			resultView+="list.jsp";
		}//업데이트 
		 else if(type.equals("update")) {
			int sno = Integer.parseInt(request.getParameter("pno"));
			BookVo m=  service.getMember(sno);
			 request.setAttribute("m",m);
			resultView+="update.jsp";
		} //수정
		 else if(type.equals("edit")) {
			int pno = Integer.parseInt(request.getParameter("pno"));
			String author=request.getParameter("author");
			String title=request.getParameter("title");
			String publisher=request.getParameter("publisher");
			String content=request.getParameter("content");
			BookVo p = new BookVo(pno,author,title,publisher,content);
			service.edit(p);
			resultView+="index.jsp";
		} else if(type.equals("delete")) {
			int num = Integer.parseInt(request.getParameter("pno"));
			service.delete(num);
			resultView="control?type=list";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(resultView);
		dispatcher.forward(request,response);
	}

}
