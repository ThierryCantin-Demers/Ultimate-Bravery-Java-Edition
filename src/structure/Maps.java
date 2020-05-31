package structure;

public enum Maps
{
	SUMMONERS_RIFT("Summoner's Rift"), HOWLING_ABYSS("Howling Abyss");
	
	
	private String name;
	
	private Maps(String name)
	{
		setName(name);
	}
	
	
	public String getName()
	{
		return this.name;
	}
	
	private void setName(String name)
	{
		this.name = name;
	}
}
