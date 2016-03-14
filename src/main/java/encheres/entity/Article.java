/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encheres.entity;

import encheres.enumeration.StatutArticle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Article implements Serializable {

    public Utilisateur getDernierEncherisseur() {
        return dernierEncherisseur;
    }

    public void setDernierEncherisseur(Utilisateur dernierEncherisseur) {
        this.dernierEncherisseur = dernierEncherisseur;
    }
    
    
    
    @ManyToOne
    @JoinColumn(name = "DERNIER_ENCHERISSEUR_ID")
    private Utilisateur dernierEncherisseur;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Enchere> getEncheres() {
        return encheres;
    }

    public void setEncheres(List<Enchere> encheres) {
        this.encheres = encheres;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(Double prixDepart) {
        this.prixDepart = prixDepart;
    }

    public Double getPrixActuel() {
        return prixActuel;
    }

    public void setPrixActuel(Double prixActuel) {
        this.prixActuel = prixActuel;
    }

    public StatutArticle getStatutArticle() {
        return statutArticle;
    }

    public void setStatutArticle(StatutArticle statutArticle) {
        this.statutArticle = statutArticle;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public Article() {
    }

    public Article(Utilisateur utilisateur, Categorie categorie, String nom, Double prixDepart, Double prixActuel, Date dateVente) {
        this.utilisateur = utilisateur;
        this.categorie = categorie;
        this.nom = nom;
        this.prixDepart = prixDepart;
        this.prixActuel = prixActuel;
        this.dateVente = dateVente;
    }
    
    

    public Article(Utilisateur utilisateur, Categorie categorie, String nom, Double prixDepart, Date dateVente, Long id) {
        this.utilisateur = utilisateur;
        this.categorie = categorie;
        this.nom = nom;
        this.prixDepart = prixDepart;
        this.dateVente = dateVente;
        this.id = id;
    }

    public Article(Utilisateur utilisateur, Categorie categorie, String nom, Double prixDepart, Date dateVente) {
        this.utilisateur = utilisateur;
        this.categorie = categorie;
        this.nom = nom;
        this.prixDepart = prixDepart;
        this.dateVente = dateVente;
    }
    
    

    @ManyToOne
    @JoinColumn(name = "UTIL")
    private Utilisateur utilisateur;
    
    @ManyToOne
    @JoinColumn(name = "CATEGORIE")
    private Categorie categorie;

    @OneToMany(mappedBy = "article")
    private List<Enchere> encheres = new ArrayList<>();

    private String nom;
    private Double prixDepart;
    private Double prixActuel;

    @Enumerated(EnumType.STRING)
    private StatutArticle statutArticle = StatutArticle.Disponible;

    @Temporal(TemporalType.DATE)
    private Date dateVente;

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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "encheres.entity.Article[ id=" + id + " ]";
    }

}
