package br.com.leiros.jokenpo.entidades;

import br.com.leiros.jokenpo.entidades.interfaces.IJogador;
import lombok.*;

import javax.persistence.*;


@EqualsAndHashCode
@ToString
@Entity
public class Jogador implements IJogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long codigo;

    @NonNull
    @Getter @Setter
    private String nome;

    @NonNull
    @Column(unique=true)
    @Getter @Setter
    private String apelido;

    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @Getter @Setter private Jogada jogada;

    @Override
    public void adicionarJogada(Jogada jogada) {
        this.jogada = jogada;
    }

    @Override
    public void removerJogada() {
        this.jogada = null;
    }

}
