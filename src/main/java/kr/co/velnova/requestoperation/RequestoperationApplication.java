package kr.co.velnova.requestoperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* Servlet filter에서 HttpServletRequest 조작 방법 (HttpServletRequestWrapper 사용)
* */
@SpringBootApplication
public class RequestoperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestoperationApplication.class, args);
	}

}
