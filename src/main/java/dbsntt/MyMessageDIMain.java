package dbsntt;

public class MyMessageDIMain {
	public static void main(String[] args) {
		String msg = "Hi Sharib!";
		String email = "sharib@email.com";
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		//Send email
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, email);
	}
}
