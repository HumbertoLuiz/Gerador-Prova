package br.edu.ifpr.app.sae.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "realizarProvas")
public class RealizarProva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_realizarprova")
	private Integer id;	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_prova")
	private Prova prova;	
	 
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "realizarprova_respostaObjetivas", joinColumns = @JoinColumn(name = "realizarprova_id", referencedColumnName = "id_realizarprova"),
   	inverseJoinColumns = @JoinColumn(name = "respostaObjetiva_id", referencedColumnName = "id_alternativa"))        
	 private List<Alternativa> respostasObjetivas = new ArrayList<>();

	
	@ElementCollection
	@CollectionTable(name = "realizarProva_respostasSubjetivas", 
    joinColumns = @JoinColumn(name = "realizarprova_id"))
    @Column(name="respostasSubjetivas")     
    private Map<QuestaoSubjetiva, String> respostasSubjetivas;
	
	private Float percentualAcerto;


	public RealizarProva() {
		// TODO Auto-generated constructor stub
	}


	public RealizarProva(Prova prova, List<Alternativa> respostasObjetivas,
			Map<QuestaoSubjetiva, String> respostasSubjetivas) {
		this.prova = prova;
		this.respostasObjetivas = respostasObjetivas;
		this.respostasSubjetivas = respostasSubjetivas;
	}

	

	public RealizarProva(Prova prova, List<Alternativa> respostasObjetivas,
			Map<QuestaoSubjetiva, String> respostasSubjetivas, Float percentualAcerto) {
		this.prova = prova;
		this.respostasObjetivas = respostasObjetivas;
		this.respostasSubjetivas = respostasSubjetivas;
		this.percentualAcerto = percentualAcerto;
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


	public List<Alternativa> getRespostasObjetivas() {
		return respostasObjetivas;
	}


	public void setRespostasObjetivas(List<Alternativa> respostasObjetivas) {
		this.respostasObjetivas = respostasObjetivas;
	}


	public Map<QuestaoSubjetiva, String> getRespostasSubjetivas() {
		return respostasSubjetivas;
	}


	public void setRespostasSubjetivas(Map<QuestaoSubjetiva, String> respostasSubjetivas) {
		this.respostasSubjetivas = respostasSubjetivas;
	}


	public Float getPercentualAcerto() {
		return percentualAcerto;
	}


	public void setPercentualAcerto(Float percentualAcerto) {
		this.percentualAcerto = percentualAcerto;
	}
		

}
