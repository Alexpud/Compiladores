import java.util.Hashtable;
import java.util.Stack;
import analysis.DepthFirstAdapter;
import node.AArrayDeclaracaoVariavel;
import node.ACriacaoAtribuicaoDeclaracaoVariavel;
import node.ADeclaracao;
import node.ADeclaracaoVariavel;
import node.AListaAtribuicaoVariavel;
import node.APrograma;
import node.AUnicoListaVariavel;

public class MySemantic extends DepthFirstAdapter{
    
    static String TIPO_INTEIRO = "inteiro";
    static String TIPO_REAL = "flutuante";
    static String TIPO_CHARACTER = "caractere";
    
    Hashtable<String, String> symbol_table = new Hashtable<String, String>();
    Stack<String> pilha = new Stack<>();
    
    @Override
    public void inAPrograma(APrograma node) {
        // TODO Auto-generated method stub
        System.out.println("Begin Execute");
    }

    @Override
    public void outAPrograma(APrograma node) {
        // TODO Auto-generated method stub
        System.out.println("End Execute");
        System.out.println(symbol_table.toString());
    }
    
    //pega declaracoes do tipo: int a = 6;
    @Override
    public void outADeclaracao(ADeclaracao node) {
        // TODO Auto-generated method stub
        String tipo = node.getDeclaracaoVariavel().toString();
        //System.out.println(tipo);
    }

    //pega variaveis do tipo: char c; lista de variaveis [d,f,y,y,y,y] 
    @Override
    public void outADeclaracaoVariavel(ADeclaracaoVariavel node) {
        // TODO Auto-generated method stub
        String tipo = node.getListaVariavel().toString();
        //System.out.println(tipo);
    }

    @Override
    public void outACriacaoAtribuicaoDeclaracaoVariavel(
            ACriacaoAtribuicaoDeclaracaoVariavel node) {
        // TODO Auto-generated method stub
        String tipo = node.getTipo().toString();
        String id = node.getIdentificador().toString();
        String value = node.getValores().toString();
        
        System.out.println("Tipo:"+tipo + tipo.length());
        System.out.println("Valor:"+value);
        
        //verificacao de tipo
        Symbol b = new Symbol(tipo, value);
        if(!b.isAceita())
        {
            System.err.println("Tipo invalido");
        }
        else
        {
            if(!symbol_table.containsKey(id)) //variavel com o mesmo nome
                symbol_table.put(id, value);
            else
                System.err.println("Variavel ja definida");
        }
        //System.out.println(tipo+tipo1+tipo2);
    }
    
    //pega o array
    @Override 
    public void outAArrayDeclaracaoVariavel(AArrayDeclaracaoVariavel node) {
        // TODO Auto-generated method stub
        String tipo = node.getTipo().toString();
        //System.out.println(tipo);
    }
    
}
