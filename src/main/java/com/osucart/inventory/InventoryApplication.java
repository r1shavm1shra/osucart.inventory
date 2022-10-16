package com.osucart.inventory;

		import com.vladmihalcea.hibernate.type.json.JsonType;
		import org.hibernate.annotations.TypeDef;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class InventoryApplication {


	public static void main(String[] args) {

		SpringApplication.run(InventoryApplication.class, args);
	}

}

