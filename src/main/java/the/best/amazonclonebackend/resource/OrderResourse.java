package the.best.amazonclonebackend.resource;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;
import the.best.amazonclonebackend.dto.ChargeRequest;
import the.best.amazonclonebackend.dto.OrderRequest;
import the.best.amazonclonebackend.dto.Response;
import the.best.amazonclonebackend.model.Order;
import the.best.amazonclonebackend.model.Product;
import the.best.amazonclonebackend.service.OrderService;
import the.best.amazonclonebackend.service.StripeService;

import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderResourse {
    private final StripeService paymentsService;
    private final OrderService orderService;

    @PostMapping("/charge")
    public ResponseEntity<Response> charge(@RequestBody @Valid ChargeRequest chargeRequest)
            throws StripeException {
        chargeRequest.setCurrency(ChargeRequest.Currency.USD);
        Charge charge = paymentsService.charge(chargeRequest);

        return ResponseEntity.ok(
            Response.builder()
                .timeStamp(System.currentTimeMillis() / 1000L)
                .data(Map.of("charge", charge))
                .message("Charge completed")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response> create(@RequestBody @Valid OrderRequest orderRequest) {
        orderService.create(orderRequest);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(System.currentTimeMillis() / 1000L)
                        .message("Order created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/")
    public ResponseEntity<Response> get() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(System.currentTimeMillis() / 1000L)
                        .data(Map.of("orders", orderService.getAll()))
                        .message("Orders retrieved")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

//    @ExceptionHandler(StripeException.class)
//    public String handleError(Model model, StripeException ex) {
//        model.addAttribute("error", ex.getMessage());
//        return "result";
//    }
}