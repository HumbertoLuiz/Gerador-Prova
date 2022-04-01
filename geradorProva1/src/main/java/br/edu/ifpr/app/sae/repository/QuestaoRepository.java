package br.edu.ifpr.app.sae.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifpr.app.sae.model.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long>{
	
	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query("delete from Questao q where q.id = :id")
	void removerQuestao(Long id);

	Optional<Questao> findById(Long id);


}

