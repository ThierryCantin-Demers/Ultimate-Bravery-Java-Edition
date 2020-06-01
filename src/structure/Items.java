package structure;

/**
 * Enum containing all the full items
 * 
 * @author fofi15cd
 *
 */
public enum Items
{
	ABYSSAL_MASK("Abyssal Mask"),
	ADAPTIVE_HELM("Adaptive Helm"),
	ARCHANGEL_S_STAFF("Archangel's Staff"),
	ARDENT_CENSER("Ardent Censer"),
	ATHENE_S_UNHOLY_GRAIL("Athene's Unholy Grail"),
	BANSHEE_S_VEIL("Banshee's Veil"),
	BLACK_CLEAVER("Black Cleaver"),
	BLADE_OF_THE_RUINED_KING("Blade of the Ruined King"),
	BLOODTHIRSTER("Bloodthirster"),
	DEAD_MAN_S_PLATE("Dead Man's Plate"),
	DEATH_S_DANCE("Death's Dance"),
	DUSKBLADE_OF_DRAKTHARR("Duskblade of Draktharr"),
	EDGE_OF_NIGHT("Edge of Night"),
	ESSENCE_REAVER("Essence Reaver"),
	FROZEN_HEART("Frozen Heart"),
	FROZEN_MALLET("Frozen Mallet"),
	GARGOYLE_STONEPLATE("Gargoyle Stoneplate"),
	GUARDIAN_ANGEL("Guardian Angel"),
	GUINSOO_S_RAGEBLADE("Guinsoo's Rageblade"),
	HEXTECH_GLP_800("Hextech GLP-800"),
	HEXTECH_GUNBLADE("Hextech Gunblade"),
	HEXTECH_PROTOBELT("Hextech Protobelt"),
	ICEBORN_GAUNTLET("Iceborn Gauntlet"),
	INFINITY_EDGE("Infinity Edge"),
	KNIGHT_S_VOW("Knight's Vow"),
	LIANDRY_S_TORMENT("Liandry's Torment"),
	LICH_BANE("Lich Bane"),
	LOCKET_OF_THE_IRON_SOLARI("Locket of the Iron Solari"),
	LORD_DOMINIK_S_REGARDS("Lord Dominik's Regards"),
	LUDEN_S_ECHO("Luden's Echo"),
	MANAMUNE("Manamune"),
	MAW_OF_MALMORTIUS("Maw of Malmortius"),
	MERCURIAL_SCIMITAR("Mercurial Scimitar"),
	MIKAEL_S_CRUCIBLE("Mikael's Crucible"),
	MORTAL_REMINDER("Mortal Reminder"),
	NASHOR_S_TOOTH("Nashor's Tooth"),
	PHANTOM_DANCER("Phantom Dancer"),
	RABADON_S_DEATHCAP("Rabadon's Deathcap"),
	RANDUIN_S_OMEN("Randuin's Omen"),
	RAPID_FIRECANNON("Rapid Firecannon"),
	RAVENOUS_HYDRA("Ravenous Hydra"),
	REDEMPTION("Redemption"),
	RIGHTEOUS_GLORY("Righteous Glory"),
	ROD_OF_AGES("Rod of Ages"),
	RUNAAN_S_HURRICANE("Runaan's Hurricane"),
	RYLAI_S_CRYSTAL_SCEPTER("Rylai's Crystal Scepter"),
	SANGUINE_BLADE("Sanguine Blade"),
	SPELLBINDER("Spellbinder"),
	SPIRIT_VISAGE("Spirit Visage"),
	STATIKK_SHIV("Statikk Shiv"),
	STERAK_S_GAGE("Sterak's Gage"),
	STORMRAZER("Stormrazer"),
	SUNFIRE_CAPE("Sunfire Cape"),
	THORNMAIL("Thormail"),
	TITANIC_HYDRA("Titanic Hydra"),
	TWIN_SHADOWS("Twin Shadows"),
	VOID_STAFF("Void Staff"),
	WARMOG_S_ARMOR("Warmog's Armor"),
	WIT_S_END("Wit's End"),
	YOUMUU_S_GHOSTBLADE("Youmuu's Ghostblade"),
	ZEKE_S_CONVERGENCE("Zeke's Convergence"),
	ZHONYA_S_HOURGLASS("Zhonya's Hourglass");

	/**
	 * Path of the items' images
	 */
	private static String PATH = "images\\items\\";

	/**
	 * Name of the item
	 */
	private String name;

	/**
	 * Name of the image of the item
	 */
	private String imgName;

	/**
	 * Path of the image of the item
	 */
	private String imgPath;

	/**
	 * Creates a new item
	 * 
	 * @param name : name of the item
	 * @param rangeType : range type of the item
	 */
	private Items(String name)
	{
		this.name = name;
		this.imgName = name = ".png";
		setPath();
	}

	/**
	 * Sets the path of the item's image
	 */
	private void setPath()
	{
		this.imgPath = PATH + imgName;
	}

	/**
	 * Returns the path of the item's image
	 * 
	 * @return the path of the item's image
	 */
	public String getImgPath()
	{
		return this.imgPath;
	}

	/**
	 * Returns the name of the item
	 * 
	 * @return the name of the item
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Returns the name of the item
	 * 
	 * @return the name of the item
	 */
	@Override
	public String toString()
	{
		return getName();
	}
}
