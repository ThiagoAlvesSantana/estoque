package br.com.fiap.estoque.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = Item.TABLE)
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	protected static final String TABLE = "TAB_ITEM";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id_Item;

	private String nome;
	private String descricao;
	private Integer quantidade;
	private Double preco;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_Categoria")
	private Categoria categoria;

	public Item() {
		super();
	}

	public Item(Integer id_Item, String nome, String descricao, Integer quantidade, Double preco, Categoria categoria) {
		super();
		this.id_Item = id_Item;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.categoria = categoria;
	}

	public Item(Item item) {
		super();
		this.id_Item = item.getId_Item();
		this.nome = item.getNome();
		this.descricao = item.getDescricao();
		this.quantidade = item.getQuantidade();
		this.preco = item.getPreco();
		this.categoria = item.getCategoria();
	}

	public Integer getId_Item() {
		return id_Item;
	}

	public void setId_Item(Integer id_Item) {
		this.id_Item = id_Item;
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Item == null) ? 0 : id_Item.hashCode());
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
		Item other = (Item) obj;
		if (id_Item == null) {
			if (other.id_Item != null)
				return false;
		} else if (!id_Item.equals(other.id_Item))
			return false;
		return true;
	}

}