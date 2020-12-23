package br.com.leiros.jokenpo.entidades;

import br.com.leiros.jokenpo.entidades.abstratos.JogadaAbstrata;
import br.com.leiros.jokenpo.entidades.interfaces.IJogada;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@EqualsAndHashCode
@ToString
@Entity
public class Jogada extends JogadaAbstrata implements IJogada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long codigo;

}
