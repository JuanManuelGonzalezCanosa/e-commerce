package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.repository.IProductsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private IProductsRepository repository;

    @InjectMocks
    ProductService productService;

    private Product product;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        //product = new Product(1, "turron", "comida", 200, "asd", 25.0, true,true);
        product = new Product();
        product.setId(1);
        product.setName("turron");
        product.setDescription("comida");
        product.setStock(200);
        product.setDescription("asd");
        product.setPrice(25.0);
        product.setPromotion(true);
        product.setEnabled(true);
    }

    @Test
    void lstProductIsNotNull() {
        when(repository.findAll()).thenReturn(Arrays.asList(product));
        assertNotNull(productService.lstProduct());

    }

    @Test
    void createProductIsNotNull(){
        when(repository.save(any(Product.class))).thenReturn(product);
        assertNotNull(productService.createProduct(new Product()));
    }
}