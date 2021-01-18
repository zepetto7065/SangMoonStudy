package me.zepetto.springbootsecurity.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Service
//보통 유저 계층을 관리하는 서비스 layer에 UserDetailsService를 구현
//Service 어노테이션이 UserDetailsService에 적용되면서 Random password가 더이상 생성안된다
//또한 내가 만든 Data로 UserL Login이 가능하다.
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Account createAccount(String username , String password){
        Account account = new Account();
        account.setPassword(passwordEncoder.encode(password));
        account.setUsername(username); //encoding 안하고 바로 저장하는것, encoding 해야한다...
        return accountRepository.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> byUserName = accountRepository.findByUsername(username);
        final Account account = byUserName.orElseThrow(() -> new UsernameNotFoundException(username));
        //spring security에서 제공해주는 구현체 (UserDetails)라는게 있다. 다음과 같이 return 한다.
        return new User(account.getUsername(), account.getPassword(), authorities());
    }

    //권한을 변환하는 과정
    private Collection<? extends GrantedAuthority> authorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

}
