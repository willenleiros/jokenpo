package br.com.leiros.jokenpo.repositorios;

import br.com.leiros.jokenpo.entidades.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJogadorRepositorio extends JpaRepository<Jogador, Long> {
}
