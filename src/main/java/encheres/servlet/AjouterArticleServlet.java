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
import encheres.service.UtilisateurService;
import encheres.spring.AutowireServlet;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "AjouterArticleServlet", urlPatterns = {"/ajouter_article_servlet"})
public class AjouterArticleServlet extends AutowireServlet{
    @Autowired
    private CategorieService categorieService;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Autowired
    private ArticleService articleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories",categorieService.findAll());
        req.getRequestDispatcher("ajouter_article.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        Double prixDepart = Double.parseDouble(req.getParameter("prixDepart"));
        Categorie categorie = categorieService.findOne(Long.parseLong(req.getParameter("categorie")));        
        Utilisateur utilisateur = utilisateurService.findOneByLogin((String) req.getSession().getAttribute("login"));
        
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_MONTH,10);
        Date dateVente = c.getTime();
        
        Article article = new Article(utilisateur, categorie, nom, prixDepart, prixDepart, dateVente);
        articleService.save(article);
        
        utilisateur.getArticles().add(article);
        utilisateurService.save(utilisateur);
        
        categorie.getArticles().add(article);
        categorieService.save(categorie);
        
        resp.sendRedirect("mes_articles_servlet");
        
    }
    
    


}
