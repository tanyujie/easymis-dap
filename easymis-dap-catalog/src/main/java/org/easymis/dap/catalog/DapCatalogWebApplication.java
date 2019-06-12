package org.easymis.dap.catalog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "org.easymis.dap.catalog")
@MapperScan("org.easymis.dap.catalog.mapper")
public class DapCatalogWebApplication {

	public static void main(String[] args) {

		SpringApplication.run(DapCatalogWebApplication.class, args);
	}

}
