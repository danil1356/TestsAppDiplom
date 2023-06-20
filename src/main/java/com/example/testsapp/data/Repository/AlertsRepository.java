package com.example.testsapp.data.Repository;

import com.example.testsapp.data.Entity.Alerts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertsRepository extends JpaRepository<Alerts, Long> {
}
