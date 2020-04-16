package br.com.gerenciador.moneyger.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.gerenciador.moneyger.model.enums.TipoReceita;

@Entity
@Table(name = "TB_RECEITA")
@SequenceGenerator(name = "receita", sequenceName = "SQ_TB_RECEITA", allocationSize = 1)
public class Receita implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cd_receita")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ds_receita")
	private String descricao;
	
	@Column(name = "vl_receita")
	private BigDecimal valor;
	
	@Column(name = "dt_receita")
	private Instant data;

	@Column(name = "nr_receita")
	private Integer tipoReceita;

	@ManyToOne
	@JoinColumn(name = "cd_usuario")
	private User client;

	public Receita() {

	}

	public Receita(Long id, String descricao, BigDecimal valor, Instant data, TipoReceita tipoReceita, User client) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		setTipoReceita(tipoReceita);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public TipoReceita getTipoReceita() {
		return TipoReceita.valueOf(tipoReceita);
	}

	public void setTipoReceita(TipoReceita tipoReceita) {
		if (tipoReceita != null) {
			this.tipoReceita = tipoReceita.getCode();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receita other = (Receita) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
