package br.com.leiros.jokenpo.entidades;

import br.com.leiros.jokenpo.entidades.enums.StatusJogo;
import br.com.leiros.jokenpo.entidades.interfaces.IJogo;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode
@ToString
@Entity
public class Jogo implements IJogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long codigo;

    @Getter @Setter private LocalDateTime data;
    @Getter @Setter private StatusJogo status;

    @ManyToMany(fetch = FetchType.EAGER)
    @Getter @Setter private List<Jogador> jogadores;

    @Override
    public void adicionar(Jogador jogador) {
        this.jogadores.add(jogador);
    }

    @Override
    public Boolean remover(Jogador jogador) {
        return this.jogadores.removeIf(jog -> jog.getCodigo() == jogador.getCodigo());
    }

}
