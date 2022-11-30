package com.tlc.group.seven.reportingloggingservice.logs.repository;

import com.tlc.group.seven.reportingloggingservice.logs.model.LogData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDataRepository  extends JpaRepository<LogData, Integer> {}
