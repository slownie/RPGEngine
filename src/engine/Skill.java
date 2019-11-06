package engine;

public class Skill 
{
	String name; //The skill's name
	String aName; //The name of the person using the skill
	String bName; //The name of the person the skill is being used on
	
	int type; //The type of skill, check EngineNotes.txt for skill reference
	int aStats [];
	int bStats [];
	
	Skill(String name, int type)
	{
		this.name = name;
		this.type = type;
	}
	
	public void physSkill(String skillName, String aName, int aStats [], String bName, int bStats[])
	{
		
	}
	
	public void magSkill(String skillName, String aName, int aStats [], String bName, int bStats[])
	{
        //Gets the magic and resistance stats from a and b
        int mag = aStats[3];
        int res = bStats[6];

        //Damage Calculations:
        int damage = mag -= res; //horribly inefficent but it works
        if (damage < 0) damage = 0; //prevents damage from being 0.
        bStats[0] -= damage; //changes b.hp based on a's damage
        if (bStats[0] < 0) bStats[0] = 0; //prevents b.hp from being 0.

        //This will be a lot cleaner in the GUI version:
        System.out.println("-----------------------"); //used to seperate battle logs
        System.out.println(aName+" casts "+skillName+" on "+bName+"!");
        System.out.println(aName+" deals "+damage+" damage to "+bName+".");
        System.out.println(bName+" has "+bStats[0]+" HP left.");
        System.out.println("-----------------------"); //used to seperate battle logs
	}
	
	public void healSkill(String aName, int aStats [], String bName, int bStats[])
	{
		
	}
}
