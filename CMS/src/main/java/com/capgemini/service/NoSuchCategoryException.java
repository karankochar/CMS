package com.capgemini.service;

public class NoSuchCategoryException extends Exception {
	NoSuchCategoryException(String msg){
		super(msg);
	}
}
