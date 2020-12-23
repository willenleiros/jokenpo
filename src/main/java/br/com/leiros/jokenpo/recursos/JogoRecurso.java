package br.com.leiros.jokenpo.recursos;

import br.com.leiros.jokenpo.entidades.Jogador;
import br.com.leiros.jokenpo.entidades.Jogo;
import br.com.leiros.jokenpo.servicos.JogoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/jogo")
public class JogoRecurso {

    @Autowired
    private JogoServico jogoServico;

    @PostMapping
    public ResponseEntity<Jogo> criar(@RequestBody Jogo jogo, HttpServletResponse response){
        Jogo objetoInserido = this.jogoServico.criar(jogo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(objetoInserido.getCodigo())
                .toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(objetoInserido);
    }

    @GetMapping
    public ResponseEntity<List<Jogo>> listar(){
        return ResponseEntity.ok(this.jogoServico.listar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Jogo> buscarPorCodigo(@PathVariable Long codigo){
        return ResponseEntity.ok(this.jogoServico.buscarPorCodigo(codigo));
    }

    @PutMapping("/{codigo}/adicionar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void adicionarJogador(@PathVariable Long codigo, @RequestBody Jogador jogador){
        this.jogoServico.adicionarJogador(codigo, jogador);
    }

    @PutMapping("/{codigo}/remover")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerJogador(@PathVariable Long codigo, @RequestBody Jogador jogador){
        this.jogoServico.removerJogador(codigo, jogador);
    }

    @PutMapping("/{codigo}/finalizar")
    public ResponseEntity<Jogador> finalizar(@PathVariable Long codigo){
        return ResponseEntity.ok(this.jogoServico.finalizar(codigo));
    }

}
