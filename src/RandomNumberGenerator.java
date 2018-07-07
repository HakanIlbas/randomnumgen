import java.util.Scanner;

public class RandomNumberGenerator {

    public static void main(String[] args){
        launcher();
    }

    public static void launcher(){
        boolean running = true;
        Scanner sc = new Scanner(System.in);


        while(running){
            System.out.println("Enter first bound");
            int firstbound = sc.nextInt();

            System.out.println("Enter second bound");
            int secondbound = sc.nextInt();

            int random = firstbound + (int)(Math.random() * ((secondbound - firstbound) + 1));

            System.out.println("Random number: " + random);


        }

    }

}
