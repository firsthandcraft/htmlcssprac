package step4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		String ani= request.getParameter("ani");
		if(ani.equals("a")) {
			out.println(ani+"<img src='https://static.hubzum.zumst.com/hubzum/2020/08/21/10/16af61affa8841f58caaedd241064824.jpg'>");
		} else if(ani.equals("b")) {
			out.println(ani+"<img src='https://www.sciencetimes.co.kr/wp-content/uploads/2014/04/0000065596.jpg'>");
		} else if(ani.equals("c")) {
		out.println(ani+"<img src='https://www.newspenguin.com/news/photo/202007/2106_6021_1457.jpg'>");
		}
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
