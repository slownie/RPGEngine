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
	
	public void physSkill(String aName, int aStats [], String bName, int bStats[])
	{
		
	}
	
	public void magSkill(String aName, int aStats [], String bName, int bStats[])
	{
		
	}
	
	public void healSkill(String aName, int aStats [], String bName, int bStats[])
	{
		
	}
}
