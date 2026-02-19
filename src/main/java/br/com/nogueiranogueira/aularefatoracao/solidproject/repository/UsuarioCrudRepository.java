package br.com.nogueiranogueira.aularefatoracao.solidproject.repository;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends JpaRepository<Usuario, Long> {

    default Usuario salvar(Usuario usuario) {
        return save(usuario);
    }

    default Optional<Usuario> buscarPorId(Long id) {
        return findById(id);
    }

    default List<Usuario> buscarTodos() {
        return findAll();
    }

    default void excluir(Usuario usuario) {
        delete(usuario);
    }
}
