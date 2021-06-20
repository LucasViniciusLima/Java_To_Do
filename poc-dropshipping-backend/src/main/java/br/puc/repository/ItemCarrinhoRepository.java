package br.puc.repository;

import br.puc.model.ItemCarrinho;
import br.puc.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long> {

    List<ItemCarrinho> findByClienteEquals(Usuario cliente);

}
