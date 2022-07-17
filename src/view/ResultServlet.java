package view;

import model.WorkerBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ResultServlet extends HttpServlet {
    WorkerBase workerBase;

    public void init() throws ServletException {
        super.init();
        workerBase = new WorkerBase("src\\base\\Quote.txt");
        try {
            workerBase.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String quote = workerBase.getRandomString();

        req.setAttribute("quote", quote);

        getServletContext().getRequestDispatcher("/ResultPage.jsp").forward(req, resp);


    }
}
