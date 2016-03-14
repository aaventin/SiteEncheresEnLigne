/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encheres.service;

import encheres.entity.Article;
import encheres.enumeration.StatutArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service("PAYPAL")
public class PayPalService implements PaiementService{
    @Autowired
    private ArticleService articleService;

    @Override
    public void payer(Article article) {
        article.setStatutArticle(StatutArticle.Paye);
        articleService.save(article);
    }
    
}
