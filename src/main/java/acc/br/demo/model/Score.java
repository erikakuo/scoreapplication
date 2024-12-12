package acc.br.demo.model;

import org.springframework.data.annotation.Id;


public class Score {
	
	@Id
	private	Integer id;
	private Integer vitorias ;
	private Integer derrotas ;
	private Integer empates ;
	
	public Score(Integer vitorias, Integer derrotas, Integer empates) {
		super();
		this.vitorias = vitorias;
		this.derrotas = derrotas;
		this.empates = empates;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVitorias() {
		return vitorias;
	}
	public void setVitorias(Integer vitorias) {
		this.vitorias = vitorias;
	}
	public Integer getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(Integer derrotas) {
		this.derrotas = derrotas;
	}
	public Integer getEmpates() {
		return empates;
	}
	public void setEmpates(Integer empates) {
		this.empates = empates;
	}
}