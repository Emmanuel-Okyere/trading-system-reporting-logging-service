package com.tlc.group.seven.reportingloggingservice.controller.log;

import com.tlc.group.seven.reportingloggingservice.logs.model.SystemLog;
import com.tlc.group.seven.reportingloggingservice.logs.service.SystemLogService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class LogControllerTest {

    @MockBean
    SystemLogService systemLogService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenLogs_whenGetLogs_thenReturnJsonArray() throws Exception {

        SystemLog systemLog1 = new SystemLog("login", "user triggered", "initializing user account creation.", "order-processing", new Date());
        SystemLog systemLog2 = new SystemLog("login", "user triggered", "initializing user account creation.", "order-processing", new Date());
        SystemLog systemLog3 = new SystemLog("login", "user triggered", "initializing user account creation.", "order-processing", new Date());

        List<SystemLog> logs = List.of(
                systemLog1,
                systemLog2,
                systemLog3
        );

        given(systemLogService.getLogData()).willReturn(logs);

        mockMvc.perform(get("/api/v1/admin/reports/logs"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].title").value("login")
                );
    }
}
