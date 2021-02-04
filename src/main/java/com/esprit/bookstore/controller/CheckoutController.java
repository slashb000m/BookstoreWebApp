package com.esprit.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.bookstore.payment.ChargeRequest;
import com.esprit.bookstore.payment.ChargeRequest.Currency;
@RestController
public class CheckoutController {

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", "pk_test_51IGiGyBAZSsgOczKZh2EsCfXx6wGrJzyVKUFOrFdJVRtcZlVdmSuhHmg66ZS6XAVQvFVRkk8JR1Qhgv2SmSMn8lV00Y1ambCoV");
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        return "checkout";
    }
}
