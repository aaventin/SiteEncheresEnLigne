/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encheres.servlet;

import encheres.entity.Article;
import encheres.service.ArticleService;
import encheres.service.PaiementService;
import encheres.spring.AutowireServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author admin
 */
@WebServlet(name = "PayerPayPalServlet", urlPatterns = {"/payer_payPal_servlet"})
public class PayerPayPalServlet extends AutowireServlet {
    
    @Autowired
    @Qualifier("PAYPAL")
    private PaiementService paiementService;
    
    @Autowired
    private ArticleService articleService;

    @Override 
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Article article = articleService.findOne(Long.parseLong(req.getParameter("idArticle")));
        paiementService.payer(article);
        req.getRequestDispatcher("mes_encheres_servlet").forward(req, resp);
        
    }
    
    

}
