package com.demo.controller;

import com.demo.entity.Logsj;
import com.demo.home.LogsjHome;
import com.demo.utils.JsonUtil;
import com.demo.utils.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

import spark.Request;
import spark.Response;

public class LogscuatrojController {
	

	
public static Object insertLogsj(Request req,Response res){
		
		ObjectMapper mapper;
		
		try {
			mapper = new ObjectMapper();
			Logsj input = mapper.readValue(req.body(), Logsj.class);
			LogsjHome dao = new LogsjHome();
			dao.InsertLogs(input);

			return JsonUtil.dataToJson(new Message(200,"OK","Registro almacenado satisfactoriamente"));				

		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return JsonUtil.dataToJson(new Message(400,"ERROR",e.getMessage()));
		}
	}


}
