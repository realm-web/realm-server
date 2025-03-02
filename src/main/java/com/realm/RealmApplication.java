package com.realm;

import com.realm.folder.*;
import com.realm.document.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RealmApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RealmApplication.class, args);
	}
}
