package br.edu.ifpr.app.sae.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifpr.app.sae.model.QuestaoObjetiva;

public interface QuestaoObjetivaRepository extends JpaRepository<QuestaoObjetiva, Long> {
	
/*	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query("delete from QuestaoOjetiva q where q.id = :id")
	void removerQuestaoOjetiva(Long id);*/
	
	Optional<QuestaoObjetiva> findById(Long id);


}
