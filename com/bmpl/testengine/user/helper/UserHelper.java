package com.bmpl.testengine.user.helper;

import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.bmpl.testengine.common.dto.CommonConstants;
import com.bmpl.testengine.common.dto.MessageDTO;
import com.bmpl.testengine.user.dao.UserDAO;
import com.bmpl.testengine.user.dto.UserDTO;


//Takes data from the LoginView in the form of UserDTO and takes that and sends to the user DAO
//Message will be made up by the helper
//All the Logic is done here
public class UserHelper implements CommonConstants{
	//Here the helper is used to send the message if user id and password is correct or not
	//Basically is this done here so helper is going to transfer userDTO back to userDAO
	
	//Logging is been done 
	Logger logger = Logger.getLogger(UserHelper.class);
	
	
	public MessageDTO isRegister(UserDTO userDTO) throws IOException{
		UserDAO userDAO = new UserDAO();
		MessageDTO messageDTO = new MessageDTO();
		//This Condition is by default that if both if else fails then prints the fail message
		messageDTO.setStatus(FAIL);
		if(userDAO.registerUser(userDTO)){
			messageDTO.setStatus(SUCCESS);
			messageDTO.setMessage("Register Successfully");
		}
		else{
			messageDTO.setStatus(FAIL);
			messageDTO.setMessage("Problem in Register");
		}
		//Else both fails then fail message
		return messageDTO;
	}
	
	
	//This will check whether or not the user exist
	public MessageDTO isCheckExist(UserDTO userDTO) throws ClassNotFoundException, IOException{
		logger.debug("Inside LoggerHelper isCheckExist "+userDTO);
		
		UserDAO userDAO = new UserDAO();
		
		//MessageDTO object created
		MessageDTO messageDTO = new MessageDTO();
		//This is the default condition that must arrive in it
		messageDTO.setStatus(ERROR);
		//Now i will check if user exists then it send true  
		if(userDAO.checkUserExist(userDTO)){
			//Sets to SUCCESS
			messageDTO.setStatus(SUCCESS);
			//This will retrieve the user id and sets the welcome message
			messageDTO.setMessage("Welcome"+userDTO.getUserid());
		}
		else{
			messageDTO.setStatus(FAIL);
			
			//All the message is being build up here
			//If success then we also have to send the user id of that user..so that which user successfully loins 
			messageDTO.setMessage("Invalid User");
		}
		//This will sets the current date that when the user enters or when logins
		messageDTO.setDate(new Date());
		return messageDTO;
	}

}
