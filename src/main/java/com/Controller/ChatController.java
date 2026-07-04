package com.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Service.GroqService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {
	
	 @Autowired
	    private GroqService groqService;

	    @GetMapping("/test")
	    public String test() {
	        return groqService.test();
	    }
	    
	    @PostMapping("/chat")
	    public String chat(@RequestBody Map<String, String> request) {

	        String message = request.get("message");

	        return groqService.getResponse(message);
}
}
