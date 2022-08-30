package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Pedido;
import service.ServicePedidos;


@CrossOrigin(origins="*")
@RestController
public class PedidosController {
	@Autowired
	ServicePedidos service;
	
	@GetMapping (value ="/", produces = MediaType.APPLICATION_JSON_VALUE)
		public String Holamundo() {
			return "buena suerte";
		}
	
	@GetMapping (value ="/api/atendidos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> devolverPedidos () {
		return service.devolverPedidosDisponibles();
	}
	
	@GetMapping (value ="/api/olvidados", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> devolverPedidosOlvidados () {
		return service.devolverPedidosOlvidadosService();
	}
	
	@GetMapping (value ="/api/pendientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> devolverPedidosPendientes () {
		return service.devolverPedidosPendientesService();
	}
	
	
	@PostMapping("/pedido")
	public void guardarPedidoDAO(@RequestBody Pedido pedido) {
		 service.guardarPedido(pedido);
	}
	
	@GetMapping("/pedido/{id}")
	public ResponseEntity<Pedido> ObtenerPedidoxid(@PathVariable Integer id){
		
			try {
				Pedido pedid=service.obtenerPedidoxID(id);
				return  new ResponseEntity<Pedido>(pedid,HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
			}
	}
	
	@PutMapping("/pedido/{id}")
	public ResponseEntity<?> actualizarDisponiblidad(@RequestBody Pedido pedido,@PathVariable Integer id){
		try {
			Pedido pedidoexistente=service.obtenerPedidoxID(id);
			
			pedidoexistente.setEstado(pedido.getEstado());
			
			service.guardarPedido(pedidoexistente);
			
			return  new ResponseEntity<Pedido>(pedidoexistente,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Pedido>(HttpStatus.NOT_FOUND);
		}
	}
}
