package com.tlc.group.seven.reportingloggingservice.portfolio.repository;

import com.tlc.group.seven.reportingloggingservice.portfolio.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
