package the.best.amazonclonebackend.resource;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import the.best.amazonclonebackend.dto.Response;
import the.best.amazonclonebackend.service.UserService;

import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserResourse {
    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<Response> getProfile() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(System.currentTimeMillis() / 1000L)
                        .data(Map.of("profile", userService.getUserProfile()))
                        .message("Profile retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );

    }
}
