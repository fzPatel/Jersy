package com.learn.jersy.Database;

import java.util.HashMap;
import java.util.Map;

import com.learn.jersy.beans.Message;
import com.learn.jersy.beans.Profile;

public class Database 
{

	private static Map<Long, Message> message=new HashMap<>();
	private static Map<Long, Profile> profile=new HashMap<>();
	public static Map<Long, Message> getMessage() {
		return message;
	}
	public static void setMessage(Map<Long, Message> message) {
		Database.message = message;
	}
	public static Map<Long, Profile> getProfile() {
		return profile;
	}
	public static void setProfile(Map<Long, Profile> profile) {
		Database.profile = profile;
	}
	
	
	
}
