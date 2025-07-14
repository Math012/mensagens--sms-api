package com.math012.apimensagenssms.business.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.math012.apimensagenssms.infra.enums.Status;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsMessageInDTO {
    private String phoneNumber;
    private Status status;
    @JsonIgnore
    private LocalDateTime sentAt;
}
