package engine;

//Java Imports:
import java.util.Scanner;
import java.util.ArrayList;

//Engine Imports:
import engine.PartyMember;
import engine.Enemy;

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
        boolean phase = true;

        //Player Variables:

        //You can edit these, but don't do something stupid
        String name1 = "Player";
        int stats1 [] = {}; //see EngineNotes.txt for array references

        PartyMember p1 = new PartyMember(name1, stats1);
        ArrayList<PartyMember> party = new ArrayList<PartyMember>();

        //Main Engine Loop:
        while (true)
        {
            int command = sc.nextInt(); //don't know if I should declare it here but w/e

            switch(command)
            {
                //Attack:
                case 1:
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
        }
    }
}
