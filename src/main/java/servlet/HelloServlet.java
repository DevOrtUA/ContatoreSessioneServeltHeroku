package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/contatore"}
)
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer x;
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();

        if(session.isNew()){
            x =new Integer(1);
            session.setAttribute("contatore", x);

        }

        x =(Integer) session.getAttribute("contatore");

        session.setAttribute("contatore", new Integer(x.intValue() + 1));

        out.println("<p>Access n°: "+x+ "</p>");
        out.println("<a href='/'>link home</a>");
    }

}