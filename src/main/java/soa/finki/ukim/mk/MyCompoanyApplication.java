package soa.finki.ukim.mk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class MyCompoanyApplication extends SpringBootServletInitializer  {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyCompoanyApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(MyCompoanyApplication.class, args);
	}
}
