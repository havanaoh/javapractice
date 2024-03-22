package ss0321;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDto {
	private int id;
	private String name;
	private int age;
	private String email;
	private String memo;
		
}
