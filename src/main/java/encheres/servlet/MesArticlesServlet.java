/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encheres.servlet;

import encheres.entity.Utilisateur;
import encheres.service.ArticleService;
import encheres.service.UtilisateurService;
import encheres.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "MesArticlesServlet", urlPatterns = {"/mes_articles_servlet"})
public class MesArticlesServlet extends AutowireServlet {
    
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("login");
        Utilisateur u = utilisateurService.findOneByLogin(login);
        req.setAttribute("articles", articleService.findByUtilisateur(u));
        req.getRequestDispatcher("mes_articles.jsp").forward(req, resp);
    }
    


}
