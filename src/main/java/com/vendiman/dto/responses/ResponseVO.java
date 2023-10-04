package com.vendiman.dto.responses;

import java.io.Serializable;

import java.time.Instant;
import java.util.List;

import com.vendiman.sales.db.models.Order;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class ResponseVO<M> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;
		
	private String errorMessage;
		
	private long timestamp = Instant.now().toEpochMilli();
	
	private ResponseStatus status = ResponseStatus.EMPTY;
	
	private M model;
		
    public ResponseVO() {}
	
    public ResponseVO(M model) {
        this.model = model;
    }
    
	
}
