import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
    
        String s = "";
        Scanner scanner = new Scanner(System.in);

        while(Komand.komandExid(s)!=1){
            System.out.println("\033[H\033[2J");
            
            Komand.obrabotkaKonsol(s,null);
            s = scanner.nextLine();
        }
        
    }
}