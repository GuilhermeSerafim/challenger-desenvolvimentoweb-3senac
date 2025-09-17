package br.senac.tads.dsw.dados_pessoais;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PessoaController {

    // O Spring instancia
    @Autowired
    private PessoaService service;

    @GetMapping
    public List<PessoaDTO> findAll() {
        return service.findAll();
    }

    // Required false - parametro opcional
    // defaultValue = "fulano"
    @GetMapping("/apelido")
    public PessoaDTO findByUsernameRequestParam(@RequestParam(value = "username", required = false) String userNameIN) {
        if(userNameIN == null) service.findByUserName("fulano");
        return service.findByUserName(userNameIN);
    }
    
    @GetMapping("/{username}")
    public PessoaDTO findByUsernameRequest(@PathVariable("username") String userNameIN) {
        PessoaDTO p = service.findByUserName(userNameIN);
        if(p == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pesquisa %s não encontrada".formatted(userNameIN));
        return p;
    }
}
