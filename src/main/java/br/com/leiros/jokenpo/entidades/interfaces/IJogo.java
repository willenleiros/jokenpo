package br.com.leiros.jokenpo.entidades.interfaces;

import br.com.leiros.jokenpo.entidades.Jogador;

import java.io.Serializable;

public interface IJogo extends Serializable {

    void adicionar(Jogador jogador);
    Boolean remover(Jogador codigo);

}
