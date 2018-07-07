import java.util.Scanner;

public class RandomNumberGenerator {

    public static void main(String[] args){
        launcher();
    }

    public static void launcher(){
        boolean running = true;
        Scanner sc = new Scanner(System.in);


        while(running){
            System.out.println("Welcome to the random number generator\n"
                    + "If you want to stop, type stop in the console, else press enter");

            String stop = sc.nextLine();
            if(stop.equals("stop")){
                System.out.println("Random number generator stopped");
                running = false;
                continue;
            }

            System.out.println("To generate a number enter a lower and upper bound.");
            System.out.println("Enter lower bound");
            int firstbound = sc.nextInt();

            System.out.println("Enter upper bound");
            int secondbound = sc.nextInt();

            int random = firstbound + (int)(Math.random() * ((secondbound - firstbound) + 1));

            System.out.println("The randomly generated number is: " + random);

        }
    }

}
