package modelo;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

public class ReporteVentas {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Venta> ventas;

    public ReporteVentas(LocalDate fechaInicio, LocalDate fechaFin, List<Venta> ventas) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ventas = ventas;
    }

    public double totalRubro(RubroVenta rubro) {
        return ventas.stream()
                .filter(v -> v.getRubro() == rubro)
                .mapToDouble(Venta::getTotal)
                .sum();
    }

    public Map<LocalDate, Double> generarDiario() {
        return ventas.stream()
                .collect(Collectors.groupingBy(v -> v.getFecha().toLocalDate(),
                        Collectors.summingDouble(Venta::getTotal)));
    }

    public Map<Integer, Double> generarSemanal() {
        return ventas.stream()
                .collect(Collectors.groupingBy(v -> v.getFecha().getDayOfYear() / 7,
                        Collectors.summingDouble(Venta::getTotal)));
    }

    public Map<Integer, Double> generarMensual() {
        return ventas.stream()
                .collect(Collectors.groupingBy(v -> v.getFecha().getMonthValue(),
                        Collectors.summingDouble(Venta::getTotal)));
    }
}
