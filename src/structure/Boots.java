package structure;

public class Boots extends Item
{
	/**
	 * The base path of all the boots' images' path
	 */
	private static final String PATH = "images\\items\\boots\\";

	
	/**
	 * Creates a new boot item
	 * 
	 * @param name : name of the boots
	 */
	public Boots(String name)
	{
		super(name);
		super.setPath(PATH);
	}

}
