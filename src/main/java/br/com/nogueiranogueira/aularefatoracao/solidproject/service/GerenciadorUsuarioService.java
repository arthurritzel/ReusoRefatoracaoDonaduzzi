package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.business.RegraUsuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.repository.UsuarioCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenciadorUsuarioService {

    private final UsuarioCrudRepository usuarioRepository;
    private final List<RegraUsuario> regras;
    private final UsuarioMailSenderService mailService;

    public GerenciadorUsuarioService(
            UsuarioCrudRepository usuarioRepository,
            List<RegraUsuario> regras,
            UsuarioMailSenderService mailService) {

        this.usuarioRepository = usuarioRepository;
        this.regras = regras;
        this.mailService = mailService;
    }

    public Usuario criarUsuario(UsuarioDTO dto) {

        RegraUsuario regra = regras.stream()
                .filter(r -> r.suporta(dto.tipo()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo inválido"));

        Usuario usuario = regra.aplicar(dto);

        usuario = usuarioRepository.salvar(usuario);

        mailService.enviarEmailBoasVindas(usuario.getEmail(), usuario.getNome());

        return usuario;
    }
}