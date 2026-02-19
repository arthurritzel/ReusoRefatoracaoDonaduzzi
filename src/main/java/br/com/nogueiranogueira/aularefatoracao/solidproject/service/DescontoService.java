package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.business.Descontavel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescontoService {

    public int calculaDescontoTotal(List<Usuario> usuarios) {
        return usuarios.stream()
                .mapToInt(this::calcularDesconto)
                .sum();
    }

    private int calcularDesconto(Usuario usuario) {
        if (usuario instanceof Descontavel descontavel) {
            return descontavel.calcularDesconto();
        }
        return 0;
    }
}
