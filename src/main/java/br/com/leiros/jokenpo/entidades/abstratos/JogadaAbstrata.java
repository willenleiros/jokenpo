package br.com.leiros.jokenpo.entidades.abstratos;

import br.com.leiros.jokenpo.entidades.enums.TipoJogada;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class JogadaAbstrata {

    @Getter
    @Setter
    private Boolean vencedor = false;

    @Getter
    @Setter
    private TipoJogada tipoJogada;

}
