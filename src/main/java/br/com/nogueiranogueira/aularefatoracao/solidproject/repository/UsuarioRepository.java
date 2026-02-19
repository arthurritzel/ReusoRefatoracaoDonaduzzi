package br.com.nogueiranogueira.aularefatoracao.solidproject.repository;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends
        JpaRepository<Usuario, Long>,
        UsuarioCrudRepository,
        UsuarioFiltroRepository,
        UsuarioRelatorioRepository {

    @Override
    @Query("SELECT u FROM Usuario u WHERE " +
           "(:nome IS NULL OR u.nome LIKE %:nome%) AND " +
           "(:email IS NULL OR u.email LIKE %:email%) AND " +
           "(:tipoUsuario IS NULL OR u.tipo = :tipoUsuario)")
    List<Usuario> buscarPorFiltrosAvancados(
            @Param("nome") String nome,
            @Param("email") String email,
            @Param("tipoUsuario") String tipoUsuario);

    @Override
    @Query("SELECT COUNT(u) FROM Usuario u WHERE u.tipo = :tipoUsuario")
    long contarUsuariosPorTipo(@Param("tipoUsuario") String tipoUsuario);

    @Override
    @Query("SELECT u.tipo, COUNT(u) FROM Usuario u GROUP BY u.tipo")
    List<Object[]> gerarRelatorioUsuariosPorTipo();
}
