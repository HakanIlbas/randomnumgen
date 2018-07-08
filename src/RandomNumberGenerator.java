import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RandomNumberGenerator {

    public static void main(String[] args){
        launcher();
    }

    public static void JavaFXLauncher(String firstbound, String secondbound){
        int random;
        try {
            if(inputvalidator(firstbound, secondbound)) {
                random = Integer.parseInt(firstbound) + (int) (Math.random() * ((Integer.parseInt(secondbound) - Integer.parseInt(firstbound)) + 1));
                Main.setOutput(Integer.toString(random));

            }

        } catch(NumberFormatException e) {
            Main.setLowerbound("Pick smaller number");
            Main.setUpperbound("Integer overflow");
        }
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

            try {
                if(inputvalidator(firstbound, secondbound)) {
                    random = Integer.parseInt(firstbound) + (int) (Math.random() * ((Integer.parseInt(secondbound) - Integer.parseInt(firstbound)) + 1));
                }else{
                    continue;
                }

            } catch(NumberFormatException e ){
                System.out.println("Integer overflow, pick a smaller number");
                continue;
            }
            System.out.println("The randomly generated number is: " + random);
        }
    }

    public static boolean inputvalidator(String lower, String upper){
        for(char c: lower.toCharArray()){
            if(!Character.isDigit(c)&&c!='-'){
                System.out.println("Lowerbound contains characters which are not digits");
                System.out.println("Re-enter input");
                Main.setLowerbound("Input contains non-Digits");
                return false;
            }
        }

        for(char c: upper.toCharArray()){
            if(!Character.isDigit(c)&&c!='-'){
                System.out.println("Upperbound contains characters which are not digits");
                System.out.println("Re-enter input");
                Main.setUpperbound("Input contains non-Digits");
                return false;
            }
        }

        if(Integer.parseInt(lower)>Integer.parseInt(upper)){
            System.out.println("Lowerbound is larger than upperbound");
            System.out.println("Re-enter input with lower lowerbound");
            Main.setLowerbound("Lowerbound is higher");
            Main.setUpperbound("than Upperbound");
            return false;
        }
        return true;
    }
}
