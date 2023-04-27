package com.uca;

public class Start{
	
	//Start class
	public static void main(String[] args){
		
		RomanNumber roman = new RomanNumber("L");
		System.out.println(roman.toString());
		System.out.println(roman.compareTo(new RomanNumber(30)));

		//TODO

		//Aide pour démarrer : https://git.artheriom.fr/l3-informatique-2020-2021/site-l3/-/tree/master/Genie_Logiciel/HelperTP3
		//Aussi : https://www.youtube.com/watch?v=567_hWQJYak
	}
	
}