package com.math012.apimensagenssms.business.dto.response;

import com.math012.apimensagenssms.infra.enums.Status;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsMessageOutDTO {
    private Long id;
    private String phoneNumber;
    private Status status;
    private LocalDateTime sentAt;
}
