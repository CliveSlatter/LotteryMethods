import java.util.ArrayList;

public class Results
{
    public int prize = 0;
    public int winners = 0;
    
    public Results(int prize, int winners)
    {
        this.prize=prize;
        this.winners = winners;
    }
    
    public Results getResults()
    {
        Results res = new Results(prize, winners);
        return res;
    }
    
    public static Results checkresult (ArrayList<Integer> draw, ArrayList<Integer> ticket)
    {
        int prize = 0;
        int winners = 0;
        String suffix = "";

        for(Integer n : ticket)
        {
            if(draw.contains(n) && draw.indexOf(n)!=6)
            {
                winners++;
            }
        }

        if(winners==1)
        {
            suffix = "number";
        }else{
            suffix = "numbers";
        }

        switch(winners)
        {
            case 3:
            prize = 10;
            break;
            case 4:
            prize = 100;
            break;
            case 5:
            if(ticket.contains(draw.get(6))) //
            {
                prize = 100000;
                suffix += " plus the bonus ball";
            }else{
                prize = 10000;
            }
            break;
            case 6:
            prize = 1000000;
            break;
        }
        Results res = new Results(prize, winners);
        return res;
    }
    
}