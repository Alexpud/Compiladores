
import parser.*;
import lexer.*;
import node.* ;

import java.io.* ;

 
public class Main {
   public static void main(String[] args) {
      long start_time, stop_time;
      if (args.length > 0) {
         try {
            start_time = System.currentTimeMillis();
            /* Form our AST */
            Lexer lexer = new Lexer (new PushbackReader(
               new FileReader(args[0]), 1024));
            /*while(!lexer.peek().getText().equals(""))
            {
            	 System.out.println(lexer.peek().getClass());
                 lexer.next();
            }*/
            Parser parser = new Parser(lexer);
            Start ast = parser.parse() ;
            // Get our Interpreter going. 
           // Interpreter interp = new Interpreter () ;
         //   ast.apply(interp) ;
         System.out.println("----------------------------------------------------------------");
         ast.apply(new MySemantic());
         stop_time = System.currentTimeMillis();
         System.out.println("Tempo de execução :"+( stop_time - start_time)+"ms\n");
         }
         catch (Exception e) {
            System.out.println (e) ;
         }
      } else {
         System.err.println("usage: java simpleAdder inputFile");
         System.exit(1);
      }
   }
} 
