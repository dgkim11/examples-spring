package example.spring.data;

import example.spring.data.config.SpringConfig;
import example.spring.data.entity.Product;
import example.spring.data.repository.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * User : Dongle (Dongkyun)
 * Date : 2016. 10. 8.
 */
public class CrudExampleApp {
    private ApplicationContext context;
    ProductRepository productRepository;

    public static void main(String[] args)  {
        CrudExampleApp theApp = new CrudExampleApp();
        theApp.initSpring();
        theApp.createProducts();
        theApp.printAllProducts();
    }

    private void initSpring()   {
        context = new AnnotationConfigApplicationContext(SpringConfig.class);
        productRepository = context.getBean(ProductRepository.class);
    }

    private void createProducts()   {
        Product p1 = new Product("product1", 10000);
        productRepository.save(p1);
    }

    private void printAllProducts() {
        Iterable<Product> products = productRepository.findAll();
        for(Product product : products) {
            System.out.println("product : " + product.getName());
        }
    }

    private void createCustomers()  {

    }

    private void createOrder()  {

    }

    private void updateProduct()   {

    }

    private void updateCustomer()   {

    }

    private void deleteOrder()  {

    }
}
