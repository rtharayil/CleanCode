/*Does the below code violating Single responsibility principle, 
please document your review comments. In case if it violates 
Can you redesign it for the good? */

interface IEmail {
	public void setSender(String sender);

	public void setReceiver(String receiver);
	
	public void setContent(XMLObject  content);


	public void sendEmail ();
}

class Email implements IEmail {
	public void setSender(String sender) {
		// set sender;
	}

	public void setReceiver(String receiver) {
		// set receiver; 

	}
	public void setContent(XMLObject  content) {
		// parse  and format; 

	}
	public void sendEmail (); {
		// send the email
	}
}
