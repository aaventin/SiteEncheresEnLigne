/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encheres.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Enchere implements Serializable {

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Enchere() {
    }

    public Enchere(Article article, Utilisateur utilisateur, Date dateCreation, Long id) {
        this.article = article;
        this.utilisateur = utilisateur;
        this.dateCreation = dateCreation;
        this.id = id;
    }

    public Enchere(Article article, Utilisateur utilisateur, Date dateCreation) {
        this.article = article;
        this.utilisateur = utilisateur;
        this.dateCreation = dateCreation;
    }
    
    
    
    @ManyToOne
    @JoinColumn(name = "ARTICLE")
    private Article article;
    
    @ManyToOne
    @JoinColumn(name = "UTIL")
    private Utilisateur utilisateur;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

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
        if (!(object instanceof Enchere)) {
            return false;
        }
        Enchere other = (Enchere) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "encheres.entity.Enchere[ id=" + id + " ]";
    }
    
}
