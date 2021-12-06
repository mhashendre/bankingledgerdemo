package com.nimidev.bankingledger.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AuditDTO {
    private LocalDateTime createdDateTime = LocalDateTime.now();
    private LocalDateTime modifiedDateTime  = LocalDateTime.now();
    private boolean status;
    private String createdBy;
}
