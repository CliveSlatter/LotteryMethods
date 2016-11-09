import java.util.Scanner;
import java.util.ArrayList;

public class Ticket
{
    public static ArrayList<Integer> Ticket()
    {
        Scanner sc = new Scanner(System.in);
        int ball = 0;
        String ticketNumbers = "";
        String suffix = "";
        boolean duplicate;
        ArrayList<Integer> ticket = new ArrayList<Integer>();
        
        System.out.println("Please enter your lottery numbers");
        ticketNumbers = sc.nextLine();
        ticketNumbers = ticketNumbers.replaceAll("[ ]+"," ");  // replaces any double spaces with single spaces
        duplicate = false;

        /*
         * loops through all the numbers in the entered string by splitting it up into individual numbers using the 
         * space as the split value e.g. 1 2 3 4 5 6 as a string becomes six individual numbers. The string values must be
         * converted to numbers using the parseInt function. It also checks whether a number has been entered before and makes the
         * user enter a unique number before moving on.
         */
        
        for(String n : ticketNumbers.split(" "))
        {
            if(!ticket.contains(Integer.parseInt(n)))
            {
                ticket.add(Integer.parseInt(n));
            }else{
                do
                {
                    System.out.println("You have entered " + n + " at least once before. Enter a new number.");
                    ball = sc.nextInt();
                }while(ticket.contains(ball));
                ticket.add(ball);
            }
        }

        /*
         * The program then checks whether the user has entered too many or too few numbers and then forces the user to remove number(s)
         * if there are too many or add number(s) if there are less than six
         */
        
        if(ticket.size()!=6)
        {
            if(ticket.size()-6==1 || 6-ticket.size() == 1) 
            {
                suffix = "number";
            }else{
                suffix = "numbers";
            }
            do
            {
                if(ticket.size()> 6)
                {
                    System.out.println("You have entered too many numbers, please remove " + (ticket.size()-6) + " " + suffix);
                    ball = sc.nextInt();
                    if(ticket.contains(ball))
                    {
                        ticket.remove(ticket.indexOf(ball));
                    }
                }else if(ticket.size()< 6)
                {
                    System.out.println("You have entered too few numbers, please add " + (6-ticket.size()) + " " + suffix);
                    do
                    {
                        System.out.println("you are an idiot. Please enter a number");
                        ball = sc.nextInt();                        
                    }while(ticket.contains(ball));
                    ticket.add(ball);
                }
            }while(ticket.size()!=6);
        }
        
        return ticket;
    }
}