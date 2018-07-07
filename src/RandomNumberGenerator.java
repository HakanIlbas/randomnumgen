import java.util.Scanner;

public class RandomNumberGenerator {

    public static void main(String[] args){
        launcher();
    }

    public static void launcher(){
        boolean running = true;
        int random = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the random number generator\n");

        while(running){
            System.out.println("If you want to stop, type stop in the console, else press enter");
            String stop = sc.nextLine();

            if(stop.equals("stop")){
                System.out.println("Random number generator stopped");
                running = false;
                continue;
            }

            System.out.println("To generate a number enter a lower and upper bound.");
            System.out.println("Enter lower bound");

            String firstbound = sc.nextLine();
            if(firstbound.equals("")){
                System.out.println("No input given, re-enter input");
                continue;
            }


            System.out.println("Enter upper bound");
            String secondbound = sc.nextLine();
            if(secondbound.equals("")){
                System.out.println("No input given, re-enter input");
                continue;
            }

            if(inputvalidator(firstbound, secondbound)) {
                random = Integer.parseInt(firstbound) + (int) (Math.random() * ((Integer.parseInt(secondbound) - Integer.parseInt(firstbound)) + 1));
            }else{
                continue;
            }

            System.out.println("The randomly generated number is: " + random);

        }
    }

    public static boolean inputvalidator(String lower, String upper){
        for(char c: lower.toCharArray()){
            if(!Character.isDigit(c)){
                System.out.println("Lowerbound contains characters which are not digits");
                System.out.println("Re-enter input");
                return false;
            }
        }

        for(char c: upper.toCharArray()){
            if(!Character.isDigit(c)){
                System.out.println("Upperbound contains characters which are not digits");
                System.out.println("Re-enter input");
                return false;
            }
        }

        if(Integer.parseInt(lower)>Integer.parseInt(upper)){
            System.out.println("Lowerbound is larger than upperbound");
            System.out.println("Re-enter input with lower lowerbound");
            return false;
        }
        return true;
    }
}
