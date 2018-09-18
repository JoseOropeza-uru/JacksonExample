package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.InnerClass;
import models.OuterClass;
import models.Response;

/**
 * Servlet implementation class SecondServlet
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ObjectMapper objMapper = new ObjectMapper();

	        try {
	        	Response<HashMap<String,Integer>> resp = new Response<>();
	        	HashMap<String,Integer> map = new HashMap<String, Integer>();
	        	map.put("age", Integer.valueOf(request.getParameter("age")));
	        	resp.setMessage("Handling Hashmap to create JSON");
	            resp.setStatus(200);
	            resp.setData(map);
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
        	Response<OuterClass> resp = new Response<>();
            resp.setMessage("Response using classes within classes");
            resp.setStatus(200);
            InnerClass innerClass = objMapper.readValue(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())), InnerClass.class);
        
            OuterClass outerClass = new OuterClass();
            outerClass.setMessage("Outer Class");
            outerClass.setInner(innerClass);
            resp.setData(outerClass);
            String res = objMapper.writeValueAsString(resp);
            System.out.println(objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resp));
            response.getWriter().print(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
