package com.next

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication


@SpringBootApplication
class KotlinServerApplication

fun main(args: Array<String>){
    SpringApplication.run(KotlinServerApplication::class.java, *args)
}