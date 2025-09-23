package br.senac.tads.dsw.dados_pessoais;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/pessoas") // Todas as requisições prefixos
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
        if (userNameIN == null)
            service.findByUserName("fulano");
        return service.findByUserName(userNameIN);
    }

    @GetMapping("/{username}")
    public PessoaDTO findByUsernameRequest(@PathVariable("username") String userNameIN) {
        PessoaDTO p = service.findByUserName(userNameIN);
        if (p == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pesquisa %s não encontrada".formatted(userNameIN));
        return p;
    }

    @PostMapping()
    public ResponseEntity<?> addNew(@RequestBody @Valid PessoaDTO p) {
        PessoaDTO pessoa = service.addNew(p);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{username}")
                .buildAndExpand(pessoa.getUsername())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> update(@PathVariable String username, @RequestBody String pessoa) {
        PessoaDTO p = service.findByUserName(username);
        if (p == null)
            return ResponseEntity.notFound().build();
        p = service.update(username, p);
        return ResponseEntity.noContent().build();
    }

    // <?> Quando não sei o obj que estou recebendo
    @DeleteMapping
    public ResponseEntity<?> delete(String username) {
        service.delete(username);
        return ResponseEntity.noContent().build();
    }

}
