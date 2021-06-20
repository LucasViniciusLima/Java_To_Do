package br.puc.controller;

import br.puc.model.Pedido;
import br.puc.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Pedidos realizados pelo cliente.
 */
@RestController
@RequestMapping({"/pedido"})
public class PedidosController {

    private final PedidoService pedidoService;

    public PedidosController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    /**
     * Lista todos os pedidos realizados pelo cliente logado.
     * @return
     */
    @GetMapping("/listarPedidos")
    public List<Pedido> listarPedidosCliente() {
        return pedidoService.listarPedidosCliente();
    }

    /**
     * Lista um pedido por codigo.
     * @param codigo
     * @return
     */
    @GetMapping("/listarPedido/{codigo}")
    public Pedido listarPedidosCliente(@PathVariable String codigo) {
        return pedidoService.listarPedidosClientePorCodigo(codigo);
    }

    /**
     * Realiza o chechout de um pedido aberto.
     * @param pedido
     * @return
     */
    @PostMapping("/finalizarPedido")
    public Pedido finalizarPedido(@RequestBody Pedido pedido) {
        return pedidoService.finalizarPedido(pedido);
    }
}
