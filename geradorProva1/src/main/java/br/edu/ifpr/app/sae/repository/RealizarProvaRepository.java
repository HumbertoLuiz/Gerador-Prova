package br.edu.ifpr.app.sae.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifpr.app.sae.model.RealizarProva;

public interface RealizarProvaRepository extends JpaRepository<RealizarProva, Integer> {
	
	Optional<RealizarProva> findById(Long id);
	
/*	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query("delete from RealizarProva r where r.id = :id")
	void removerRealizarProva(Long id);*/
	

}
