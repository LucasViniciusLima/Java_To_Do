package br.puc.model;

import br.puc.enummerator.StatusPedidoEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe representa um pedido de compra realizado pelo cliente.
 */
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;

    @Enumerated
    @Column(columnDefinition = "smallint")
    private StatusPedidoEnum statusPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    private Double total;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="produto_pedido",
            joinColumns={@JoinColumn(name="pedido_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="produto_id", referencedColumnName="id")})
    private List<ItemCatalogo> produtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public StatusPedidoEnum getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedidoEnum statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ItemCatalogo> getProdutos() {
        if (this.produtos == null) {
            this.produtos = new ArrayList<>();
        }
        return produtos;
    }

    public void setProdutos(List<ItemCatalogo> produtos) {
        this.produtos = produtos;
    }
}
