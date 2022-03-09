package br.edu.ifpr.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifpr.model.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Integer>{

	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query("delete from Questao q where q.id = :id")
	void removerQuestao(Integer id);

}
