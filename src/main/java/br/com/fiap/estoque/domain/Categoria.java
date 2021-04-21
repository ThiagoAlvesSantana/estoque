package br.com.fiap.estoque.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Categoria.TABLE)
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final String TABLE = "TAB_CATEGORIA";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id_Categoria;

	private String nome;
	private String descricao;

	public Categoria() {
		super();
	}

	public Categoria(Integer idCategoria, String nome, String descricao) {
		super();
		this.id_Categoria = idCategoria;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Categoria(Categoria categoria) {
		super();
		this.id_Categoria = categoria.getId_Categoria();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
	}

	public Integer getId_Categoria() {
		return id_Categoria;
	}

	public void setId_Categoria(Integer id_Categoria) {
		this.id_Categoria = id_Categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Categoria == null) ? 0 : id_Categoria.hashCode());
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
		Categoria other = (Categoria) obj;
		if (id_Categoria == null) {
			if (other.id_Categoria != null)
				return false;
		} else if (!id_Categoria.equals(other.id_Categoria))
			return false;
		return true;
	}
}
