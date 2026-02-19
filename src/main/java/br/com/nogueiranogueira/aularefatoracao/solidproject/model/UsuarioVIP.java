package br.com.nogueiranogueira.aularefatoracao.solidproject.model;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.regra.Descontavel;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("VIP")
public class UsuarioVIP extends Usuario implements Descontavel {

    private boolean temCartaoFidelidade;

    public UsuarioVIP(String nome, String email, String tipo) {
        super(nome, email, tipo);
    }

    public UsuarioVIP() {
    }

    public boolean temCartaoFidelidade() {
        return temCartaoFidelidade;
    }

    @Override
    public int calcularDesconto() {
        return temCartaoFidelidade ? 10 : 0;
    }

    @Override
    public int getDesconto() {
        return calcularDesconto();
    }
}
