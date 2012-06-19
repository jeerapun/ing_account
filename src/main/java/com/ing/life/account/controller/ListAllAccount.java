/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ing.life.account.controller;

import com.ing.life.account.model.Account;
import com.ing.life.account.model.AccountRepository;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author roofimon
 */
@WebServlet(name = "ListAllAccount", urlPatterns = {"/ListAllAccount"})
public class ListAllAccount extends HttpServlet {
    private static Logger logger = Logger.getLogger(ListAllAccount.class);

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        AccountRepository accountRepo = new AccountRepository();
        List<Account> allAccount = accountRepo.getAllAccount();
        request.setAttribute("allAccount", allAccount);
        logger.debug("Account Size: "+allAccount.size());
        String nextJSP = "/listAllAccount.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }
}
