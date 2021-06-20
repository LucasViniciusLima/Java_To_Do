package br.puc.service;

import br.puc.model.ItemCarrinho;
import br.puc.model.Pedido;
import br.puc.model.Usuario;
import br.puc.repository.ItemCarrinhoRepository;
import br.puc.repository.PedidoRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.puc.enummerator.StatusPedidoEnum.PEDIDO_GERADO;

@Service
public class ItemCarrinhoService {

    private final UsuarioService usuarioService;
	private final ItemCarrinhoRepository carrinhoRepository;
	private final PedidoRepository pedidoRepository;

    @Autowired
    public ItemCarrinhoService(UsuarioService usuarioService, ItemCarrinhoRepository carrinhoRepository, PedidoRepository pedidoRepository) {
        this.usuarioService = usuarioService;
        this.carrinhoRepository = carrinhoRepository;
		this.pedidoRepository = pedidoRepository;
	}

    public List<ItemCarrinho> getAll() {
		return carrinhoRepository.findByClienteEquals(getUsuario());
	}

	private Usuario getUsuario() {
		return usuarioService.recuperarUsuarioSessao();
	}

	public void saveOrUpdate(ItemCarrinho model) {
        model.setCliente(getUsuario());
		carrinhoRepository.save(model);
	}

	public void delete(ItemCarrinho model) {
		carrinhoRepository.deleteById(model.getId());
	}
	
	public String finalizarCarrinhoCompras(Double frete) {
		List<ItemCarrinho> itensCarrinho = this.getAll();

		Pedido pedido = new Pedido();
		pedido.setCodigo(RandomStringUtils.randomAlphanumeric(17).toUpperCase());
		pedido.setStatusPedido(PEDIDO_GERADO);
		pedido.setCliente(getUsuario());
		pedido.setTotal(frete + itensCarrinho.stream().mapToDouble(ItemCarrinho::getValor).sum());
		itensCarrinho.forEach(item -> pedido.getProdutos().add(item.getProduto()));

		carrinhoRepository.deleteAll(itensCarrinho);
		pedidoRepository.save(pedido);

		return pedido.getCodigo();
	}

}
