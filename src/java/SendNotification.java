/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Khloud
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import static java.nio.charset.StandardCharsets.US_ASCII;
import java.nio.file.Files;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SendNotification {
    
    public static void notify(String to, String sub,String content, final String user,final String pass)
    { 
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");		
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getInstance(props,new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
  	 	         return new PasswordAuthentication(user,pass); 
            }    
        });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(sub);
            
  
            message.setContent("<!doctype html>\n" +
"<html>\n" +
"<head>\n" +
"<meta charset=\"utf-8\">\n" +
"<meta name=\"viewport\" content=\"width=device-width\">\n" +
"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"<title>EmailTemplate-Hybrid</title>\n" +
"<style type=\"text/css\">\n" +
"	\n" +
"html, body {\n" +
"	margin: 0 !important;\n" +
"	padding: 0 !important;\n" +
"	height: 100% !important;\n" +
"	width: 100% !important;\n" +
"}\n" +
"\n" +
"* {\n" +
"	-ms-text-size-adjust: 100%;\n" +
"	-webkit-text-size-adjust: 100%;\n" +
"	}\n" +
".ExternalClass {\n" +
"	width: 100%;\n" +
"}\n" +
"\n" +
"div[style*=\"margin: 16px 0\"] {\n" +
"	margin: 0 !important;\n" +
"}\n" +
"table, td {\n" +
"	mso-table-lspace: 0pt !important;\n" +
"	mso-table-rspace: 0pt !important;\n" +
"}\n" +
"\n" +
"table {\n" +
"	border-spacing: 0 !important;\n" +
"	border-collapse: collapse !important;\n" +
"	table-layout: fixed !important;\n" +
"	margin: 0 auto !important;\n" +
"}\n" +
"table table table {\n" +
"	table-layout: auto;\n" +
"}\n" +
"\n" +
"img {\n" +
"	-ms-interpolation-mode: bicubic;\n" +
"}\n" +
"\n" +
".yshortcuts a {\n" +
"	border-bottom: none !important;\n" +
"}\n" +
"a[x-apple-data-detectors] {\n" +
"	color: inherit !important;\n" +
"}\n" +
"</style>\n" +
"\n" +
"\n" +
"<style type=\"text/css\">\n" +
"\n" +
"\n" +
"@media screen and (max-width: 480px) {\n" +
"\n" +
".fluid, .fluid-centered {\n" +
"	width: 100% !important;\n" +
"	max-width: 100% !important;\n" +
"	height: auto !important;\n" +
"	margin-left: auto !important;\n" +
"	margin-right: auto !important;\n" +
"}\n" +
"\n" +
".fluid-centered {\n" +
"	margin-left: auto !important;\n" +
"	margin-right: auto !important;\n" +
"}\n" +
"\n" +
".stack-column, .stack-column-center {\n" +
"	display: block !important;\n" +
"	width: 100% !important;\n" +
"	max-width: 100% !important;\n" +
"	direction: ltr !important;\n" +
"}\n" +
".stack-column-center {\n" +
"	text-align: center !important;\n" +
"}\n" +
"\n" +
".center-on-narrow {\n" +
"	text-align: center !important;\n" +
"	display: block !important;\n" +
"	margin-left: auto !important;\n" +
"	margin-right: auto !important;\n" +
"	float: none !important;\n" +
"}\n" +
"table.center-on-narrow {\n" +
"	display: inline-block !important;\n" +
"}\n" +
"}\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"<table>\n" +
"  <tr>\n" +
"    <td><center style=\"width: 100%;\">\n" +
"\n" +
"        <div style=\"display:none;font-size:1px;line-height:1px;max-height:0px;max-width:0px;opacity:0;overflow:hidden;mso-hide:all;font-family: sans-serif;\"> (Optional) This text will appear in the inbox preview, but not the email body. </div>\n" +
" \n" +
"        \n" +
"        <div style=\"max-width: 680px;\"> \n" +
"          <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" width=\"100%\" style=\"max-width: 680px;\">\n" +
"            <tr>\n" +
"              <td style=\"padding: 20px 0; text-align: center\"></td>\n" +
"            </tr>\n" +
"          </table>\n" +
"          \n" +
"          <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" bgcolor=\"#ffffff\" width=\"100%\" style=\"max-width: 680px;\">\n" +
"            <tr>\n" +
"              \n" +
"            </tr>\n" +
"            <tr>\n" +
"              <td><table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" +
"                  <tr>\n" +
"                    <td style=\"padding: 40px; text-align: center; font-family: sans-serif; font-size: 15px; mso-height-rule: exactly; line-height: 20px; color: #555555;\"> welcome to roomsBuckets&nbsp;, We would like to notify you with any updates regarding your reservations. &nbsp; <br>\n" +
"                      <br>\n" +
"\n" +
"                      <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" style=\"margin: auto\">\n" +
"                        <tr>\n" +
"                          <td style=\"border-radius: 2.5px; background: #222222; text-align: center;\" class=\"button-td\"><a  style=\"background: #222222; border: 20px solid #222222; padding: 0 10px;color: #ffffff; font-family: sans-serif; font-size: 19px; line-height: 2.1; text-align: center; text-decoration: none; display: block; border-radius: 3px; font-weight: bold;\" class=\"button-a\"> \n" +
"                             \n" +content +
"                            </a></td>\n" +
"                        </tr>\n" +
"                      </table></td>\n" +
"                  </tr>\n" +
"                </table></td>\n" +
"            </tr>\n" +
"            <tr>\n" +
"              <td >\n" +
"                \n" +
"                <div> \n" +
"                  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" style=\"max-width:500px; margin: auto;\">\n" +
"                    <tr> </tr>\n" +
"                  </table>\n" +
"                </div>\n" +
"                </td>\n" +
"            </tr>\n" +
"           \n" +
"            <tr>\n" +
"              <td bgcolor=\"#ffffff\" align=\"center\" height=\"100%\" valign=\"top\" width=\"100%\">\n" +
"                        \n" +
"                        \n" +
"                \n" +
"                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" style=\"max-width:660px;\">\n" +
"                  <tr>\n" +
"                    <td align=\"center\" valign=\"top\" style=\"font-size:0; padding: 10px 0;\">\n" +
"                      \n" +
"                      <div style=\"display:inline-block; max-width:50%; margin: 0 -2px; min-width:200px; vertical-align:top; width:100%;\" class=\"stack-column\">\n" +
"                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" +
"                          <tr>\n" +
"                            <td style=\"padding: 10px 10px;\"><table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"font-size: 14px;text-align: left;\">\n" +
"                                <tr>\n" +
"                                  </tr>\n" +
"                                <tr>\n" +
"                                  <td style=\"font-family: sans-serif; font-size: 15px; mso-height-rule: exactly; line-height: 20px; color: #555555; padding-top: 10px;\" class=\"stack-column-center\"> HERE TO HELP YOU MEET THE WORLD Stay in the heart of the action and discover a world beyond the tourist brochure. </td>\n" +
"                                </tr>\n" +
"                              </table></td>\n" +
"                          </tr>\n" +
"                        </table>\n" +
"                      </div>\n" +
"                      \n" +
"                    \n" +
"                      \n" +
"                      <div style=\"display:inline-block; max-width:50%; margin: 0 -2px; min-width:200px; vertical-align:top; width:100%;\" class=\"stack-column\">\n" +
"                        <table width=\"100%\">\n" +
"                          <tr>\n" +
"                            <td style=\"padding: 10px 10px;\"><table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\" style=\"font-size: 14px;text-align: left;\">\n" +
"                                <tr>\n" +
"                                  </tr>\n" +
"                                <tr>\n" +
"                                  <td style=\"font-family: sans-serif; font-size: 15px; mso-height-rule: exactly; line-height: 20px; color: #555555; padding-top: 10px;\" class=\"stack-column-center\"> The best hotel deals from around the world.. </td>\n" +
"                                </tr>\n" +
"                              </table></td>\n" +
"                          </tr>\n" +
"                        </table>\n" +
"                      </div>\n" +
"                      \n" +
"                      </td>\n" +
"                  </tr>\n" +
"                </table>\n" +
"                \n" +
"               </td>\n" +
"            </tr>\n" +
"            <tr>\n" +
"              <td dir=\"ltr\" bgcolor=\"#ffffff\" align=\"center\" height=\"100%\" valign=\"top\" width=\"100%\" style=\"padding: 10px 0;\">\n" +
"                \n" +
"                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" width=\"100%\" style=\"max-width:660px;\">\n" +
"                  <tr>\n" +
"                    <td align=\"center\" valign=\"top\" style=\"font-size:0; padding: 10px 0;\"><img src=\"https://drive.google.com/uc?export=view&id=1FtmEnDSbmaoEmAXG99UvvG9xY12dIG1Z\" width=\"750\" height=\"171\" alt=\"\"/>\n" +
"                      \n" +
"                \n" +  
"           \n" +
"                      \n" +
"                      <div style=\"display:inline-block; margin: 0 -2px; max-width:66.66%; min-width:320px; vertical-align:top;\" class=\"stack-column\">\n" +
"                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" +
"                          <tr> </tr>\n" +
"                        </table>\n" +
"                      </div>\n" +
"                      \n" +
"                     </td>\n" +
"                  </tr>\n" +
"                </table>\n" +
"                \n" +
"               </td>\n" +
"            </tr>\n" +
"           \n" +
"            \n" +
"          </table>\n" +
"        \n" +
"          <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" width=\"100%\" style=\"max-width: 680px;\">\n" +
"            <tr>\n" +
"              <td style=\"padding: 40px 10px;width: 100%;font-size: 12px; font-family: sans-serif; mso-height-rule: exactly; line-height:18px; text-align: center; color: #888888;\">\n" +
"                <br>\n" +
"                <br>\n" +
"                roomsBucket<br>\n" +
"                <span class=\"mobile-link--footer\">. If you no longer wish to receive roomsBucket evaluation materials click here. Adjust your mail preferences or unsubscribe from all communications with roomsBucket. &nbsp;</span> <br>\n" +
"                <br>\n" +
"                \n" +
"            </tr>\n" +
"          </table>\n" +
"         \n" +
"        </div>\n" +
"      </center></td>\n" +
"  </tr>\n" +
"</table>\n" +
"</body>\n" +
"</html>\n" +
"","text/html");
            Transport.send(message);
            
            
        }
        catch(Exception e) {
    	     e.printStackTrace();
        }
    }
    
}
