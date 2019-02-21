package collection;

import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class CollectionBeanClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean coll = (CollectionBean)ctx.getBean("collection");
		
		System.out.println(coll.getAddressList());
		
		Properties addressList = coll.getAddressList();
		
		for(String key : addressList.stringPropertyNames()) {
			System.out.println(
					String.format("키: %s , 값 : %s",key,addressList.get(key))
					);
		}
		
		ctx.close();
	}
}
