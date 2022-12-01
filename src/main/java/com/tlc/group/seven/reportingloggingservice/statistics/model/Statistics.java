package com.tlc.group.seven.reportingloggingservice.statistics.model;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {
    private int users;
    private int orders;
    private int buyOrders;
    private int sellOrders;
    private int appLogs;
}
