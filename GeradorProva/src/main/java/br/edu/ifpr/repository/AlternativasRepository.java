package br.edu.ifpr.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifpr.model.Alternativas;

public interface AlternativasRepository extends JpaRepository<Alternativas, Integer> {

	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query("delete from Alternativas a where a.id = :id")
	void removerAlternativa(Integer id);

}
