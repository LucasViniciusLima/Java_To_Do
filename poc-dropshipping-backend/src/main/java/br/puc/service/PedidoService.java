package br.puc.service;

import br.puc.model.Pedido;
import br.puc.model.Usuario;
import br.puc.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final UsuarioService usuarioService;

    public PedidoService(PedidoRepository pedidoRepository, UsuarioService usuarioService) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioService = usuarioService;
    }

    private Usuario getUsuario() {
        return usuarioService.recuperarUsuarioSessao();
    }

    public List<Pedido> listarPedidosCliente() {
        return pedidoRepository.findByClienteEquals(getUsuario());
    }

    public Pedido listarPedidosClientePorCodigo(String codigo) {
        return pedidoRepository.findPedidoByCodigoEquals(codigo);
    }

    public Pedido finalizarPedido(Pedido pedido) throws RuntimeException {
        // TODO implementar metodo
        throw new RuntimeException("Método não implementado");
    }

    public String atualizarStatusPedidoCliente(String codigo, String status) {
        // TODO implementar metodo
        throw new RuntimeException("Método não implementado");
    }

    public List<Pedido> listarPedidosAbertos() {
        // TODO implementar metodo
        throw new RuntimeException("Método não implementado");
    }
}
