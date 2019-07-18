package com.demo.main;

import static spark.Spark.before;
import static spark.Spark.options;
import static spark.Spark.post;

import com.demo.controller.LogscuatrojController;

import spark.servlet.SparkApplication;

public class Application implements SparkApplication {
	 @Override
	 public void init() {
		 
		 options("/*", (request, response) -> {
			 String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
			 if (accessControlRequestHeaders != null) {
			 response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
			 }
			 String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
			 if (accessControlRequestMethod != null) {
			 response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
			 }
			 return "OK";
		 }); 
	
		 before((request,response)->{
			 response.header("Access-Control-Allow-Origin", "*");
			 response.header("Access-Control-Expose-Headers", "user");
		 }); 
		 
		 //Endpoint login
		 post("/private/post/insert","application/json", (req,res) -> {return LogscuatrojController.insertLogsj(req, res);});
	 }

}
