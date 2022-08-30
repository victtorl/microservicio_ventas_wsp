package dao;
import org.springframework.data.jpa.repository.JpaRepository;

import model.Pedido;



public interface PedidosJpaSpring extends JpaRepository<Pedido,Integer> {

}
