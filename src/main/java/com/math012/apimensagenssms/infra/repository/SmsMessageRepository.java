package com.math012.apimensagenssms.infra.repository;

import com.math012.apimensagenssms.infra.entity.SmsMessageEntity;
import com.math012.apimensagenssms.infra.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SmsMessageRepository extends JpaRepository<SmsMessageEntity, Long> {
    List<SmsMessageEntity> findBySentAtBetweenAndStatus(LocalDateTime hourInitial, LocalDateTime hourFinal, Status status);
}
