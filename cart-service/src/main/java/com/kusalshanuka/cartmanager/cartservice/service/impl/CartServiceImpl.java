package com.kusalshanuka.cartmanager.cartservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kusalshanuka.cartmanager.cartservice.model.Cart;
import com.kusalshanuka.cartmanager.cartservice.repository.CartRepository;
import com.kusalshanuka.cartmanager.cartservice.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;
	
	@Override
	public Cart addCartItem(Cart cart) throws RuntimeException{
		try {
		return cartRepository.save(cart);
		}catch (IllegalArgumentException e) {
			throw new RuntimeException("Cart item adding failed!",e);
		}
	}

	@Override
	public List<Cart> getAllCartItems() {
		return cartRepository.findAll();
	}

	@Override
	public boolean removeCartItem(int itemId){
		if (cartRepository.findById(itemId).isPresent()) {
			cartRepository.deleteById(itemId);
			return true;
		} else {
			return false;
		}
		
	}

}
