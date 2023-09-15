package fr.cindanojonathan.productservice.repository;

import fr.cindanojonathan.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
