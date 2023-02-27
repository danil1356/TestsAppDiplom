package com.example.testsapp.data.Repository;

import com.example.testsapp.data.Entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
}