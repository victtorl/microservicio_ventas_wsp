package model;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;


@Entity
@Table(name="venta")
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPedido;
	private String telefono; 
	private LocalDateTime fecha;
	private double precio;
	private int cantidad;
	private String detalle;
	private int estado;
	
	public Pedido() {
		
	}
	
	



	public int getIdPedido() {
		return idPedido;
	}





	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}





	public String getTelefono() {
		return telefono;
	}





	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}





	public LocalDateTime getFecha() {
		return fecha;
	}





	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}





	public double getPrecio() {
		return precio;
	}





	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}





	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}





	public int getEstado() {
		return estado;
	}





	public void setEstado(int estado) {
		this.estado = estado;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
