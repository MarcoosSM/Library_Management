package entidades;

public class Factura {
	// atributos
		private int idFactura;
		private int idPedido;
		private int idCliente;
		private double totalFactura;
		
		// constructor
		public Factura(int idFactura, int idPedido, int idCliente, double totalFactura) {
			this.idFactura = idFactura;
			this.idPedido = idPedido;
			this.idCliente = idCliente;
			this.totalFactura = totalFactura;
		}
		
		// getters and setters
		public int getIdFactura() {
			return idFactura;
		}

		@SuppressWarnings("unused")
		private void setIdFactura(int idFactura) {
			this.idFactura = idFactura;
		}

		public int getIdPedido() {
			return idPedido;
		}

		@SuppressWarnings("unused")
		private void setIdPedido(int idPedido) {
			this.idPedido = idPedido;
		}

		public int getIdCliente() {
			return idCliente;
		}

		@SuppressWarnings("unused")
		private void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}

		public double getTotalFactura() {
			return totalFactura;
		}

		@SuppressWarnings("unused")
		private void setTotalFactura(double totalFactura) {
			this.totalFactura = totalFactura;
		}
}