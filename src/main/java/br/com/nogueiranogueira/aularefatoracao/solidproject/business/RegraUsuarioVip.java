package br.com.nogueiranogueira.aularefatoracao.solidproject.business;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.UsuarioVIP;
import org.springframework.stereotype.Component;

@Component
public class RegraUsuarioVip implements RegraUsuario {

    @Override
    public boolean suporta(String tipo) {
        return "VIP".equals(tipo);
    }

    @Override
    public Usuario aplicar(UsuarioDTO dto) {
        validarEmail(dto.email());
        validarIdade(dto.idade());

        UsuarioVIP usuario = new UsuarioVIP(dto.nome(), dto.email(), dto.tipo());
        usuario.setPontos(100);
        return usuario;
    }

    private void validarEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
    }

    private void validarIdade(int idade) {
        if (idade < 18) {
            throw new IllegalArgumentException("Usuário deve ser maior de idade");
        }
    }
}
