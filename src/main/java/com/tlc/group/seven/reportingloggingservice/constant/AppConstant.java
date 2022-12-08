package com.tlc.group.seven.reportingloggingservice.constant;

import org.springframework.stereotype.Component;

@Component
public interface AppConstant {

    String exchangeURL = "https://exchange.matraining.com/1567ae46-8d44-4210-bf91-9d5c61290d0f";
    String exchange2URL = "https://exchange2.matraining.com/1567ae46-8d44-4210-bf91-9d5c61290d0f";

    String successStatus = "00";
    String failureStatus = "01";
    String noContentStatus = "204";
    String getDataSuccessMessage = "Get data successfully.";
    String getNoDataAvailableMessage = "No data available.";
}

