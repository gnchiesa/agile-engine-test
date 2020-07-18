package ar.com.gnchiesa;

import ar.com.gnchiesa.model.Account;
import ar.com.gnchiesa.repository.AccountRepository;
import ar.com.gnchiesa.spring.ApiApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class AccountRepositoryTest {
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Test
    public void whenCreatingAccount_findAccount_balanceShouldMatch() {
        accountRepository.save(new Account(1, 1000d));
        assertThat(accountRepository.findById(1).get().getBalance().doubleValue() == 1000d);
    }
    

}
