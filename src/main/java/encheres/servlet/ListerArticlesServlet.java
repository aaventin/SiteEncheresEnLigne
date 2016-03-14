/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encheres.servlet;

import encheres.entity.Article;
import encheres.entity.Categorie;
import encheres.entity.Utilisateur;
import encheres.service.ArticleService;
import encheres.service.CategorieService;
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
@WebServlet(name = "ListerArticlesServlet", urlPatterns = {"/lister_articles_servlet"})
public class ListerArticlesServlet extends AutowireServlet {
    
    @Autowired
    private CategorieService categorieService;
    
    @Autowired
    private ArticleService articleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {      
        req.setAttribute("categories",categorieService.findAll());
//        Utilisateur
//        req.setAttribute("utilisateur", req.get);
        
        if(req.getParameter("categorie") == null){
        req.setAttribute("articles", articleService.findAll());
        req.getRequestDispatcher("lister_articles.jsp").forward(req, resp);
        }
        
        
        Categorie c = categorieService.findOne(Long.parseLong(req.getParameter("categorie")));        
        req.setAttribute("articles", articleService.findByCategorie(c));
        req.getRequestDispatcher("lister_articles.jsp").forward(req, resp);
    }
    
    
    
    


}
