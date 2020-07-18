package ar.com.gnchiesa;

import ar.com.gnchiesa.exceptions.OperationException;
import ar.com.gnchiesa.model.Account;
import ar.com.gnchiesa.repository.AccountRepository;
import ar.com.gnchiesa.service.AccountService;
import ar.com.gnchiesa.spring.ApiApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class ApiApplicationTestCase {

    @MockBean
    AccountRepository accountRepositoryMock;

    @Autowired
    AccountService accountServiceMock;

    @Test
    public void test() throws OperationException {

    }


}
