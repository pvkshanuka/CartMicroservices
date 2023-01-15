package com.kusalshanuka.cartmanager.cartservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kusalshanuka.cartmanager.cartservice.model.Cart;
import com.kusalshanuka.cartmanager.cartservice.service.CartService;

@RestController
@RequestMapping(value = "/cartservice")
public class CartController {

	@Autowired
	CartService cartService;
	
	final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	private static final String SECTION_BASE_CODE = "Cart Service Controller";
	
	@GetMapping(value = "/carts", produces = "application/json")
	public ResponseEntity<List<Cart>> getAllCartItems() {
		logger.info(SECTION_BASE_CODE+ ":getAllCartItems");
			return ResponseEntity.ok(cartService.getAllCartItems());
	}
	
	@PostMapping(value = "/carts", produces = "application/json")
	@PreAuthorize("hasRole('ROLE_admin')")
	public ResponseEntity<Cart> addCartItem(@RequestBody @Valid Cart  cart) {
		logger.info(SECTION_BASE_CODE+ ":addCartItem");
		return ResponseEntity.ok(cartService.addCartItem(cart));
		
	}
	
	@DeleteMapping(value = "/carts/{itemId}", produces = "application/json")
	public ResponseEntity<Boolean> removeCartItem(@Valid @PathVariable int  itemId) {
		logger.info(SECTION_BASE_CODE+ ":removeCartItem");
		 if (cartService.removeCartItem(itemId)) {
			 return ResponseEntity.ok(cartService.removeCartItem(itemId));
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
}
