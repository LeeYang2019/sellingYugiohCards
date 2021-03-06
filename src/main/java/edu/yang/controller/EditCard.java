package edu.yang.controller;

import edu.yang.entity.YugiohCard;
import edu.yang.persistence.ProjectDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * A simple servlet that takes a card id and then gets a card by the id and pushes it the editCard jsp
 * @author Yang
 */

@WebServlet(
        urlPatterns = {"/editCard"}
)

public class EditCard extends HttpServlet {

    //logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * GET METHOD
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //create session
        HttpSession session = req.getSession();

        //get card from param
        String input = req.getParameter("param");
        int id = Integer.parseInt(input);

        ProjectDao yugiohCardDao = new ProjectDao(YugiohCard.class);
        YugiohCard newYugiohCard = (YugiohCard)yugiohCardDao.getById(id);

        req.setAttribute("card", newYugiohCard);
        session.setAttribute("cardToUpdate", newYugiohCard.getId());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editCard.jsp");
        dispatcher.forward(req, resp);

    }
}