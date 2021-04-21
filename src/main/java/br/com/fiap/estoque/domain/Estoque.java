package br.com.fiap.estoque.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = Estoque.TABLE)
public class Estoque implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final String TABLE = "TAB_ESTOQUE";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idEstoque;

	private Integer idEstabelecimento;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Item")
	private List<Item> itens;

	public Estoque() {
		super();
	}

	public Estoque(Integer idEstoque, Integer idEstabelecimento, List<Item> itens) {
		super();
		this.idEstoque = idEstoque;
		this.idEstabelecimento = idEstabelecimento;
		this.itens = itens;
	}

	public Estoque(Estoque estoque) {
		super();
		this.idEstoque = estoque.getIdEstoque();
		this.idEstabelecimento = estoque.getIdEstabelecimento();
		this.itens = estoque.getItens();
	}

	public Integer getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(Integer idEstoque) {
		this.idEstoque = idEstoque;
	}

	public Integer getIdEstabelecimento() {
		return idEstabelecimento;
	}

	public void setIdEstabelecimento(Integer idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEstoque == null) ? 0 : idEstoque.hashCode());
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
		Estoque other = (Estoque) obj;
		if (idEstoque == null) {
			if (other.idEstoque != null)
				return false;
		} else if (!idEstoque.equals(other.idEstoque))
			return false;
		return true;
	}

}
