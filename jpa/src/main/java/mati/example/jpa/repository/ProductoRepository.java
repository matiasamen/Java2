package mati.example.jpa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import mati.example.jpa.entity.Product;

public interface ProductoRepository extends JpaRepository<Product, Long> { }
