package br.puc.repository;

import br.puc.model.ItemCatalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCatalagoRepository extends JpaRepository<ItemCatalogo, Long> {

	List<ItemCatalogo> findByNameIsLike(@Param("name") String name);

}
