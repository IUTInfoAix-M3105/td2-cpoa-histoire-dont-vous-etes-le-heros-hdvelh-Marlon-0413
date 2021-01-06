package pracHDVELH;

import java.util.Scanner;

public class EventExactSolution extends Event {
    public int interpretAnswer(){
        System.out.println("Quel choix exact ?");
        Scanner clavier = new Scanner(System.in);
        int i = clavier.nextInt();
        return i;
    }
}
