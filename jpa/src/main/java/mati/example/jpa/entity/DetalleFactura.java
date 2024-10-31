package mati.example.jpa.entity;

import jakarta.persistence.*;
import mati.example.jpa.model.Factura;

public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "factura_id")

    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Product
            producto;

}