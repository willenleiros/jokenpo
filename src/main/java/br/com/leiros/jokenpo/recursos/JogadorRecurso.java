package br.com.leiros.jokenpo.recursos;

import br.com.leiros.jokenpo.entidades.Jogador;
import br.com.leiros.jokenpo.entidades.enums.TipoJogada;
import br.com.leiros.jokenpo.servicos.JogadorServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/jogador")
public class JogadorRecurso {

    @Autowired
    private JogadorServico jogadorServico;

    @PostMapping
    public ResponseEntity<Jogador> salvar(@RequestBody Jogador jogador, HttpServletResponse response){
        Jogador objetoInserido = this.jogadorServico.criar(jogador);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(objetoInserido.getCodigo())
                .toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(objetoInserido);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Jogador> escolherJogada(@RequestParam("tipoJogada") TipoJogada tipoJogada, @PathVariable Long codigo){
       return ResponseEntity.ok(this.jogadorServico.escolherJogada(tipoJogada, codigo));
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long codigo){
        this.jogadorServico.deletar(codigo);
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> listar(){
        return ResponseEntity.ok(this.jogadorServico.listar());
    }

}
