package modelo;

public class Cliente extends Usuario {
    private String codigoDeDescuento;

    public Cliente(String login, String password, String id, String codigoDeDescuento) {
        super(login, password, id);
        this.codigoDeDescuento = codigoDeDescuento;
    }

    public Reserva hacerReserva(int cantidad, boolean hayNinos, boolean hayJovenes) {
        return new Reserva(cantidad, hayNinos, hayJovenes);
    }

    public String getCodigoDeDescuento() {
        return codigoDeDescuento;
    }
}
