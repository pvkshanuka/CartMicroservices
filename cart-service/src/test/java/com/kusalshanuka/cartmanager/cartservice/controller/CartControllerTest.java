package com.kusalshanuka.cartmanager.cartservice.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.kusalshanuka.cartmanager.cartservice.model.Cart;
import com.kusalshanuka.cartmanager.cartservice.service.CartService;

@ContextConfiguration(classes = CartController.class)
@RunWith(SpringRunner.class)
public class CartControllerTest {

	@Autowired
	CartController cartController;

	@MockBean
	CartService cartService;

@Test
public void getAllCartItemsTest() {

		when(cartService.getAllCartItems()).thenReturn(Stream.of(new Cart(1,"Item1",20.0,5.0)).collect(Collectors.toList()));
		
		List<Cart> allCartItems = cartController.getAllCartItems().getBody();
		
		assertEquals(1, allCartItems.size());
		
}

	@Test
	public void addCartItemTest() {

		Cart cart = new Cart(1, "Item1", 20.0, 5.0);

		when(cartService.addCartItem(cart)).thenReturn(cart);

		assertEquals(1, cartController.addCartItem(cart).getBody().getId());

	}

@Test
public void removeCartItemTestTrue() {

		when(cartService.removeCartItem(1)).thenReturn(true);
		
		assertEquals(true, cartController.removeCartItem(1).getBody());
		
}

@Test
public void removeCartItemTestFalse() {

		when(cartService.removeCartItem(1)).thenReturn(false);
		
		assertEquals(404, cartController.removeCartItem(1).getStatusCodeValue());
		
}

}
