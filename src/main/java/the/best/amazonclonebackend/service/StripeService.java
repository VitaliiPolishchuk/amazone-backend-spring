package the.best.amazonclonebackend.service;

import com.stripe.exception.*;
import com.stripe.model.Charge;
import the.best.amazonclonebackend.dto.ChargeRequest;

public interface StripeService {
    Charge charge(ChargeRequest chargeRequest) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException;
}
