package com.tlc.group.seven.reportingloggingservice.controller.portfolio;

import com.tlc.group.seven.reportingloggingservice.portfolio.model.Portfolio;
import com.tlc.group.seven.reportingloggingservice.portfolio.service.PortfolioService;
import com.tlc.group.seven.reportingloggingservice.user.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PortfolioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PortfolioService portfolioService;

    @Test
    public void givenPortfolioForUser_whenGetPortfolio_thenReturnJsonArray() throws Exception {

        User emmanuel = new User(124L, "Emmanuel Ametepee", "emmanuel.metepee@turntabl.io", 10.0, new Date(), new Date());

        Portfolio portfolio = new Portfolio();
        portfolio.setID(1L);
        portfolio.setTicker("IBM");
        portfolio.setUsers(emmanuel);
        List<Portfolio> portfolioList = List.of(
                portfolio
        );

        given(portfolioService.getUserPortfolio()).willReturn(portfolioList);

        mockMvc.perform(get("/api/v1/admin/reports/portfolio"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].ticker").value("IBM"));
    }
}
