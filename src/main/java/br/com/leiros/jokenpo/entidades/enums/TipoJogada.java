package br.com.leiros.jokenpo.entidades.enums;

public enum TipoJogada {

    SPOCK(0), LARGATO(1), PEDRA(2), PAPEL(3) , TESOURA(4);

    public int valor;

    TipoJogada(int valor){
        this.valor = valor;
    }

}
