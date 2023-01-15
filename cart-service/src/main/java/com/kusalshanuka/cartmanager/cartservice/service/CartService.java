package com.kusalshanuka.cartmanager.cartservice.service;

import java.util.List;

import com.kusalshanuka.cartmanager.cartservice.model.Cart;

public interface CartService {

	/**
	 * 
	 * @param cart
	 * @return
	 */
	public Cart addCartItem(Cart cart) throws RuntimeException;
	
	/**
	 * 
	 * @param timeZoneName
	 * @return
	 */
	public List<Cart> getAllCartItems();
	
	/**
	 * 
	 * @param intemId
	 * @return
	 */
	public boolean removeCartItem(int itemId);
	
}
