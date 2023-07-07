package com.diegoferreira.br.executable;

import com.diegoferreira.br.executable.kafka.Consumer;
import com.diegoferreira.br.executable.kafka.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

@SpringBootApplication
public class ExecutableApplication {

    public static void main(String[] args) {

        if (args[0].equals("p")) {
            new Producer().main(args);
        } else {
            new Consumer().main(args);
        }
    }


}
