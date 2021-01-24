package com.amit.util;

import java.util.ArrayList;
import java.util.List;

import com.amit.model.CommentResource;
import com.amit.model.MessageResource;

public class Util {
	
	private static List<MessageResource> messagesList;
	
	private Util()
	{
		// private constructor
	}
	
	static
	{
		messagesList= new ArrayList<>();
		List<CommentResource> commentList= new ArrayList<>();
		CommentResource comment1= new CommentResource(1, "author 1", "First comment posted by author1", "2021-01-10", 1);
		CommentResource comment2= new CommentResource(2, "author 2", "Second comment posted by author2", "2021-01-11", 1);
		commentList.add(comment1);
		commentList.add(comment2);
		MessageResource message1= new MessageResource(1, "author 1", "First message posted by author 1", "2021-01-01", commentList);
		messagesList.add(message1);
		CommentResource comment3= new CommentResource(3, "author 3", "First comment posted by author3", "2021-01-15", 2);
		CommentResource comment4= new CommentResource(4, "author 4", "Second comment posted by author4", "2021-01-16", 2);
		// Reset comment list to add comments for new message
		commentList= new ArrayList<>();
		commentList.add(comment3);
		commentList.add(comment4);
		MessageResource message2= new MessageResource(2, "author 2", "Second message posted by author 2", "2021-01-05", commentList);
		messagesList.add(message2);
	}
	
	public static List<MessageResource> getMessagesList()
	{
		return messagesList;
	}
	
	public static void addMessage(MessageResource messageResource)
	{
		messagesList.add(messageResource);
	}
}
