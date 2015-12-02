import analysis.DepthFirstAdapter;
import node.APrograma;

public class MySemantic extends DepthFirstAdapter{
    
    @Override
    public void inAPrograma(APrograma node) {
        // TODO Auto-generated method stub
        System.out.println("Begin Execute");
    }

    @Override
    public void outAPrograma(APrograma node) {
        // TODO Auto-generated method stub
        System.out.println("End Execute");
    }
    
    
    

}
