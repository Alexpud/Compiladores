
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
        }else if(tipo.trim().equals("float"))
        {
            try
            {
                float temp = Float.parseFloat(valor.trim());
                return true;
            }catch(Exception e)
            {
                return false;
            }
        }else if(tipo.trim().equals("char"))
        {
            //verificacao do char
            if(valor.trim().contains("\'")){
                if(valor.trim().length() < 2)
                {
                    return true;
                }
                return true;
            }
            else
            {
                return false;
            }
        }else
        {
            return true;
        }
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
