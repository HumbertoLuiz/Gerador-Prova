package br.edu.ifpr.app.sae.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpr.app.sae.model.QuestaoSubjetiva;

public interface QuestaoSubjetivaRepository extends JpaRepository<QuestaoSubjetiva, Integer>{

	Optional<QuestaoSubjetiva> findById(Long id);

	

}
