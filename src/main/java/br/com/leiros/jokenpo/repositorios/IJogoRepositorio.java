package br.com.leiros.jokenpo.repositorios;

import br.com.leiros.jokenpo.entidades.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJogoRepositorio extends JpaRepository<Jogo, Long> {
}
