package com.demo.ecommerce.services;

import com.demo.ecommerce.entities.Product;
import com.demo.ecommerce.entities.ShoppingCart;
import com.demo.ecommerce.repository.IProductsRepository;
import com.demo.ecommerce.repository.IShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Qualifier("IShopping")
@Service
public class ShoppingCartService{

    @Autowired
    @Qualifier("IShoppingCartRepository")
    private IShoppingCartRepository repository;
    @Autowired
    @Qualifier("IProductsRepository")
    private IProductsRepository repositoryProduct;

    public ShoppingCart createToCart(ShoppingCart shoppingCart) {

        return repository.save(shoppingCart);
    }

    public List<ShoppingCart> lstShoppingCart(){

        return repository.findAll();
    }

    public ShoppingCart getShoppingCartById(Integer id){
        return repository.findById(id).get();
    }

    public ShoppingCart addProductToShoppingCart(Integer idProduct, int quantityOfProducts, Integer id) throws Exception{
        //CREO AUXILIARES DE CARRITO Y PRODUCTO
        ShoppingCart auxShoppingCart = repository.findById(id).get();
        Product auxProduct = repositoryProduct.findById(idProduct).get();

        // ESTA ACTIVO?
       // if(!auxProduct.isEnabled()){
         //   throw new Exception("Is not enabled");
        //}
        //HAY STOCK?
        if(auxProduct.getStock() < quantityOfProducts){
            throw new Exception("no stock");
            }else {
                //TIENE DESCUENTO?
                if(auxProduct.isPromotion()){
                    auxProduct.setPrice((long) (0.90 * auxProduct.getPrice()));
                    }
        }
        //LE DESCUENTO LO QUE COMPRO AL STOCK
        // repositoryProduct.findById(idProduct).get().setStock(auxProduct.getStock() - quantityOfProducts);

        //AGREGO EL PRODUCTO A AL CARRITO(donde esta la lista de todos los productos)
        auxShoppingCart.getLstProduct().add(auxProduct);
        auxShoppingCart.setTotal((double) (quantityOfProducts * auxProduct.getPrice()));

        //RETORNO EL CARRITO CON EL PRODUCTO GUARDADO
        return repository.save(auxShoppingCart);
    }
}
