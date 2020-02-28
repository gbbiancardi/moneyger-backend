package br.com.gerenciador.moneyger.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.gerenciador.moneyger.model.enums.StatusObjetivo;
import br.com.gerenciador.moneyger.model.enums.TipoObjetivo;

@Entity
public class Objetivo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private BigDecimal meta;
	private Date dataAtual;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataEstipulada;

	private Integer tipoObjetivo;
	
	private Integer statusObjetivo;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	public Objetivo() {

	}
	
	

	public Objetivo(Long id, String descricao, BigDecimal meta, Date dataAtual, Date dataEstipulada,
			TipoObjetivo tipoObjetivo, StatusObjetivo statusObjetivo, User client) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.meta = meta;
		this.dataAtual = dataAtual;
		this.dataEstipulada = dataEstipulada;
		setTipoObjetivo(tipoObjetivo);
		setStatusObjetivo(statusObjetivo);
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

	public BigDecimal getMeta() {
		return meta;
	}

	public void setMeta(BigDecimal meta) {
		this.meta = meta;
	}

	public Date getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}

	public Date getDataEstipulada() {
		return dataEstipulada;
	}

	public void setDataEstipulada(Date dataEstipulada) {
		this.dataEstipulada = dataEstipulada;
	}

	public StatusObjetivo getStatusObjetivo() {
		return StatusObjetivo.valueOf(statusObjetivo);
	}

	public void setStatusObjetivo(StatusObjetivo statusObjetivo) {
		if (statusObjetivo != null) {
			this.statusObjetivo = statusObjetivo.getCode();
		}
	}

	public TipoObjetivo getTipoObjetivo() {
		return TipoObjetivo.valueOf(tipoObjetivo);
	}

	public void setTipoObjetivo(TipoObjetivo tipoObjetivo) {
		if (tipoObjetivo != null) {
			this.tipoObjetivo = tipoObjetivo.getCode();
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
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
		Objetivo other = (Objetivo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
