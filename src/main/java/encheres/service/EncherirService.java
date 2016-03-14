/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encheres.service;

import encheres.entity.Article;
import encheres.entity.Enchere;
import encheres.entity.Utilisateur;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class EncherirService {

    @Autowired
    private ArticleService articleService;    
    @Autowired
    private UtilisateurService utilisateurService;    
    @Autowired
    private EnchereService enchereService;

    public void encherir(Article article, Utilisateur utilisateur) {           
        Double prixActuel = article.getPrixActuel() + 10;
        article.setPrixActuel(prixActuel);       
       
        Enchere enchere = new Enchere(article,utilisateur, new Date());
        enchereService.save(enchere);
        article.getEncheres().add(enchere);
        article.setDernierEncherisseur(utilisateur);
        utilisateur.getArticlesDernierEncherisseur().add(article);
        utilisateur.getEncheres().add(enchere);
    
        articleService.save(article);
        utilisateurService.save(utilisateur);

       
    }

}
