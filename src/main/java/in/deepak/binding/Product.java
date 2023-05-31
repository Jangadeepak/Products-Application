package in.deepak.binding;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Product {


	@Id
	private Integer pid;
	
	@NotBlank(message="Name is mandatory")
	@Size(min=3, max=10 ,message="Name should have 3 to 15 characters")
	private String pname;
	
	@NotNull(message="price is mandatory")
	private Double price;
	
	@NotNull(message="Quantity is mandatory")
	private Integer qty;
}
