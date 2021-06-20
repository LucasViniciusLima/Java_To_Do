package br.puc.repository;

import br.puc.model.Pedido;
import br.puc.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteEquals(Usuario cliente);

    Pedido findPedidoByCodigoEquals(String codigo);

}
