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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author admin
 */
@Entity
public class Categorie implements Serializable {

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Categorie> getCategoriesFilles() {
        return categoriesFilles;
    }

    public void setCategoriesFilles(List<Categorie> categoriesFilles) {
        this.categoriesFilles = categoriesFilles;
    }

    public Categorie getCategorieMere() {
        return categorieMere;
    }

    public void setCategorieMere(Categorie categorieMere) {
        this.categorieMere = categorieMere;
    }

    public Categorie() {
    }

    public Categorie(String nom, Categorie categorieMere, Long id) {
        this.nom = nom;
        this.categorieMere = categorieMere;
        this.id = id;
    }

    public Categorie(String nom, Categorie categorieMere) {
        this.nom = nom;
        this.categorieMere = categorieMere;
    }
    
    
    
    private String nom;
    
    @OneToMany(mappedBy = "categorie")
    private List<Article> articles = new ArrayList<>();
    
    @OneToMany(mappedBy = "categorieMere" )
    private List<Categorie> categoriesFilles = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "CATEGORIE_MERE")
    private Categorie categorieMere;

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
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "encheres.entity.Categorie[ id=" + id + " ]";
    }
    
}
