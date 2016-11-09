import java.util.ArrayList;

public class CreateDraw
{
    public static ArrayList<Integer> CreateDraw()
    {
        int ball = 0;
        int temp = 0;
        boolean newBall = false;
        
        ArrayList<Integer> draw = new ArrayList<Integer>();
        for(int x = 0; x < 6; x++)  
        {
            do
            {
                ball = (int)Math.ceil((Math.random()*49));
                if(!draw.contains(ball))
                {
                    draw.add(ball);
                    newBall = true;
                }
            }while(newBall == false);
            newBall = false;
            if( x == 5)
            {
                for (int i = 1; i < draw.size(); i++) {
                    for(int j = i ; j > 0 ; j--){
                        if(draw.get(j) < draw.get(j-1)){
                            temp = draw.get(j);
                            draw.set(j,draw.get(j-1));
                            draw.set(j-1,temp);
                        }
                    }
                }                
            }
        }

        // adds the bonus ball after the six main balls making sure that it doesn't match any of the main balls

        do
        {
            ball=(int)Math.ceil(Math.random()*49);
        }while(draw.contains(ball)==true);
        draw.add(ball);
        return draw;
    }
}