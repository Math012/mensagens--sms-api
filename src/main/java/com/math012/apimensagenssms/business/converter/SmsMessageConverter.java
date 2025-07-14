package com.math012.apimensagenssms.business.converter;

import com.math012.apimensagenssms.business.dto.request.SmsMessageInDTO;
import com.math012.apimensagenssms.business.dto.response.SmsMessageOutDTO;
import com.math012.apimensagenssms.infra.entity.SmsMessageEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class SmsMessageConverter {

    public SmsMessageEntity toEntityFromSmsMessageInDTO(SmsMessageInDTO request){
        return SmsMessageEntity.builder()
                .phoneNumber(request.getPhoneNumber())
                .status(request.getStatus())
                .sentAt(request.getSentAt())
                .build();
    }

    public SmsMessageOutDTO toSmsMessageOutDTOFromSmsMessageEntity(SmsMessageEntity entity){
        return SmsMessageOutDTO.builder()
                .id(entity.getId())
                .phoneNumber(entity.getPhoneNumber())
                .status(entity.getStatus())
                .sentAt(entity.getSentAt())
                .build();
    }

    public List<SmsMessageOutDTO> toListSmsMessageOutDTOFromListSmsMessageEntity(List<SmsMessageEntity> listEntity){
        return listEntity.stream().map(this::toSmsMessageOutDTOFromSmsMessageEntity).toList();
    }


}
