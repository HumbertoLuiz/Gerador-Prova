package br.edu.ifpr.app.sae.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifpr.app.sae.model.QuestaoSubjetiva;

public interface QuestaoSubjetivaRepository extends JpaRepository<QuestaoSubjetiva, Long>{

	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query("delete from QuestaoSubjetiva q where q.id = :id")
	void removerQuestaoSubjetiva(Long id);
		
	Optional<QuestaoSubjetiva> findById(Long id);



}
