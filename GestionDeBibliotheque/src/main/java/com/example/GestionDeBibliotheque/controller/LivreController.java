package com.example.GestionDeBibliotheque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionDeBibliotheque.exception.ResourceNotFoundExeption;
import com.example.GestionDeBibliotheque.model.Livre;
import com.example.GestionDeBibliotheque.repository.LivreRepository;

@RestController
@RequestMapping("/emsi_api")
public class LivreController {

	@Autowired
	private LivreRepository livreRepository;
	
	// Retourner tout les livres
	@GetMapping("/livres")
	public List<Livre> getAllLivres() {
		return livreRepository.findAll(Sort.by(Sort.Direction.ASC, "titre"));
	}
	
	// Créer un livre
	@PostMapping("/livres")
	public Livre createLivre(@RequestBody Livre livre) {
		return livreRepository.save(livre);
	}

	// Retourner un livre avec son ID
	@GetMapping("/livres/{id}")
	public ResponseEntity<Livre> getLivreById(@PathVariable(value = "id") long id) throws ResourceNotFoundExeption {
		Livre livre = livreRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("Livre avec id = "+id+" non retrouvé dans la base de données !!"));
		return ResponseEntity.ok().body(livre);
	}
	
	// Modifier un livre
	@PutMapping("livres/{id}")
	public ResponseEntity<Livre> updateLivre(@PathVariable(value = "id") long id, @RequestBody Livre livreDetails) throws ResourceNotFoundExeption {
		Livre livre = livreRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("Livre avec id = "+id+" non retrouvé dans la base de données !!"));
		livre.setTitre(livreDetails.getTitre());
		livre.setMaisonEdition(livreDetails.getMaisonEdition());
		livre.setDateSortie(livreDetails.getDateSortie());
		livre.setAuteur(livreDetails.getAuteur());
		livre.setNombrePages(livreDetails.getNombrePages());
		livre.setISBN(livreDetails.getISBN());
		livre.setDateDerniereConsultation(livreDetails.getDateDerniereConsultation());
		livre.setStatusDisponibilite(livreDetails.getStatusDisponibilite());
		livreRepository.save(livre);
		return ResponseEntity.ok().body(livre);
	}
	
	// Supprimer un livre
	@DeleteMapping("/livres/{id}")
	public ResponseEntity<?> deleteLivreBy(@PathVariable(value = "id") long id) throws ResourceNotFoundExeption {
		Livre livre = livreRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption("Livre avec id = "+id+" non retrouvé dans la base de données !!"));
		livreRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
}
