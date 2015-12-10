import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;
import java.util.StringTokenizer;
import analysis.DepthFirstAdapter;
import node.AAtribuicaoVariavel;
import node.AComSemiDeclaracaoVariavel;
import node.ADeclaracao;
import node.APrograma;


public class MySemantic extends DepthFirstAdapter{
    
    static String TIPO_INTEIRO = "inteiro";
    static String TIPO_REAL = "flutuante";
    static String TIPO_CHARACTER = "caractere";
    
    Hashtable<String, Symbol> symbol_table = new Hashtable<String, Symbol>();
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
        System.out.println("Elementos na tabela de simbolos: " + symbol_table.toString());
    }
    
    
    
    @Override
    public void outAComSemiDeclaracaoVariavel(AComSemiDeclaracaoVariavel node) {
        // TODO Auto-generated method stub
        super.outAComSemiDeclaracaoVariavel(node);
    }

    //Tratar as atribuicoes
	@Override
	public void outAAtribuicaoVariavel(AAtribuicaoVariavel node) {
		// TODO Auto-generated method stub
		String str_id = node.getIdentificador().toString();
		String str_exp = node.getExpressao().toString();
		
		StringTokenizer st = new StringTokenizer(str_exp);
		ArrayList<String> listTokens = new ArrayList<>();
		
		
		Symbol b = symbol_table.get(str_id.trim());
		
		while(st.hasMoreTokens())
		{
		        listTokens.add(st.nextToken().trim());
		}
		for (int i = 0; i < listTokens.size(); i++) {
		    if(listTokens.get(i).matches("[-*+*]*[0-9]+(.*[0-9]+)?"))
		    {
		        
		    }
		    else
		    {
		        Symbol c = symbol_table.get(listTokens.get(i));
                if(c != null)
                {
                    if(!b.getTipo().equals(c.getTipo()))
                    {
                        System.err.println("ERRO -> Tipos Imcompativeis: A variavel:" + 
                    b.getId() + " e do tipo:" + b.getTipo() + " e a variavel:"+ c.getId() + 
                    " e do tipo:" + c.getTipo() );
                    }
                }
                else
                    System.err.println("ERRO -> Variavel nao definida!");
		    }
		}
	}

	//Tratar a declaracao
    @Override
    public void outADeclaracao(ADeclaracao node) {
        // TODO Auto-generated method stub
        String str = "";
        StringTokenizer st;
        ArrayList<String> listTokens = new ArrayList<>();
        ArrayList<Symbol> listSimb = new ArrayList<>();
        
        str = node.getDeclaracaoVariavel().toString();
        st = new StringTokenizer(str);
     
        while(st.hasMoreElements())
        {
            listTokens.add(st.nextToken(" ")); 
        }
        
        for (int i = 1; i < listTokens.size(); i++) {
            listSimb.add(new Symbol(listTokens.get(0), listTokens.get(i)));
        }
        listTokens.clear();
        
        for (int i = 0; i < listSimb.size(); i++) {
            if(!symbol_table.containsKey(listSimb.get(i).getId())) //variavel com o mesmo nome
                symbol_table.put(listSimb.get(i).getId(), listSimb.get(i));
            else
                System.err.println("ERRO -> A Variavel: (" + listSimb.get(i).getId() + ") ja foi definida");
        }
        listSimb.clear();
    }	
}
