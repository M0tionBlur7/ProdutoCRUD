
package Objetos;

import java.math.RoundingMode;
import java.text.DecimalFormat;


public class Produto {
    
    private int id;
    private String descrição;
    private double valor;
    private int quantidade;


    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public String getDescrição() {
        return descrição;
    }

    
    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    
    public double getValor() {
        return valor;
    }

    
    public void setValor(double valor) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setRoundingMode(RoundingMode.DOWN);
        
        this.valor = valor;
    }

    
    public int getQuantidade() {
        return quantidade;
    }

    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
}
