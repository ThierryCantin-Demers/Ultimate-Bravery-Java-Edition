package structure;

import java.util.List;

public class RunePage
{

	private Keystone keystone;
	private List<MinorRune> mainMinorRunes;
	private List<MinorRune> secondaryMinorRunes;
	private List<StatRune> statRunes;
	
	private RuneType mainRuneType;
	private RuneType secondaryRuneType;
	
	
	public RunePage(RuneType mainRuneType, RuneType secondaryRuneType)
	{
		this.mainRuneType = mainRuneType;
		this.secondaryRuneType = secondaryRuneType;
	
	}
	
	public RuneType getMainRuneType()
	{
		return this.mainRuneType;
	}
	
	public RuneType getSecondaryRuneType()
	{
		return this.secondaryRuneType;
	}
	
	public void setKeystone(Keystone keystone)
	{
		this.keystone = keystone;
	}
	
	public Keystone getKeystone()
	{
		return this.keystone;
	}
	
	public void setMainMinorRunes(List<MinorRune> minorRunes)
	{
		this.mainMinorRunes = minorRunes;
	}
	
	public List<MinorRune> getMainMinorRunes()
	{
		return this.mainMinorRunes;
	}
	
	public void setSecondaryMinorRunes(List<MinorRune> minorRunes)
	{
		this.secondaryMinorRunes = minorRunes;
	}
	
	public List<MinorRune> getSecondaryMinorRunes()
	{
		return this.secondaryMinorRunes;
	}
	
	public void setStatRunes(List<StatRune> statRunes)
	{
		this.statRunes = statRunes;
	}
	
	public List<StatRune> getStatRunes()
	{
		return this.statRunes;
	}
}
