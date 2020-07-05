package com.crm.util;

// Make sure Less secure app access is ON in google account, secuirty setting
//https://myaccount.google.com/lesssecureapps 

//below is the reference website
//http://commons.apache.org/proper/commons-email/userguide.html


import org.apache.commons.mail.*;

public class EmailAttachs {
	
	//private static String sFilename = null;
	
    @SuppressWarnings("deprecation")
    public static void sendAttachEmail(String vFilename){
    	
//	public static void main(String[] args)
//    {
    	
    	//sFilename=vFilename;
       //Create Attachment
        EmailAttachment emailAttachment=new EmailAttachment();
        
        emailAttachment.setPath(vFilename);
        
//		To get the file which downloads to C drive
//        String filePath = System.getProperty("user.home")+"/Downloads/orders.csv";
//        emailAttachment.setPath(filePath);
        //emailAttachment.setPath("E:\\Pics\\My Phone\\Pics\\mypic.jpg");

//        emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
//        emailAttachment.setDescription("Picture Attachment");
//        emailAttachment.setName("Picture");
  
       
       //Initialize a new multi part email instance
        MultiPartEmail email=new MultiPartEmail();
        //Set email host
        email.setHostName("smtp.googlemail.com");
        //Set email authentication username and password
        email.setAuthenticator(new DefaultAuthenticator("abhi.abhib5@gmail.com","Abhin@vb5"));
        //Set email host SSL to true
        email.setSSL(true);
        try {
            //Set From email address
            email.setFrom("abhi.abhib5@gmail.com");
        } catch (EmailException e) {
            e.printStackTrace();
        }
        //Set email Subject line
        email.setSubject("Selenium Test Email");
        try {
            //Set Email Message
            email.setMsg("This is a Selenium test from Java Email");
        } catch (EmailException e) {
            e.printStackTrace();
        }
        try {
            //Set Email To Address
        	
            email.addTo("abhi.abhib5@gmail.com");
            
            //email.addTo("abhilan1792@gmail.com");
        } catch (EmailException e) {
            e.printStackTrace();
        }
        //add the attachment
        try {
            email.attach(emailAttachment);
        } catch (EmailException e) {
            e.printStackTrace();
        }
        try {
            //Send Email
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
        
       finally {
		System.out.println("Email has been sent successfully");
	}
    }
}