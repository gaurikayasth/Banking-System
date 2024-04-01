package com.gauri.models;

public class LowBalanceException extends Exception {
	public LowBalanceException(String msg) {
		super(msg);//here we call constructor of exception class
	}
}
