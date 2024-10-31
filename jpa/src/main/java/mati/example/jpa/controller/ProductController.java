package mati.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mati.example.jpa.model.Factura;
import mati.example.jpa.entity.Product;
import mati.example.jpa.model.FacturaService;
import mati.example.jpa.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productoService;

    @Autowired
    private FacturaService facturaService;

    @PostMapping("/facturas")
    public ResponseEntity<Factura> crearFactura(@RequestBody List<Product> productos) {
        Factura factura = facturaService.crearNuevaFactura(productos);
        return ResponseEntity.status(HttpStatus.CREATED).body(factura);
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/facturas")
    public ResponseEntity<Factura> createFactura(@RequestBody List<Product> productos) {
        Factura factura = new Factura();
        factura.setProductos(productos);
        factura.setTotal(productoService.calcularTotal(productos));
        return ResponseEntity.status(HttpStatus.CREATED).body(factura);
    }
}
