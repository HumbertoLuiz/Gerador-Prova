package br.edu.ifpr.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class RealizarProva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_realizarprova")
	private Integer id;	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_prova")
	private Prova prova;	
	 
	
	@ManyToMany
    @JoinTable(name = "realizarprova_respostaObjetivas", joinColumns = @JoinColumn(name = "realizarprova_id", referencedColumnName = "id_realizarprova"),
   	inverseJoinColumns = @JoinColumn(name = "altenativas_id", referencedColumnName = "id_alternativas"))        
	 private List<Alternativas> respostasObjetivas = new ArrayList<>();

	
	@ElementCollection(targetClass=QuestaoSubjetiva.class)
	@ManyToMany
    @JoinTable(name = "realizarProva_respostasSubjetivas", joinColumns = @JoinColumn(name = "realizarprova_id", referencedColumnName = "id_realizarprova"),
   	inverseJoinColumns = @JoinColumn(name = "respostasSubjetivas_id", referencedColumnName = "id_questao"))        
    private Map<QuestaoSubjetiva, String> respostasSubjetivas;


	public RealizarProva() {
		// TODO Auto-generated constructor stub
	}


	public RealizarProva(Prova prova, List<Alternativas> respostasObjetivas,
			Map<QuestaoSubjetiva, String> respostasSubjetivas) {
		this.prova = prova;
		this.respostasObjetivas = respostasObjetivas;
		this.respostasSubjetivas = respostasSubjetivas;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Prova getProva() {
		return prova;
	}


	public void setProva(Prova prova) {
		this.prova = prova;
	}


	public List<Alternativas> getRespostasObjetivas() {
		return respostasObjetivas;
	}


	public void setRespostasObjetivas(List<Alternativas> respostasObjetivas) {
		this.respostasObjetivas = respostasObjetivas;
	}


	public Map<QuestaoSubjetiva, String> getRespostasSubjetivas() {
		return respostasSubjetivas;
	}


	public void setRespostasSubjetivas(Map<QuestaoSubjetiva, String> respostasSubjetivas) {
		this.respostasSubjetivas = respostasSubjetivas;
	}

		

}
