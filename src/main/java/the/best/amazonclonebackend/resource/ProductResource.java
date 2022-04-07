package the.best.amazonclonebackend.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import the.best.amazonclonebackend.dto.Response;
import the.best.amazonclonebackend.model.Product;
import the.best.amazonclonebackend.service.ProductService;

import javax.validation.Valid;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductResource {
    private final ProductService productService;

    @GetMapping("/")
    public ResponseEntity<Response> getProducts() {
        return ResponseEntity.ok(
            Response.builder()
                .timeStamp(System.currentTimeMillis() / 1000L)
                .data(Map.of("products", productService.list(30)))
                .message("Products retrieved")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response> save(@RequestBody @Valid Product product){
        return ResponseEntity.ok(
            Response.builder()
                .timeStamp(System.currentTimeMillis() / 1000L)
                .data(Map.of("product", productService.create(product)))
                .message("Product created")
                .status(CREATED)
                .statusCode(CREATED.value())
                .build()
        );
    }
}
