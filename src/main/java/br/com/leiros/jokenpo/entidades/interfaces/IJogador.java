package br.com.leiros.jokenpo.entidades.interfaces;

import br.com.leiros.jokenpo.entidades.Jogada;

import java.io.Serializable;

public interface IJogador extends Serializable {

    void adicionarJogada(Jogada jogada);
    void removerJogada();

}
