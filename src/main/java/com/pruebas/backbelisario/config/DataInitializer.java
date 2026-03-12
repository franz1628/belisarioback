package com.pruebas.backbelisario.config;

import com.pruebas.backbelisario.model.Category;
import com.pruebas.backbelisario.model.Product;
import com.pruebas.backbelisario.repository.CategoryRepository;
import com.pruebas.backbelisario.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            Category pollos = new Category(null, "Pollos a la Brasa", "Nuestros deliciosos pollos a la brasa", "/images/pollo-entero.jpg");
            Category guarniciones = new Category(null, "Guarniciones", "Acompañamientos perfectos", "/images/papas-fritas.jpg");
            Category bebidas = new Category(null, "Bebidas", "Refrescos y bebidas tradicionales", "/images/chicha.jpg");

            categoryRepository.saveAll(Arrays.asList(pollos, guarniciones, bebidas));

            Product polloEntero = new Product(null, "1 Pollo a la Brasa", "Delicioso pollo a la brasa con papas y ensalada.", new BigDecimal("65.00"), "/images/pollo-entero.jpg", pollos);
            Product medioPollo = new Product(null, "1/2 Pollo a la Brasa", "Medio pollo a la brasa con papas y ensalada.", new BigDecimal("35.00"), "/images/medio-pollo.jpg", pollos);
            Product cuartoPollo = new Product(null, "1/4 Pollo a la Brasa", "Cuarto de pollo a la brasa con papas y ensalada.", new BigDecimal("20.00"), "/images/cuarto-pollo.jpg", pollos);

            Product papasFritas = new Product(null, "Papas Fritas", "Porción familiar de papas fritas crujientes. ¡Ideales para compartir!", new BigDecimal("15.00"), "/images/papas-fritas.jpg", guarniciones);
            Product tequenos = new Product(null, "Tequeños de Pollo a la Brasa", "6 unidades de tequeños rellenos de jugoso pollo a la brasa. Acompañados con salsa de palta.", new BigDecimal("12.00"), "/images/tequenos.jpg", guarniciones);

            Product chichaM = new Product(null, "Chicha Morada 1L", "Jarra de chicha morada natural y refrescante.", new BigDecimal("15.00"), "/images/chicha.jpg", bebidas);
            Product inkaKola = new Product(null, "Inka Kola 1.5L", "Gaseosa Inka Kola familiar. El sabor del Perú.", new BigDecimal("10.00"), "/images/inka-kola.jpg", bebidas);

            productRepository.saveAll(Arrays.asList(polloEntero, medioPollo, cuartoPollo, papasFritas, tequenos, chichaM, inkaKola));
        }
    }
}
