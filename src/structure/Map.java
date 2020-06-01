package structure;

public class Map
{
	/**
	 * Name of the map
	 */
	private String name;
	
	/**
	 * Indicated whether the map is the one that is selected
	 */
	private boolean selected;
	
	
	/**
	 * Creates a new map
	 * 
	 * @param name : name of the map
	 */
	private Map(String name)
	{
		this.name = name;
		
		if(getName().equals("Summoner's Rift"))
			setSelected(true);
		else
			setSelected(false);
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
	
	/**
	 * Modifies if the map is selected or not
	 * 
	 * @param selected : the new value we want to give the map
	 */
	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}
	
	/**
	 * Returns whether or not the map is selected
	 * 
	 * @return whether or not the map is selected
	 */
	public boolean getSelected()
	{
		return this.selected;
	}
}
