/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encheres.service;

import encheres.entity.Article;
import encheres.entity.Categorie;
import encheres.entity.Utilisateur;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface ArticleService extends CrudRepository<Article, Long>{
    public List<Article> findByCategorie(Categorie c);
    public List<Article> findByUtilisateur(Utilisateur u);
    public List<Article> findDistinctArticleByEncheresUtilisateur(Utilisateur u);   
    
}
