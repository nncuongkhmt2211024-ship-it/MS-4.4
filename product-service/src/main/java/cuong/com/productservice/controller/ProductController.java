package cuong.com.productservice.controller;

import cuong.com.productservice.dto.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products") // Định nghĩa đường dẫn gốc
public class ProductController {

    @GetMapping("/{id}") // Khi gọi /api/v1/products/1 thì số 1 sẽ lọt vào biến id
    public Product getProductById(@PathVariable Long id) {

        // Tạo dữ liệu giả để test kết nối (Sau này bạn sẽ thay bằng code gọi Database)
        Product product = new Product();
        product.setId(id);
        product.setName("Iphone 17");
        product.setPrice(123456.0);
        product.setStockQuantity(50);

        return product;
    }
}