package engine;

//Java Imports:
import java.util.Scanner;
import java.util.ArrayList;

//Engine Imports:
import engine.PartyMember;
import engine.Enemy;
import engine.Skill;

public class Main
{
    public static void main (String [] args)
    {
        new Main();
    }

    Main()
    {
        //Engine Variables:
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int turnNumber = 1;
        boolean phase = true; //used for determining which phase it is
        boolean victory = false; //used for ending the battle, is it inefficient? probably

        //Skill declarations:
        Skill fire = new Skill("Fire", 1);
        
        ArrayList<Skill> skillList = new ArrayList<Skill>();
        skillList.add(fire);
        
        
        //Player Variables:
        //You can edit these, but don't do something stupid
        String name1 = "Player";
        int stats1 [] = {20, 12, 8, 6, 4, 4, 2}; //see EngineNotes.txt for array references

        //Enemy Variables:
        //Maybe give the enemies a different variable name?
        String name2 = "Enemy";
        int stats2 [] = {9, 2, 6, 0, 2, 4, 1}; //see EngineNotes.txt for array references

        //Party Member declaration:
        PartyMember p1 = new PartyMember(name1, stats1);

        //Enemy declaration:
        Enemy e1 = new Enemy(name2, stats2);

        //Unused for now, will add them when we have multiple party members and enemies:
        //ArrayList<PartyMember> party = new ArrayList<PartyMember>();
        //ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        
        
        //Main Engine Loop:
        while (true)
        {
            if (victory) break; else

            if (phase)
            {
                //Player Phase:
                System.out.println("Turn: "+turnNumber);
                System.out.println("Player Phase");
                System.out.println("["+p1.name+" HP: "+p1.stats[0]+"]\n["+e1.name+" HP: "+e1.stats[0]+"]");
                System.out.println("1) Attack 2) Skills 3) Items 4) Escape\nEnter a Command:");
                int command = sc.nextInt(); //don't know if I should declare it here but w/e

                switch(command)
                {
                    //Attack:
                    case 1:
                        attack(p1.name, p1.stats, e1.name, e1.stats);
                        if(e1.stats[0] == 0) victory = true;
                        phase = false; //Changes to enemy phase
                        break;

                    //Skills:
                    case 2:
                        break;

                    //Items:
                    case 3:
                        break;

                    //Escape:
                    case 4:
                        break;

                    //This shouldn't happen, but if it does here's the code:
                    default:
                        System.out.println("Error: Invalid Command");
                        break;
                }

            } else {
                //Enemy Phase:
                System.out.println("Enemy Phase");
                //brain dead ai intesifies:
                attack(e1.name, e1.stats, p1.name, p1.stats);
                turnNumber++;
                phase = true; //Changes to player phase
            }
        }

        //
    }

    //Standard attack method:
    static void attack(String aName, int aStats[], String bName, int bStats[])
    {
        //Gets the attack and defense stats from a and b
        int atk = aStats[2];
        int def = bStats[5];

        //Damage Calculations:
        int damage = atk -= def; //horribly inefficent but it works
        if (damage < 0) damage = 0; //prevents damage from being 0.
        bStats[0] -= damage; //changes b.hp based on a's damage
        if (bStats[0] < 0) bStats[0] = 0; //prevents b.hp from being 0.

        //This will be a lot cleaner in the GUI version:
        System.out.println("-----------------------"); //used to seperate battle logs
        System.out.println(aName+" attacks "+bName+"!");
        System.out.println(aName+" deals "+damage+" damage to "+bName+".");
        System.out.println(bName+" has "+bStats[0]+" HP left.");
        System.out.println("-----------------------"); //used to seperate battle logs
    }
    
}

