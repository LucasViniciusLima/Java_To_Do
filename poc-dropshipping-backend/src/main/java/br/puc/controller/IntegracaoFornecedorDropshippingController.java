package br.puc.controller;

import br.puc.model.Pedido;
import br.puc.service.PedidoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Serviço de integração com a API do fornecedor.
 */
@RestController
@RequestMapping({"/integracao/fornecedor"})
public class IntegracaoFornecedorDropshippingController {

    private final PedidoService pedidoService;

    public IntegracaoFornecedorDropshippingController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    /**
     * Atualiza o status de envio de um pedido por codigo do pedido.
     * @param codigo
     * @param status
     * @return
     */
    @GetMapping("/listarPedido/{codigo}/{status}")
    public String atualizarStatusPedidoCliente(@PathVariable String codigo, @PathVariable String status) {
        return pedidoService.atualizarStatusPedidoCliente(codigo, status);
    }

    /**
     * Lista os pedidos abertos para processamento para o fornecedor.
     * @return
     */
    @GetMapping("/listarPedidosAbertos")
    public List<Pedido> listarPedidosAbertos() {
        return pedidoService.listarPedidosAbertos();
    }

}
