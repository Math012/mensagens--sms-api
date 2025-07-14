package com.math012.apimensagenssms.business.converter;

import com.math012.apimensagenssms.business.dto.request.SmsMessageInDTO;
import com.math012.apimensagenssms.infra.entity.SmsMessageEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SmsMessageUpdate {

    public SmsMessageEntity updateSmsMessageEntity(SmsMessageInDTO dto, SmsMessageEntity entity){
        return SmsMessageEntity.builder()
                .id(entity.getId())
                .phoneNumber(dto.getPhoneNumber() != null ? dto.getPhoneNumber() : entity.getPhoneNumber())
                .status(dto.getStatus() != null ? dto.getStatus() : entity.getStatus())
                .sentAt(entity.getSentAt())
                .build();
    }
}
