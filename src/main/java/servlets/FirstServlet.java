package servlets;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.InnerClass;
import models.Response;

/**
 * Servlet implementation class TestServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ObjectMapper objMapper = new ObjectMapper();

	        try {
	        	Response<?> resp = new Response<>();
	            resp.setMessage("Hello World, This is a Jackson get Response");
	            resp.setStatus(200);
	            String res = objMapper.writeValueAsString(resp);
	            System.out.println(objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resp));
	            response.getWriter().print(res);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ObjectMapper objMapper = new ObjectMapper();

	        try {
	        	Response<InnerClass> resp = new Response<>();
	            resp.setMessage("Response using request body as data");
	            resp.setStatus(200);
	            InnerClass innerClass = objMapper.readValue(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())), InnerClass.class);
	            resp.setData(innerClass);
	            String res = objMapper.writeValueAsString(resp);
	            System.out.println(objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resp));
	            response.getWriter().print(res);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}

}
