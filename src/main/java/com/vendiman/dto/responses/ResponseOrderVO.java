package com.vendiman.dto.responses;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Data
public class ResponseOrderVO<M> implements Serializable{
	
	  private static final long serialVersionUID = 1L;

	    private String message;
			
		private String errorMessage;
			
		private long timestamp = Instant.now().toEpochMilli();
		
		private M model;
		
	 public ResponseOrderVO(M model) {
		     this.model = model;
		
	 }	
}
