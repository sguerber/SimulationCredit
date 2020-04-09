package com.mycompany.metier;

public class TestMetier {

	public static void main(String[] args)
	{
		CreditMetier metier = new CreditMetier();
		double m=metier.calculeMensualite(12000, 48, 4.5);
		System.out.println(m);
	}
}
