package com.digitalojt.web.authentication;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.digitalojt.web.entity.AdminInfo;
import com.digitalojt.web.repository.AdminInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * ユーザー情報生成
 *
 * @author dotlife
 * 
 */
@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	
	// 管理者情報リポジトリー
	private final AdminInfoRepository repository;

	/**
	 * ユーザー情報生成
	 * 
	 * @param ログインID
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AdminInfo adminInfo = repository.findById(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));
		
		return User.withUsername(adminInfo.getAdminId())
				.password(adminInfo.getPassword())
				.roles("USER")
				.build();
	}

}

