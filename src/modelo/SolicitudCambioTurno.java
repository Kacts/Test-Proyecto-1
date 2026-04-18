package modelo;

public class SolicitudCambioTurno {
    private TipoSolicitudTurno tipo;
    private EstadoSolicitudTurno estado;
    private String idCambioTurno;

    public SolicitudCambioTurno(TipoSolicitudTurno tipo) {
        this.idCambioTurno = "SC-" + System.nanoTime();
        this.tipo = tipo;
        this.estado = EstadoSolicitudTurno.PENDIENTE;
    }

    public SolicitudCambioTurno(String idCambioTurno, TipoSolicitudTurno tipo, EstadoSolicitudTurno estado) {
        this.idCambioTurno = idCambioTurno;
        this.tipo = tipo;
        this.estado = estado;
    }

    public void aprobar() {
        this.estado = EstadoSolicitudTurno.APROBADA;
    }

    public void rechazar() {
        this.estado = EstadoSolicitudTurno.RECHAZADA;
    }

    public EstadoSolicitudTurno getEstado() {
        return estado;
    }

    public TipoSolicitudTurno getTipo() {
        return tipo;
    }

    public String getIdCambioTurno() {
        return idCambioTurno;
    }
}
