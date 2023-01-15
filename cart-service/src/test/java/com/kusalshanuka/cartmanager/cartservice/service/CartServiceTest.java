package com.kusalshanuka.cartmanager.cartservice.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.kusalshanuka.cartmanager.cartservice.model.Cart;
import com.kusalshanuka.cartmanager.cartservice.repository.CartRepository;
import com.kusalshanuka.cartmanager.cartservice.service.impl.CartServiceImpl;

@ContextConfiguration(classes = CartServiceImpl.class)
@RunWith(SpringRunner.class)
public class CartServiceTest {

	@Autowired
	CartService cartService;

	@MockBean
	CartRepository cartRepository;

	@Test
	public void getAllCartItemsTest() {

		// Model Test

		Cart cart = new Cart();

		cart.setId(1);
		cart.setItemName("Item01");
		cart.setPrice(100.0);
		cart.setQty(2.0);

		cart.getId();
		cart.getItemName();
		cart.getPrice();
		cart.getQty();

		//

		when(cartRepository.findAll()).thenReturn(Stream.of(cart).collect(Collectors.toList()));

		List<Cart> allCartItems = cartService.getAllCartItems();

		assertEquals(1, allCartItems.size());

	}

	@Test
	public void addCartItemTest() {

		Cart cart = new Cart(1, "Item1", 20.0, 5.0);

		when(cartRepository.save(cart)).thenReturn(cart);
		assertEquals(1, cartService.addCartItem(cart).getId());

	}

	@Test(expected = Exception.class)
	public void addCartItemTestException() {

		Cart cart = new Cart(1, "Item1", 20.0, 5.0);

		when(cartRepository.save(cart)).thenThrow(new IllegalArgumentException());
		assertEquals(new IllegalArgumentException(), cartService.addCartItem(cart));

	}

	@Test
	public void removeCartItemTestTrue() {

			when(cartRepository.findById(2)).thenReturn(Optional.of(new Cart(1,"Item1",20.0,5.0)));
			assertEquals(true,cartService.removeCartItem(2));
			
	}

	@Test
	public void removeCartItemTestFalse() {

			when(cartRepository.findById(2)).thenReturn(Optional.empty());
			assertEquals(false,cartService.removeCartItem(2));
			
	}

}
