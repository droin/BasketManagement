package com.fufudev.basketmanagement;

import java.io.Serializable;

import android.content.Context;

public class Controleur implements Serializable {

	private static final long serialVersionUID = 3626201251422355577L;

	private static Controleur _instance = null;
	public static synchronized Controleur getInstance(Context context) {
		if (_instance == null) {
			_instance = new Controleur(context);
		}
		return _instance;
	}
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	private Database database;
	
	public Controleur (Context context) {
		database = new Database(context);
	}
	
	
	
}
