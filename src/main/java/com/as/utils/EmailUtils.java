package com.as.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.as.model.UserAccount;

@Component
public class EmailUtils {
     
	@Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendUserAccUnlockEmail(UserAccount userAcc) {
		boolean isSent = false;
		try {
		MimeMessage mimeMsg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);
		helper.setTo(userAcc.getEmail());
		helper.setSubject("Unlock your account");
		helper.setText(getUserUnlockEmail(userAcc),true);
		
		javaMailSender.send(mimeMsg);
		
		isSent = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
	}

	private String getUserUnlockEmail(UserAccount acc) throws IOException {
		StringBuffer sb = new StringBuffer("");
		
		FileReader fr = new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		
		while (line!=null) {
			sb.append(line);
			line = br.readLine();
		}
		br.close();
		
		//format mail body
		String mailBody = sb.toString();
		mailBody = mailBody.replace("{FNAME}", acc.getFirstName());
		mailBody = mailBody.replace("{LNAME}", acc.getLastName());
		mailBody = mailBody.replace("{TEMP-PWD}", acc.getTempPwd());
		mailBody = mailBody.replace("{EMAIL}", acc.getEmail());
		
		return mailBody;
	}
	
	
}
