package structure;

public enum RangeType
{
	RANGED("Ranged"), MELEE("Melee"), MIXED("Mixed");

	/**
	 * The name of the range type
	 */
	private String name;

	private RangeType(String name)
	{
		this.name = name;
	}

	/**
	 * Returns the name of the type of range
	 * 
	 * @return the name of the range type
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Returns the name of the range type
	 * 
	 * @return the name of the range type
	 */
	@Override
	public String toString()
	{
		return this.name;
	}
}
