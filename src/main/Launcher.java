package main;

import exceptions.ParsingException;
import structure.Champion;

public class Launcher
{
	
	
	
	public static void main(String[] args) throws ParsingException
	{
		for(Champion champ : InitializeStructure.createChampionsArrayList())
		
		System.out.println(champ);
	}

}
