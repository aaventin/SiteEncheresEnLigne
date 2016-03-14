/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encheres.servlet;

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
@WebServlet(name = "ConnexionServlet", urlPatterns = {"/connexion_servlet"})
public class ConnexionServlet extends AutowireServlet {
    
    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
        String login = req.getParameter("login");
        String mdp = req.getParameter("mdp");
             
                
        if(utilisateurService.findOneByLoginAndMdp(login, mdp)==null){
            throw new RuntimeException("Login ou mot de passe inconnu");
        }
        
        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("mdp", mdp);
        resp.sendRedirect("page_accueil.jsp");
    }
 
    

}
