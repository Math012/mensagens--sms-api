package com.math012.apimensagenssms.business.service;

import com.math012.apimensagenssms.business.converter.SmsMessageConverter;
import com.math012.apimensagenssms.business.converter.SmsMessageUpdate;
import com.math012.apimensagenssms.business.dto.request.SmsMessageInDTO;
import com.math012.apimensagenssms.business.dto.response.SmsMessageOutDTO;
import com.math012.apimensagenssms.infra.entity.SmsMessageEntity;
import com.math012.apimensagenssms.infra.enums.Status;
import com.math012.apimensagenssms.infra.exception.RequestException;
import com.math012.apimensagenssms.infra.exception.ResourceNotFoundException;
import com.math012.apimensagenssms.infra.exception.StatusException;
import com.math012.apimensagenssms.infra.repository.SmsMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class SmsMessageService {

    private final SmsMessageRepository repository;
    private final SmsMessageConverter converter;
    private final SmsMessageUpdate update;


    public SmsMessageOutDTO createMessage(SmsMessageInDTO smsMessageInDTO) {
        if (!verifyFields(smsMessageInDTO)){
            throw new RequestException("Erro ao cadastrar mensagem, campos inválidos");
        }
        smsMessageInDTO.setSentAt(LocalDateTime.now());
        SmsMessageEntity entity = converter.toEntityFromSmsMessageInDTO(smsMessageInDTO);
        return converter.toSmsMessageOutDTOFromSmsMessageEntity(repository.save(entity));
    }

    public SmsMessageOutDTO updateStatusMessage(Long id, SmsMessageInDTO smsMessageInDTO) {
        SmsMessageEntity entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Erro, id: " + id + ", não encontrado, tente novamente!"));
        return converter.toSmsMessageOutDTOFromSmsMessageEntity(repository.save(update.updateSmsMessageEntity(smsMessageInDTO, entity)));
    }

    public List<SmsMessageOutDTO> reportSpecificStatusWith24Hours(Status status) {
        if (Objects.isNull(status)){
            throw new StatusException("Erro ao atualizar status: status inválido");
        }

        LocalDateTime hourInitial = LocalDateTime.now().minusHours(24);
        LocalDateTime hourFinal = hourInitial.plusHours(24);
        return converter.toListSmsMessageOutDTOFromListSmsMessageEntity(repository.findBySentAtBetweenAndStatus(hourInitial, hourFinal, status));
    }

    public boolean verifyFields(SmsMessageInDTO dto) {
        if (dto == null) {
            return false;
        }
        if (dto.getPhoneNumber() == null
                || dto.getPhoneNumber().isBlank()
                || dto.getStatus() == null
                || dto.getStatus().name().isBlank()) {
            return false;
        } else {
            return true;
        }
    }
}