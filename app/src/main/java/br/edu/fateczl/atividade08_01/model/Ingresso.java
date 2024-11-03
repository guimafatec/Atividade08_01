package br.edu.fateczl.atividade08_01.model;

public class Ingresso {
    private String identificador;
    private float valor;
    public Ingresso(float valor, String identificador) {
        this.setValor(valor);
        this.setIdentificador(identificador);
    }
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    public float valorFinal(float taxaConveniencia) {
        float valor = this.getValor();
        valor = valor * (1 + (taxaConveniencia/100));
        return valor;
    }
    public String getSaida() {
        StringBuffer saida = new StringBuffer();
        float taxa = 10f;
        saida.append("Identificador: ");
        saida.append(this.getIdentificador());
        saida.append("\n");
        saida.append("Valor Ingresso: ");
        saida.append(this.valorFinal(taxa));
        saida.append("\n");
        return saida.toString();
    }
}
