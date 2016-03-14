/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encheres.servlet;

import encheres.entity.Utilisateur;
import encheres.service.ArticleService;
import encheres.service.EnchereService;
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
@WebServlet(name = "MesEncheresServlet", urlPatterns = {"/mes_encheres_servlet"})
public class MesEncheresServlet extends AutowireServlet {
    
    @Autowired
    private UtilisateurService utilisateurService ;
    @Autowired
    private EnchereService enchereService;
    @Autowired
    private ArticleService articleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur utilisateur = utilisateurService.findOneByLogin((String) req.getSession().getAttribute("login"));
        req.setAttribute("encheres", enchereService.findByUtilisateurOrderByDateCreationDesc(utilisateur));
        req.setAttribute("articles", articleService.findDistinctArticleByEncheresUtilisateur(utilisateur));
        req.getRequestDispatcher("mes_encheres.jsp").forward(req, resp);
        
    }
    
    


}
