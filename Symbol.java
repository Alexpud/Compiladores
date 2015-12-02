
public class Symbol {
    
    private String tipo;
    private String valor;
    
    public Symbol(String tipo, String valor) {
        // TODO Auto-generated constructor stub
        this.setTipo(tipo);
        this.setValor(valor);
    }
    
    public boolean isAceita()
    {
        if(tipo.trim().equals("int")){
            try
            {
                int temp = Integer.parseInt(valor.trim());
                return true;
            }catch(Exception e)
            {
                return false;
            }
        }
        return true;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
}
