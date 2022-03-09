package br.edu.ifpr.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifpr.model.Prova;

public interface ProvaRepository extends JpaRepository<Prova, Integer> {

	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query("delete from Prova p where p.id = :id")
	void removerProva(Integer id);

}
