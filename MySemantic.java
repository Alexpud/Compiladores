import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;
import java.util.StringTokenizer;

import analysis.DepthFirstAdapter;
import node.AArrayDeclaracaoVariavel;
import node.ACriacaoAtribuicaoDeclaracaoVariavel;
import node.ADecExpressao;
import node.ADeclaracao;
import node.ADeclaracaoVariavel;
import node.AListaAtribuicaoVariavel;
import node.APrograma;
import node.AUnicoListaVariavel;
import node.AVariosListaVariavel;

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
        System.out.println("Elementos na tabela de simbolos: " + symbol_table.toString());
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
        
        //Estruturas de dados para tratar as declaracoes de variaveis da forma: int a,b,c = 7;
        StringTokenizer st;
        ArrayList<String> variables = new ArrayList<>();
        
        
        String tipo = node.getTipo().toString().trim();
        String id = node.getListaVariavel().toString().trim();
        String value = node.getValores().toString().trim();
        
        //verifica se existe mais de um identificador
        if(id.length() > 2)
        {
            st = new StringTokenizer(id);
            while(st.hasMoreElements())
            {
                variables.add(st.nextToken(" ")); // divide os identificadores
            }
        }
        
        //verificacao de tipo
        Symbol b = new Symbol(tipo, value);
        
        //Verifica se aceita 
        if(b.isAceita())
        {
            if(variables.size() < 1) // caso a declaracao for no estilo: int a = 7;
            {
                if(!symbol_table.containsKey(id)) //variavel com o mesmo nome
                    symbol_table.put(id, value);
                else
                    System.err.println("ERRO -> A Variavel: (" + id + ") ja foi definida");
            }
            else // caso for a declaracao composta
            {
                for (int i = 0; i < variables.size(); i++) {
                    if(!symbol_table.containsKey(variables.get(i))) //variavel com o mesmo nome
                        symbol_table.put(variables.get(i), value);
                    else
                        System.err.println("ERRO -> A Variavel: (" + variables.get(i) + ") ja foi definida");
                }
                variables.clear();
            }
        }
    }
    
    //pega o array
    @Override 
    public void outAArrayDeclaracaoVariavel(AArrayDeclaracaoVariavel node) {
        // TODO Auto-generated method stub
        String tipo = node.getTipo().toString();
        //System.out.println(tipo);
    }

    @Override
    public void outAVariosListaVariavel(AVariosListaVariavel node) {
        // TODO Auto-generated method stub
        String tipo = node.getListaVariavel().toString();
        //System.out.println(tipo);
    }
}
