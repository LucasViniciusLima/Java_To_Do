package br.puc.service;

import br.puc.model.ItemCatalogo;
import br.puc.repository.ItemCatalagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCatalagoService {

	private final ItemCatalagoRepository catalagoRepository;

	@Autowired
	public ItemCatalagoService(ItemCatalagoRepository catalagoRepository) {
		this.catalagoRepository = catalagoRepository;
	}

	public List<ItemCatalogo> findByName(String name) {
		return catalagoRepository.findByNameIsLike(name);
	}

	public List<ItemCatalogo> getAll() {
		return catalagoRepository.findAll();
	}

	public ItemCatalogo getById(long id) {
		return catalagoRepository.findById(id).get();
	}
}
