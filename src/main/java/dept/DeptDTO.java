package dept;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @ToString @NoArgsConstructor @AllArgsConstructor
@Builder
public class DeptDTO {
	int department_id;
	String department_name;
	int manager_id;
	int location_id;
}
