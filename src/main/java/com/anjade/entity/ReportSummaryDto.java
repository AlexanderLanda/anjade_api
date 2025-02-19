package com.anjade.entity;

import java.util.Date;

public interface ReportSummaryDto {
    Long getId();
    String getAfiliacionId();
    String getNombre();
    String getApellidos();
    String getEmail();
    String getTelefono();
    String getDescripcion();
    Date getCreateDate();
    String getReferenciaReporte();
}
