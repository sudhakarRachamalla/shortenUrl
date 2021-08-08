package com.shortener.shortenerurl;


import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortenerUrlController {
	private Map<String,String> shorteranList=new HashMap<>();
	
	@RequestMapping(value = "/shortenurl", method=RequestMethod.POST)
	public ResponseEntity<Object> shorternerUrl(@RequestParam(value="originalUrl") String originalUrl) throws MalformedURLException {
		String ramdonchar=gerRandomChar(originalUrl);
		setShorterUrl(ramdonchar,originalUrl);
		return new ResponseEntity<Object>(ramdonchar,HttpStatus.OK);
	}

	private void setShorterUrl(String randonchar, String originalUrl) throws MalformedURLException{
		shorteranList.put(originalUrl, randonchar);	
	}

	private String gerRandomChar(String originalUrl) {
		// TODO Auto-generated method stub
		String random=shorteranList.get(originalUrl);
		String possibleChar="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		if(random == null) {
			String random1="";
		for(int i=0; i<6;i++) {
		 random1+=possibleChar.charAt((int) Math.floor(Math.random() * possibleChar.length()));
		}
		return random1;
		}
		return random;
	}

}
