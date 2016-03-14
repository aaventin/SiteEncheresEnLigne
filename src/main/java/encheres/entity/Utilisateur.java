/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encheres.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author admin
 */
@Entity
public class Utilisateur implements Serializable {

    public List<Article> getArticlesDernierEncherisseur() {
        return articleDernierEncherisseur;
    }

    public void setArticleDernierEncherisseur(List<Article> articleDernierEncherisseur) {
        this.articleDernierEncherisseur = articleDernierEncherisseur;
    }
    
    
    
    @OneToMany(mappedBy = "dernierEncherisseur")
    List<Article> articleDernierEncherisseur =new ArrayList<>();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Enchere> getEncheres() {
        return encheres;
    }

    public void setEncheres(List<Enchere> encheres) {
        this.encheres = encheres;
    }

    public Utilisateur(String login, String mdp, Long id) {
        this.login = login;
        this.mdp = mdp;
        this.id = id;
    }

    public Utilisateur(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
    }

    public Utilisateur() {
    }
    
    
    
    
    
    private String login;
    private String mdp;
    
    @OneToMany(mappedBy = "utilisateur")
    private List<Article> articles = new ArrayList<>();
    
    @OneToMany(mappedBy = "utilisateur")
    private List<Enchere> encheres = new ArrayList<>();

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "encheres.entity.Utilisateur[ id=" + id + " ]";
    }
    
}
