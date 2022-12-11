package com.tlc.group.seven.reportingloggingservice.controller.order;

import com.tlc.group.seven.reportingloggingservice.order.model.Order;
import com.tlc.group.seven.reportingloggingservice.order.service.OrderService;
import com.tlc.group.seven.reportingloggingservice.user.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

    @MockBean
    OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenOrders_whenGetOrders_thenReturnJsonArray() throws Exception {
        Order order1 = new Order();
        User user = new User();
        user.setName("Emmanuel Ametepee");
        user.setID(135L);
        user.setBalance(0.0);
        user.setEmail("emmanuel.metepee@turntabl.io");
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        //order1.setUser(user);
        order1.setOrderId("46fy7gj99kj");
        order1.setType("LIMIT");
        order1.setPrice(1.25);
        order1.setProduct("IBM");
        order1.setQuantity(10);
        order1.setSide("BUY");
        order1.setCreatedAt(new Date());
        order1.setUpdatedAt(new Date());

        List<Order> orders = List.of(
                order1
        );

        doReturn(orders).when(orderService).getOrders();

        mockMvc.perform(get("/api/v1/admin/reports/orders"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].orderId").value("46fy7gj99kj")
                );
    }

}
