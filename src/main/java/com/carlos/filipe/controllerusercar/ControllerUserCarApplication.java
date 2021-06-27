package com.carlos.filipe.controllerusercar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class ControllerUserCarApplication {

	public static void main(String[] args) {
		var positivo = new ArrayList<Double>();
		Scanner leitor = new Scanner(System.in);

		SpringApplication.run(ControllerUserCarApplication.class, args);
	}

}
