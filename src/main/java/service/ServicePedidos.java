package service;
import java.util.List;
import model.Pedido;



public interface ServicePedidos {
	public List<Pedido> devolverPedidosDisponibles ();
	public List<Pedido> devolverPedidosOlvidadosService ();
	public List<Pedido> devolverPedidosPendientesService ();
	
	public void guardarPedido(Pedido pedido);
	
	public  Pedido obtenerPedidoxID(Integer id);
}
