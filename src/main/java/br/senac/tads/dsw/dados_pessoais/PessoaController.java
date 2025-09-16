package br.senac.tads.dsw.dados_pessoais;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
