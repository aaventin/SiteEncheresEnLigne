/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encheres.servlet;

import encheres.entity.Article;
import encheres.entity.Utilisateur;
import encheres.service.ArticleService;
import encheres.service.EnchereService;
import encheres.service.EncherirService;
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
@WebServlet(name = "EncherirServlet", urlPatterns = {"/encherir_servlet"})
public class EncherirServlet extends AutowireServlet {

    @Autowired
    private EncherirService encherirService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Article article = articleService.findOne(Long.parseLong(req.getParameter("idArticle")));
        Utilisateur utilisateur = utilisateurService.findOneByLogin((String) req.getSession().getAttribute("login"));
        Utilisateur dernierEncherisseur = article.getDernierEncherisseur();

        if (article.getUtilisateur().getId() != utilisateur.getId()) {
            if (dernierEncherisseur == null || dernierEncherisseur.getId() != (utilisateur.getId())) {
                encherirService.encherir(article, utilisateur);
                req.getRequestDispatcher("lister_articles_servlet").forward(req, resp);
            }
        }

        req.getRequestDispatcher("lister_articles_servlet").forward(req, resp);

    }

}
