package com.esprit.bookstore.payment;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
@Service
public class StripeService {

	
	 
	    @PostConstruct
	    public void init() {
	        Stripe.apiKey = "sk_test_51IGiGyBAZSsgOczKgZkKXkHp7aC2P3djJcftGXKy4ZmryrHW5vLyffvmvSXUVxmcRrGl4AHUkwSg7FkXkGo9nH4y00rhG9d6H8";
	    }

	    public Charge charge(ChargeRequest chargeRequest)
	            throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
	        Map<String, Object> chargeParams = new HashMap<>();
	        chargeParams.put("amount", chargeRequest.getAmount());
	        chargeParams.put("currency", chargeRequest.getCurrency());
	        chargeParams.put("description", chargeRequest.getDescription());
	        chargeParams.put("source", chargeRequest.getStripeToken());
	        return Charge.create(chargeParams);
	    }
}
