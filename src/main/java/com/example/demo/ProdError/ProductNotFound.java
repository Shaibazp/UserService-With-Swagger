package com.example.demo.ProdError;

public class ProductNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6881464838503230768L;
	
	public ProductNotFound()
	{
		super();
	}
	
	public ProductNotFound(String msg)
	{
		super(msg);
	}
}
