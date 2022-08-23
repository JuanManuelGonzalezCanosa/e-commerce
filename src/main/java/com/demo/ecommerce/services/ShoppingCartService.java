package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.OrderItem;
import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.repository.IOrderItemRepository;
import com.demo.ecommerce.repository.IShoppingCartRepository;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Qualifier("IShopping")
@Service
//@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartService{

    @Autowired
    @Qualifier("IShoppingCartRepository")
    private IShoppingCartRepository repository;

    @Autowired
    private ModelMapper mapper;


    @Autowired
    @Qualifier("IOrderItemRepository")
    private IOrderItemRepository repositoryIOrderItem;

    public ShoppingCart createToCart(ShoppingCart shoppingCart) {
        return repository.save(shoppingCart);
    }

    public List<ShoppingCart> lstShoppingCart() {
        return repository.findAll();
    }

    public ShoppingCart getShoppingCartById(Integer id) {
        return repository.findById(id).get();
    }

    public ShoppingCart addProductToShoppingCart(OrderItem orderItem, Integer id) throws Exception {
        //CREO AUXILIARES DE CARRITO Y PRODUCTO
        ShoppingCart auxShoppingCart = repository.findById(id).get();

        // ESTA ACTIVO?
        if (!orderItem.getItem().isEnabled()) {
            throw new Exception("Is not enabled");
        }

        //refactoirzar con lambda (pablo)
        //HAY STOCK?
        if(orderItem.getItem().getStock() < orderItem.getQuantity()){
            throw new Exception("no stock");
            }else {
                //TIENE DESCUENTO?
                if(orderItem.getItem().isPromotion()){
                    orderItem.getItem().setPrice((long) (0.90 * orderItem.getItem().getPrice()));
                    }
        }

        //LE DESCUENTO LO QUE COMPRO AL STOCK
        //repositoryProduct.findById(idProduct).get().setStock(auxProduct.getStock() - quantityOfProducts);

        //AGREGO EL PRODUCTO A AL CARRITO(donde esta la lista de todos los productos) Y SUMO EL TOTAL
        auxShoppingCart.getLstOrderItem().add(orderItem);
        auxShoppingCart.setTotal(orderItem.getQuantity() * orderItem.getItem().getPrice());

        //RETORNO EL CARRITO CON EL PRODUCTO GUARDADO
        return repository.save(auxShoppingCart);
    }
}
