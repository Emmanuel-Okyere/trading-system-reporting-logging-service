package com.tlc.group.seven.reportingloggingservice.repository;

import com.tlc.group.seven.reportingloggingservice.model.LogData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDataRepository  extends JpaRepository<LogData, Integer> {}
