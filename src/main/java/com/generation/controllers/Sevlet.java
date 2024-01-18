package com.generation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.entities.Question;
import com.generation.repositories.QuestionRepositorySql;

@WebServlet("/")
public class Sevlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        QuestionRepositorySql repo = new QuestionRepositorySql(); 
        String cmd = req.getParameter("cmd");
        if(cmd!=null)
            switch (cmd) 
            {
                case "cancella":
                {
                   int id = Integer.parseInt(req.getParameter("id"));
                   repo.delete(id); 
                }
                break;
                case "risolvi":
                {
                   int id = Integer.parseInt(req.getParameter("id"));
                   Question q = repo.readById(id);
                   q.setResolved(true);
                   repo.update(q);
                }
                break;
                case "derisolvi":
                {
                   int id = Integer.parseInt(req.getParameter("id"));
                   Question q = repo.readById(id);
                   q.setResolved(false);
                   repo.update(q);
                }
                break;
            
                default:
                break;
            }
        
        
        req.setAttribute("questions", repo.readAll());
        req.getRequestDispatcher("/homepage.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        Question newQuest = new Question();
        newQuest.setContent(req.getParameter("content"));
        newQuest.setResolved(false);

       QuestionRepositorySql repo = new QuestionRepositorySql(); 
       repo.insert(newQuest);

       //leggo dal model tutte le domande e le ALLEGO alla request
       req.setAttribute("questions", repo.readAll());

       req.getRequestDispatcher("/homepage.ftl").forward(req, resp);
    }
}
