package br.puc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.puc.model.ItemCatalogo;
import br.puc.service.ItemCatalagoService;

/**
 * Catalago de produtos disponiveis na loja Dropshipping.
 */
@RestController
@RequestMapping({ "/catalogo" })
public class CatalogoController {

	private final ItemCatalagoService catalagoService;

	@Autowired
	public CatalogoController(ItemCatalagoService catalagoService) {
		this.catalagoService = catalagoService;
	}

    /**
     * Lista os produtos disponiveis para venda.
     * @return
     */
	@GetMapping("/listar")
	public List<ItemCatalogo> catalogo() {
		return catalagoService.getAll();
	}

    /**
     * Consulta um produto por ID.
     * @param id
     * @return
     */
	@GetMapping("/codigo/{id}")
	private ItemCatalogo pesquisarItemPorCodigo(@PathVariable("id") long id) {
		return catalagoService.getById(id);
	}

    /**
     * Consulta um produto por descrição.
     * @param descricao
     * @return
     */
	@GetMapping("/descricao/{descricao}")
	private List<ItemCatalogo> pesquisarItemPorDescricao(@PathVariable("descricao") String descricao) {
		return catalagoService.findByName(descricao);
	}

}
