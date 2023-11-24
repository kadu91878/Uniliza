package com.uniliza.main.dto;

import java.sql.Date;

public interface ReservasDTO {
    Long getId();
    Date getReservationDate();
    Date getDueDate();
    Long getCarId();
    
}