package com.learn.jersy.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import com.learn.jersy.Exception.DataNotFoundException;
import com.learn.jersy.beans.Message;

public class MessageDaoImpl 
{
	public List<Message> getMessage()
	{
		List<Message> message =new ArrayList<>();
		
		Message message1=new Message(1, "Hello ","firoz");
		message.add(message1);
		return message;
	}
	public List<Message> getMessage1(long id)
	{
		List<Message> message =null;
	System.out.println(" inside getMessage1");	
		if(message==null) 
		{			System.out.println(" message.get(0)");	

			System.out.println(message+" message.get(0)");

			throw new DataNotFoundException(" Message data Does Not Contain for id= "+id);
		}
		else {
			
				Message message1=new Message(1, "Hello ","firoz");
				message.add(message1);	
				return message;

		}
	}

	
	
	
	public List<Message> getAllMessage()
	{
		List<Message> message =new ArrayList<>();
		
		Message message1=new Message(1, "Hello ","firoz");
		Message message2=new Message(2, "Hello ","Aman");
		message.add(message1);
		message.add(message2);
		return message;
		
		
	}
	public List<Message> addMessage()
	{
		List<Message> message =new ArrayList<>();
		
		Message message1=new Message(1, "Hello ","firoz");
		Message message2=new Message(2, "Hello ","Aman");
		message.add(message1);
		message.add(message2);
		return message;
		
		
	}
	public List<Message> updateMessage()
	{
		List<Message> message =new ArrayList<>();
		
		Message message1=new Message(1, "Hello ","firoz");
		Message message2=new Message(2, "Hello ","Aman");
		message.add(message1);
		message.add(message2);
		return message;
		
		
	}
	public List<Message> removeMessage()
	{
		List<Message> message =new ArrayList<>();
		
		Message message1=new Message(1, "Hello ","firoz");
		Message message2=new Message(2, "Hello ","Aman");
		message.add(message1);
		message.add(message2);
		return message;
		
		
	}
	
}
