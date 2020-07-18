package ar.com.gnchiesa;

import ar.com.gnchiesa.model.Account;
import ar.com.gnchiesa.model.AccountMovement;
import ar.com.gnchiesa.model.MovementType;
import ar.com.gnchiesa.spring.ApiApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ApiApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-it.properties")
public class ApiApplicationITCase {


    @Autowired
    private MockMvc mvc;

    @Test
    public void contextLoads() {
        System.out.println("MOCK CONTEXT LOADED");
    }

    @Test
    public void testCreateAccount_shouldReturn200() throws Exception{
        this.mvc.perform(post("/api/v1/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new Account(null, new Double(100)))))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testDebit_valueNotNegative_shouldReturn200() throws Exception{
        Account account = new Account();
        account.setId(1);
        mvc.perform(get("/api/v1/accounts/1/debit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new AccountMovement(account, MovementType.DEBIT, new Double(10)))))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testDebit_valueNegative_shouldReturn400() throws Exception{
        Account account = new Account();
        account.setId(1);
        mvc.perform(get("/api/v1/accounts/1/debit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new AccountMovement(account, MovementType.DEBIT, new Double(10)))))
                .andExpect(jsonPath("$.code").value("ERROR"));
    }


}
