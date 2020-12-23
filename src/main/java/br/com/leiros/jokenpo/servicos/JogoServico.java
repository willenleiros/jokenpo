package br.com.leiros.jokenpo.servicos;

import br.com.leiros.jokenpo.entidades.*;
import br.com.leiros.jokenpo.repositorios.IJogoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;

@Service
public class JogoServico {

    @Autowired
    private IJogoRepositorio repositorio;

    public Jogo criar(Jogo jogo){
        return this.repositorio.save(jogo);
    }

    public List<Jogo> listar(){
        return this.repositorio.findAll();
    }

    public Jogo adicionarJogador(Long codigo, Jogador jogador){
        Jogo objeto = this.buscarPorCodigo(codigo);
        objeto.adicionar(jogador);
        return this.repositorio.save(objeto);
    }

    public void removerJogador(Long codigo, Jogador jogador){
        Jogo objeto = this.buscarPorCodigo(codigo);
        objeto.remover(jogador);
        this.repositorio.save(objeto);
    }

    public Jogador finalizar(Long codigo){

        Jogo jogo = this.buscarPorCodigo(codigo);
        Jogador vencedorDaRodada = null;

        ListIterator<Jogador> listIterator = jogo.getJogadores().listIterator();

        while (listIterator.hasNext()){

            Jogador jogador1 = null;
            Jogador jogador2 = null;

            jogador1 = listIterator.next();
            if(listIterator.hasNext()) {
                jogador2 = jogo.getJogadores().get(listIterator.nextIndex());
                vencedorDaRodada = verificarVencedor(jogador1, jogador2);
            }
            else
                break;

        }

        return vencedorDaRodada;
    }

    public Jogo buscarPorCodigo(Long codigo){
        return this.repositorio.findById(codigo)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    private Jogador verificarVencedor(Jogador jogador1, Jogador jogador2){

        if(jogador1.getJogada().getTipoJogada().valor == 0 &&
                jogador2.getJogada().getTipoJogada().valor == 1){
            return jogador2;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 0 &&
                jogador2.getJogada().getTipoJogada().valor == 2){
            return jogador1;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 0 &&
                jogador2.getJogada().getTipoJogada().valor == 3){
            return jogador2;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 0 &&
                jogador2.getJogada().getTipoJogada().valor == 4){
            return jogador1;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 1 &&
                jogador2.getJogada().getTipoJogada().valor == 0){
            return jogador1;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 1 &&
                jogador2.getJogada().getTipoJogada().valor == 2){
            return jogador2;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 1 &&
                jogador2.getJogada().getTipoJogada().valor == 3){
            return jogador1;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 1 &&
                jogador2.getJogada().getTipoJogada().valor == 4){
            return jogador2;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 2 &&
                jogador2.getJogada().getTipoJogada().valor == 0){
            return jogador2;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 2 &&
                jogador2.getJogada().getTipoJogada().valor == 1){
            return jogador1;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 2 &&
                jogador2.getJogada().getTipoJogada().valor == 3){
            return jogador2;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 2 &&
                jogador2.getJogada().getTipoJogada().valor == 4){
            return jogador1;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 3 &&
                jogador2.getJogada().getTipoJogada().valor == 0){
            return jogador1;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 3 &&
                jogador2.getJogada().getTipoJogada().valor == 1){
            return jogador2;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 3 &&
                jogador2.getJogada().getTipoJogada().valor == 2){
            return jogador1;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 3 &&
                jogador2.getJogada().getTipoJogada().valor == 4){
            return jogador2;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 4 &&
                jogador2.getJogada().getTipoJogada().valor == 0){
            return jogador2;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 4 &&
                jogador2.getJogada().getTipoJogada().valor == 1){
            return jogador1;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 4 &&
                jogador2.getJogada().getTipoJogada().valor == 2){
            return jogador2;
        }
        else if(jogador1.getJogada().getTipoJogada().valor == 4 &&
                jogador2.getJogada().getTipoJogada().valor == 3){
            return jogador1;
        }
        else{
            return null;
        }
    }

}
