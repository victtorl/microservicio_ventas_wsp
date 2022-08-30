package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Pedido;




@Repository
public class PedidosDaoImpl implements PedidosDao {
	@Autowired
	PedidosJpaSpring pedidos;
	@Override
	public List<Pedido> devolverPedidos() {		
		return pedidos.findAll();
	}
	
	@Override
	public List<Pedido> devolverPedidosOlvidados() {		
		return pedidos.findAll();
	}
	
	@Override
	public List<Pedido> devolverPedidosPendientes() {		
		return pedidos.findAll();
	}
	
	@Override
	public void guardarPedidoDAO(Pedido pedido) {
		 pedidos.save(pedido);
	}
	
	@Override
	public Pedido obtenerPedidoporIdDAO(Integer id) {
		return pedidos.findById(id).get();
	}
	
}
