package com.tlc.group.seven.reportingloggingservice.controller.log;

import com.tlc.group.seven.reportingloggingservice.logs.model.LogData;
import com.tlc.group.seven.reportingloggingservice.logs.service.LogDataService;
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
    LogDataService logDataService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenLogs_whenGetLogs_thenReturnJsonArray() throws Exception {

        LogData logData1 = new LogData("login", "user triggered", "initializing user account creation.", "order-processing", new Date());
        LogData logData2 = new LogData("login", "user triggered", "initializing user account creation.", "order-processing", new Date());
        LogData logData3 = new LogData("login", "user triggered", "initializing user account creation.", "order-processing", new Date());

        List<LogData> logs = List.of(
                logData1,
                logData2,
                logData3
        );

        given(logDataService.getLogData()).willReturn(logs);

        mockMvc.perform(get("/api/v1/admin/reports/logs"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].title").value("login")
                );
    }
}
