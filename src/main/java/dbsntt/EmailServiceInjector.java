package dbsntt;
import dbsntt.Consumer;
import dbsntt.MyDIApplication;
import dbsntt.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector {
	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new EmailServiceImpl());
	}
}
