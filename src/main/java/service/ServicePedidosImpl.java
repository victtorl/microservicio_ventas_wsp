package service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PedidosDao;
import model.Pedido;




@Service
public class ServicePedidosImpl implements ServicePedidos {
	@Autowired
	PedidosDao dao;
	@Override
	public List<Pedido> devolverPedidosDisponibles() {
		List <Pedido> pedidos = dao.devolverPedidos();
		return pedidos.stream().filter(t->t.getEstado()==1).collect(Collectors.toList());
	}
	@Override
	public List<Pedido> devolverPedidosOlvidadosService() {
		List <Pedido> pedidos = dao.devolverPedidos();
		return pedidos.stream().filter(t->t.getEstado()==3).collect(Collectors.toList());
	}
	@Override
	public List<Pedido> devolverPedidosPendientesService() {
		List <Pedido> pedidos = dao.devolverPedidos();
		return pedidos.stream().filter(t->t.getEstado()==2).collect(Collectors.toList());
	}
	
	
	public void guardarPedido(Pedido pedido) {
	     dao.guardarPedidoDAO(pedido);
	}
	

	public Pedido  obtenerPedidoxID(Integer id) {
		return dao.obtenerPedidoporIdDAO(id);
	}
}
