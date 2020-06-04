package structure;

import java.util.List;

public class RuneType
{

	private String name;
	private List<Keystone> keystones;
	private List<List<MinorRune>> minorRunes;
	
	
	
	public RuneType(String name, List<Keystone> keystones, List<List<MinorRune>> minorRunes)
	{
		this.name = name;
		this.keystones = keystones;
		this.minorRunes = minorRunes;
	}
	
	public List<Keystone> getKeystones()
	{
		return this.keystones;
	}
	
	
	public List<List<MinorRune>> getMinorRunes()
	{
		return this.minorRunes;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
	
}
