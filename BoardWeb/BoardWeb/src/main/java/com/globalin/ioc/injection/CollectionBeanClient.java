package com.globalin.ioc.injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean=(CollectionBean)factory.getBean("collectionBean");
		
//		List<String> addrList= bean.getAddressList();
//		Set<String> addrList= bean.getAddressList();
		
//		for (String string : addrList) {
//			System.out.println(string);
//		}
		
//		Map<String, String> addrList=bean.getAddressList();
//	
//		for (String address : addrList.keySet()) {
//			System.out.println(String.format("키 : %s, 값 : %s", address, addrList.get(address)));
//		}
		
		Properties addrList=bean.getAddressList();
		
//		for (String address : addrList.stringPropertyNames()) {
//		System.out.println(String.format("키 : %s, 값 : %s", address, addrList.get(address)));
//		}
		
		for (Object address : addrList.keySet()) {
			System.out.println((String)address + " : "+addrList.get((String)address));
			}
					
		
	}
}
