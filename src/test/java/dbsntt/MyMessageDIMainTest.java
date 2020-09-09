package dbsntt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Before;
import dbsntt.Consumer;
import dbsntt.MyDIApplication;
import dbsntt.MessageServiceInjector;
import dbsntt.MessageService;

class MyMessageDIMainTest {

	private MessageServiceInjector injector;
	@Before
	public void setUp(){
		//mock the injector with anonymous class
		injector = new MessageServiceInjector() {
			
			@Override
			public Consumer getConsumer() {
				//mock the message service
				return new MyDIApplication(new MessageService() {
					
					@Override
					public void sendMessage(String msg, String rec) {
						System.out.println("Mock Message Service implementation");
						
					}
				});
			}
		};
	}
	
	@Test
	public void test() {
		Consumer consumer = injector.getConsumer();
		consumer.processMessages("Hi Sharib", "sharib@email.com	");
	}
	
	@After
	public void tear(){
		injector = null;
	}
}
