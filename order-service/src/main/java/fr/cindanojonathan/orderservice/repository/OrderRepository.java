package fr.cindanojonathan.orderservice.repository;

import fr.cindanojonathan.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
