package com.bmpl.testengine.user.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

import com.bmpl.testengine.common.dto.PropertyReader;
import com.bmpl.testengine.user.dto.UserDTO;

//User Data Access Object
//All the file handling code is done here, read and write is done here
//Read or write code is done here
//UserDAO is created so that it helps us in file accessing read and write and all the stuff
public class UserDAO {
	public boolean checkUserExist(UserDTO userDTO) throws ClassNotFoundException, IOException{
		//Logging is been done here 
		Logger logger = Logger.getLogger(UserDAO.class);
		//This will debug and prints the message upon the log file 
		logger.debug("Inside UserDAO and CheckUserExist "+userDTO );
		
		//Here all the logics of checking is done
		//Logic to check weather or not user id and password exists in file or not
		//This FileInputStream is used here to check inton the file
		FileInputStream fs = new FileInputStream(PropertyReader.getUserFilePath());
		ObjectInputStream os = new ObjectInputStream(fs);
		try{
		//This is been type casted into UserDTO
		UserDTO  userObject = (UserDTO) os.readObject();
		//This will check the userObject and userDTO condition
		if(userObject.getUserid().equals(userDTO.getUserid()) && userObject.getPassword().equals(userDTO.getPassword())){
			//Each time this runs will prints the Success on log file
			logger.debug("Success");
			//It returns true 
			return true;
		}
		else
		{
			logger.debug("Fail");
			return false;
		}
		}
		finally{
			if(os!=null){
				os.close();
			}
			if(fs!=null){
				fs.close();
			}
		}
	}
	
	public boolean registerUser(UserDTO userDTO) throws IOException{
		//This PropertyReader will send us to the getUserFilePath method and through this we would get the user file path
		FileOutputStream fs = new FileOutputStream(PropertyReader.getUserFilePath());
		//ObjectOutputStream is used with serialization
		ObjectOutputStream os = new ObjectOutputStream(fs);
		try{
			os.writeObject(userDTO);
			return true;
		}
		//This Block always execute
		finally
		{
			if(os!=null){
				os.close();
			}
			if(fs!=null){
				fs.close();
			}
		}
	}

}
