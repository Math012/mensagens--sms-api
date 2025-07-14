package com.math012.apimensagenssms.controller;

import com.math012.apimensagenssms.business.dto.request.SmsMessageInDTO;
import com.math012.apimensagenssms.business.dto.response.SmsMessageOutDTO;
import com.math012.apimensagenssms.business.service.SmsMessageService;
import com.math012.apimensagenssms.infra.enums.Status;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/message")
public class SmsMessageController {

    private final SmsMessageService service;

    @PostMapping
    public ResponseEntity<SmsMessageOutDTO> createMessage(@RequestBody SmsMessageInDTO smsMessageInDTO){
        return ResponseEntity.ok(service.createMessage(smsMessageInDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<SmsMessageOutDTO> updateStatusMessage(@RequestParam("id")Long id,@RequestBody SmsMessageInDTO smsMessageInDTO){
        return ResponseEntity.ok(service.updateStatusMessage(id, smsMessageInDTO));
    }

    @GetMapping("/{status}")
    public ResponseEntity<List<SmsMessageOutDTO>> reportSpecificStatusWith24Hours(@PathVariable("status")Status status){
        return ResponseEntity.ok(service.reportSpecificStatusWith24Hours(status));
    }
}
