package Daritn.spring.config;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsConfig {
	
	 public static final String ACCOUNT_SID = "AC2e3f103543a521c05ddbd7f53f95f5bd";
	 public static final String AUTH_TOKEN = "f4dd867b6bc6085939b4c1eea4b4a8c0";
	/* 
	public static final String ACCOUNT_SID = "AC79e3760d39cf3a088a3a38a306a81d70";
	public static final String AUTH_TOKEN = "8f11563898c3f4f923f150d90eae4b25";
	*/
	 
public static void sendSMS(String content) {
	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	Message message = Message.creator(new PhoneNumber("+21622525030"),new PhoneNumber("+13254409693"), content).create();
		    System.out.println(message.getSid());
}
}
