package com.api.vendas.domain.entity;

public class ItemPedido {

	private Integer id;
	private Pedido pedido;
	private Produto produto;
	private Integer quatidade;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getQuatidade() {
		return quatidade;
	}
	public void setQuatidade(Integer quatidade) {
		this.quatidade = quatidade;
	}
	
	
}
