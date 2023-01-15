package com.kusalshanuka.cartmanager.cartservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.kusalshanuka.cartmanager.authservice.model.AuthUserDetail;
import com.kusalshanuka.cartmanager.authservice.model.Permission;
import com.kusalshanuka.cartmanager.authservice.model.Role;
import com.kusalshanuka.cartmanager.authservice.model.User;
import com.kusalshanuka.cartmanager.authservice.repository.UserDetailRepository;
import com.kusalshanuka.cartmanager.authservice.service.UserDetailServiceImpl;


@ContextConfiguration(classes = UserDetailServiceImpl.class)
@RunWith(SpringRunner.class)
public class UserDetailServiceTest {

	@Autowired
	UserDetailsService userDetailsService;
	
	@MockBean
	UserDetailRepository userDetailRepository;
	
	@Test
	public void loadUserByUsernameTest() {

		String name = "name";

		//Model cover
		
		
		Permission permission = new Permission();
		permission.setId(1);
		permission.setName("Per_1");
		
		permission.getId();
		permission.getName();
		
		Role role = new Role();
		role.setId(1);
		role.setName("ROLE_admin");
		role.setPermissions(Stream.of(permission).collect(Collectors.toList()));
		
		role.getId();
		role.getName();
		role.getPermissions();
		
		User user = new User();
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEmail(null);
		user.setEnabled(true);
		user.setId(null);
		user.setPassword(null);
		user.setRoles(Stream.of(role).collect(Collectors.toList()));
		user.setUsername(name);
		
		user.getEmail();
		user.getId();
		user.getPassword();
		user.getRoles();
		user.getUsername();
		user.isAccountNonExpired();
		user.isAccountNonLocked();
		user.isCredentialsNonExpired();
		user.isEnabled();

		

		
		AuthUserDetail authUserDetail = new AuthUserDetail(user);
		
		authUserDetail.getAuthorities();
		
		authUserDetail.setAccountNonExpired(true);
		authUserDetail.setAccountNonLocked(true);
		authUserDetail.setCredentialsNonExpired(true);
		authUserDetail.setEmail(null);
		authUserDetail.setEnabled(true);
		authUserDetail.setId(null);
		authUserDetail.setPassword(null);
		authUserDetail.setRoles(Stream.of(role).collect(Collectors.toList()));
		authUserDetail.setUsername(name);
		
		authUserDetail.getEmail();
		authUserDetail.getId();
		authUserDetail.getPassword();
		authUserDetail.getRoles();
		authUserDetail.getUsername();
		authUserDetail.isAccountNonExpired();
		authUserDetail.isAccountNonLocked();
		authUserDetail.isCredentialsNonExpired();
		authUserDetail.isEnabled();
		
		//end
		
		when(userDetailRepository.findByUsername(name)).thenReturn(Optional.of(user));
		assertEquals(userDetailsService.loadUserByUsername(name).getUsername(), name);
		
		
	}
	
}
