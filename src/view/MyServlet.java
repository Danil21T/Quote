package view;

import model.WorkerBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    WorkerBase workerBase;

    @Override
    public void init() throws ServletException {
        super.init();
        workerBase = new WorkerBase("C:\\Users\\Lenovo\\Desktop\\programm\\apache-tomcat-8.5.75\\webapps\\Quote\\Base\\Quote.txt");
        try {
            workerBase.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().equals("/quoteres/get_quote")){
            getServletContext().getRequestDispatcher("/FirstPage.jsp").forward(req,resp);
        }else if(req.getRequestURI().equals("/quoteres/result")){
            String quote = workerBase.getRandomString();

            req.setAttribute("quote", quote);

            getServletContext().getRequestDispatcher("/ResultPage.jsp").forward(req,resp);
        }

    }
}
