package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter							//롬복
@Setter							//롬복
@AllArgsConstructor				//롬복
public class LoginRequest {
	
	private String id;
	private String email;
}
