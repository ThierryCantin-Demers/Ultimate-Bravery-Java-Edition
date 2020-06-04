package structure;

public class Machete extends Item
{
	/**
	 * The base path of all the machete's images' path
	 */
	private static final String PATH = "images\\items\\machete\\";

	/**
	 * Creates a new machete item
	 * 
	 * @param name : name of the machete
	 */
	public Machete(String name)
	{
		super(name);
		super.setPath(PATH);
	}
}
