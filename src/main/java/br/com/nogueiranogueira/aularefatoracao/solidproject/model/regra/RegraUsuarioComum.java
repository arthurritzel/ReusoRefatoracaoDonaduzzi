package br.com.nogueiranogueira.aularefatoracao.solidproject.model.regra;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.regra.RegraUsuario;
import org.springframework.stereotype.Component;

@Component
public class RegraUsuarioComum implements RegraUsuario {

    @Override
    public boolean suporta(String tipo) {
        return "COMUM".equals(tipo);
    }

    @Override
    public Usuario aplicar(UsuarioDTO dto) {
        validarEmail(dto.email());

        Usuario usuario = new Usuario(dto.nome(), dto.email(), dto.tipo());
        usuario.setPontos(0);
        return usuario;
    }

    private void validarEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
    }
}

