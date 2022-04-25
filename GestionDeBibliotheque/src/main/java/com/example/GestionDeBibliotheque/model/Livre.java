package com.example.GestionDeBibliotheque.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Livres")
public class Livre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "titre", nullable = false)
	private String titre;
	
	@Column(name = "maisonEdition", nullable = false, updatable = false)
	private String maisonEdition;
	
	@Column(name = "DateSortie", nullable = false)
	private String DateSortie;
	
	@Column(name = "auteur", nullable = false)
	private String auteur;
	
	@Column(name = "nombrePages", nullable = false)
	private int nombrePages;
	
	@Column(name = "ISBN", unique=true, nullable = false, updatable = false)
	private String ISBN;
	
	@Column(name = "DateDerniereConsultation", nullable = false)
	private String DateDerniereConsultation;
	
	@Column(name = "statusDisponibilite", nullable = false)
	private Boolean statusDisponibilite;
	
	public Livre() {
		super();
	}
	public Livre(long id, String titre, String maisonEdition, String dateSortie, String auteur, int nombrePages,
			String iSBN, String dateDerniereConsultation, Boolean statusDisponibilite) {
		super();
		this.id = id;
		this.titre = titre;
		this.maisonEdition = maisonEdition;
		DateSortie = dateSortie;
		this.auteur = auteur;
		this.nombrePages = nombrePages;
		ISBN = iSBN;
		DateDerniereConsultation = dateDerniereConsultation;
		this.statusDisponibilite = statusDisponibilite;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getMaisonEdition() {
		return maisonEdition;
	}
	public void setMaisonEdition(String maisonEdition) {
		this.maisonEdition = maisonEdition;
	}
	public String getDateSortie() {
		return DateSortie;
	}
	public void setDateSortie(String dateSortie) {
		DateSortie = dateSortie;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public int getNombrePages() {
		return nombrePages;
	}
	public void setNombrePages(int nombrePages) {
		this.nombrePages = nombrePages;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getDateDerniereConsultation() {
		return DateDerniereConsultation;
	}
	public void setDateDerniereConsultation(String dateDerniereConsultation) {
		DateDerniereConsultation = dateDerniereConsultation;
	}
	public Boolean getStatusDisponibilite() {
		return statusDisponibilite;
	}
	public void setStatusDisponibilite(Boolean statusDisponibilite) {
		this.statusDisponibilite = statusDisponibilite;
	}
	
	

}
