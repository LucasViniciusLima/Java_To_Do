package br.puc.model;

import javax.persistence.*;

/**
 * Classe representa um Produto incluido no carrinho de compras do cliente.
 */
@Entity
@Table(name = "carrinho")
public class ItemCarrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int quantidade;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "item_id", nullable = false)
	private ItemCatalogo produto;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Usuario cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public ItemCatalogo getProduto() {
		return produto;
	}

	public void setProduto(ItemCatalogo produto) {
		this.produto = produto;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public double getValor() {
		return produto.getVlrVenda();
	}
}
