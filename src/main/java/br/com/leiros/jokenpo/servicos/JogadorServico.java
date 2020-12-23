package br.com.leiros.jokenpo.servicos;

import br.com.leiros.jokenpo.entidades.*;
import br.com.leiros.jokenpo.entidades.enums.TipoJogada;
import br.com.leiros.jokenpo.repositorios.IJogadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

import static br.com.leiros.jokenpo.entidades.enums.TipoJogada.*;

@Service
public class JogadorServico {

    @Autowired
    private IJogadorRepositorio repositorio;

    public Jogador criar(Jogador jogador){
        return this.repositorio.save(jogador);
    }

    public Jogador escolherJogada(TipoJogada tipoJogada, Long codigo){

        Jogador jogador = buscarPorCodigo(codigo);

        switch (tipoJogada){
            case TESOURA :
                Jogada jogadaTesoura = new Jogada();
                jogadaTesoura.setTipoJogada(TESOURA);
                jogador.adicionarJogada(jogadaTesoura);
                break;
            case PAPEL:
                Jogada jogadaPapel= new Jogada();
                jogadaPapel.setTipoJogada(PAPEL);
                jogador.adicionarJogada(jogadaPapel);
                break;
            case PEDRA:
                Jogada jogadaPedra = new Jogada();
                jogadaPedra.setTipoJogada(PEDRA);
                jogador.adicionarJogada(jogadaPedra);
                break;
            case SPOCK:
                Jogada jogadaSpock = new Jogada();
                jogadaSpock.setTipoJogada(SPOCK);
                jogador.adicionarJogada(jogadaSpock);
                break;
            case LARGATO:
                Jogada jogadaLagarto = new Jogada();
                jogadaLagarto.setTipoJogada(LARGATO);
                jogador.adicionarJogada(jogadaLagarto);
                break;
        }

        return this.repositorio.save(jogador);
    }

    public void deletar(Long codigo){
        Jogador jogador = buscarPorCodigo(codigo);
        this.repositorio.delete(jogador);
    }

    public List<Jogador> listar(){
        return this.repositorio.findAll();
    }

    public Jogador buscarPorCodigo(Long codigo){
        return this.repositorio.findById(codigo)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));

    }

}
