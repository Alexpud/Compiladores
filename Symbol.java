
public class Symbol {
    
    private String tipo = "";
    private String id = "";
    private String valor = "";
    
    public Symbol(String tipo, String id) {
        // TODO Auto-generated constructor stub
        this.setTipo(tipo);
        this.id = id;
    }
    
    public boolean isAcept(String tipo, String valor)
    {
        if(tipo.trim().equals(tipo)){
            try
            {
                @SuppressWarnings("unused")
                int temp = Integer.parseInt(valor.trim());
                return true;
            }catch(Exception e)
            {
                System.err.println("ERRO -> Tipo invalido: o valor ("+ valor.trim() + ") nao eh um (int)");
                return false;
            }
        }else if(tipo.trim().equals(tipo))
        {
            try
            {
                @SuppressWarnings("unused")
                float temp = Float.parseFloat(valor.trim());
                return true;
            }catch(Exception e)
            {
                System.err.println("ERRO -> Tipo invalido: o valor ("+ valor.trim() + ") nao eh um (float)");
                return false;
            }
        }else if(tipo.trim().equals(tipo))
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
                System.err.println("ERRO -> Tipo invalido: o valor ("+ valor.trim() + ") nao eh um (char)");
                return false;
            }
        }else
        {
            //valor = valor.trim().substring(1, valor.length()-2);
            //System.out.println("String: "+ valor );
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
	public String toString()
	{
	    return tipo + " " + id + " " + valor; 
	}
    
}
