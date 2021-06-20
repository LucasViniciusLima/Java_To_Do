package br.puc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.puc.model.ItemCarrinho;
import br.puc.service.ItemCarrinhoService;

/**
 * Carrinho de compras.
 */
@RestController
@RequestMapping({ "/carrinho" })
public class CarrinhoController {

	private final ItemCarrinhoService carrinhoService;

	@Autowired
	public CarrinhoController(ItemCarrinhoService carrinhoService) {
		this.carrinhoService = carrinhoService;
	}

    /**
     * Lista os itens no carrinho do cliente logado.
     * @return
     */
	@GetMapping("/listar")
	public List<ItemCarrinho> listarItensNoCarrinho() {
		return carrinhoService.getAll();
	}

    /**
     * Inclui um produto no carrinho do cliente logado.
     * @param item
     * @return
     */
	@PostMapping("/incluir")
	public ResponseEntity<String> incluirItemCarrinho(@RequestBody ItemCarrinho item) {
		carrinhoService.saveOrUpdate(item);
		return ResponseEntity.ok("Incluido no carrinho");
	}

    /**
     * Remove o produto do carrinho do cliente logado.
     * @param item
     * @return
     */
	@PostMapping("/remover")
	public ResponseEntity<String> removerItemCarrinho(@RequestBody ItemCarrinho item) {
		carrinhoService.delete(item);
		return ResponseEntity.ok("Removido do carrinho");
	}

    /**
     * Finaliza os itens no carrinho do cliente gerando o pedido de compra.
     * @return
     */
	@GetMapping("/checkout")
	public ResponseEntity<String> finalizarCarrinho() {
		final Double frete = 34.0d;
		return ResponseEntity.ok(carrinhoService.finalizarCarrinhoCompras(frete));
	}
}