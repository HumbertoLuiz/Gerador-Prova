package br.edu.ifpr.app.sae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpr.app.sae.model.Prova;

public interface ProvaRepository extends JpaRepository<Prova, Long> {

	
	Optional<Prova> findById(Long id);
}
