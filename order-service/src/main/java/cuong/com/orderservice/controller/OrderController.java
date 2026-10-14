package cuong.com.orderservice.controller;
import cuong.com.orderservice.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate; // Import RestTemplate

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    // Tiêm RestTemplate (đã có @LoadBalanced bên file Application)
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProduct2/{productId}")
    public Product getProductFromProductService2(@PathVariable String productId) {

        // Tạo đường dẫn dùng tên service
        String targetUrl = "http://product-service/api/v1/products/" + productId;

        // Gọi API bằng RestTemplate thay vì RestClient
        return restTemplate.getForObject(targetUrl, Product.class);
    }
}