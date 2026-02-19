package br.com.nogueiranogueira.aularefatoracao.solidproject.model.regra;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;

public interface RegraUsuario {

    boolean suporta(String tipo);

    Usuario aplicar(UsuarioDTO dto);
}
