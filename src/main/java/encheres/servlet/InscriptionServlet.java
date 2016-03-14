/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encheres.servlet;

import encheres.entity.Utilisateur;
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
@WebServlet(name = "InscriptionServlet", urlPatterns = {"/inscription_servlet"})
public class InscriptionServlet extends AutowireServlet {

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String mdp = req.getParameter("mdp");

        for (Utilisateur u : utilisateurService.findAll()) {
            if (u.getLogin().equals(login)) {
                throw new RuntimeException("Login déjà existant");
            }
        }

        Utilisateur u = new Utilisateur(login, mdp);
        utilisateurService.save(u);
        resp.sendRedirect("page_accueil.jsp");

    }

}
