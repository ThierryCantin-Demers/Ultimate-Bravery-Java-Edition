package structure;

public class Map
{
	/**
	 * Name of the map
	 */
	private String name;
	
	
	
	/**
	 * Creates a new map
	 * 
	 * @param name : name of the map
	 */
	public Map(String name)
	{
		this.name = name;
	}
	
	
	/**
	 * Returns the name of the map
	 * 
	 * @return the name of the map
	 */
	public String getName()
	{
		return this.name;
	}
	
	
	@Override
	public String toString()
	{
		return this.getName();
	}
}
