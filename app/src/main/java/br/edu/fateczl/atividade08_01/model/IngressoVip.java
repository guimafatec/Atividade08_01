package br.edu.fateczl.atividade08_01.model;

public class IngressoVip extends Ingresso {
    private String funcao;
    public IngressoVip(float valor, String identificador, String funcao) {
        super(valor, identificador);
        this.setFuncao(funcao);
    }
    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public float valorFinal(float taxaConveniencia) {
        float valorFinal = super.valorFinal(taxaConveniencia);
        valorFinal = valorFinal * 1.18f;
        return valorFinal;
    }

    @Override
    public String getSaida() {
        StringBuffer saida = new StringBuffer();
        float taxa = 10f;
        saida.append("Identificador: ");
        saida.append(this.getIdentificador());
        saida.append("\n");
        saida.append("Valor Ingresso: ");
        saida.append(this.valorFinal(taxa));
        saida.append("\n");
        saida.append("Ingresso VIP\n");
        saida.append("Função: ");
        saida.append(this.getFuncao());
        saida.append("\n");
        return saida.toString();
    }
}
