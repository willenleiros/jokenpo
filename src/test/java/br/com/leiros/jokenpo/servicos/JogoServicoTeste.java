package br.com.leiros.jokenpo.servicos;

import br.com.leiros.jokenpo.entidades.Jogada;
import br.com.leiros.jokenpo.entidades.Jogador;
import br.com.leiros.jokenpo.entidades.Jogo;
import br.com.leiros.jokenpo.entidades.enums.StatusJogo;
import br.com.leiros.jokenpo.entidades.enums.TipoJogada;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JogoServicoTeste {

    private Jogo jogo;

    @Autowired
    private JogoServico jogoServico;

    @Autowired
    private JogadorServico jogadorServico;

    @BeforeEach
    @DisplayName("Executa antes de fazer qualquer testes")
    void init() {

        Jogo jogo = new Jogo();
        jogo.setCodigo(1L);
        jogo.setData(LocalDateTime.now());
        jogo.setStatus(StatusJogo.EM_ANDAMENTO);
        this.jogo = this.jogoServico.criar(jogo);

        Jogador jogador1 = new Jogador();
        jogador1.setCodigo(1L);
        jogador1.setApelido("nino");
        jogador1.setNome("willen");
        this.jogadorServico.criar(jogador1);

        Jogador jogador2 = new Jogador();
        jogador2.setCodigo(2L);
        jogador2.setApelido("fefe");
        jogador2.setNome("jennifer");
        this.jogadorServico.criar(jogador2);

        Jogador jogador3 = new Jogador();
        jogador3.setCodigo(3L);
        jogador3.setApelido("didi");
        jogador3.setNome("diana");
        this.jogadorServico.criar(jogador3);

    }

    @AfterEach
    @DisplayName("Executa depois de executar os testes")
    void tearDown() {

    }

    @Test
    @DisplayName("Testa a adição de jogadores em um jogo")
    public void testeAdicionarJogadoresAoJogo() {

        Jogador jogador1 = this.jogadorServico.buscarPorCodigo(1L);
        Jogador jogador2 = this.jogadorServico.buscarPorCodigo(2L);
        Jogador jogador3 = this.jogadorServico.buscarPorCodigo(3L);

        this.jogoServico.adicionarJogador(1L, jogador1);
        this.jogoServico.adicionarJogador(1L, jogador2);
        this.jogoServico.adicionarJogador(1L, jogador3);

        Jogo jogo = this.jogoServico.buscarPorCodigo(1L);

        assertEquals(jogo.getJogadores().size(), 3);

    }

    @Test
    @DisplayName("Teste de um jogador escolher jogada")
    public void testeEscolherJogada(){

        assertNotNull(this.jogadorServico.escolherJogada(TipoJogada.PAPEL, 1L ));
        assertNotNull(this.jogadorServico.escolherJogada(TipoJogada.LARGATO, 2L));
        assertNotNull(this.jogadorServico.escolherJogada(TipoJogada.SPOCK, 3L));

    }

    @Test
    @DisplayName("Teste finalizar jogo")
    public void testeFinalizar() {

        Jogo jogo = this.jogoServico.buscarPorCodigo(1L);

        assertNotNull(this.jogoServico.finalizar(1L));

    }


}
