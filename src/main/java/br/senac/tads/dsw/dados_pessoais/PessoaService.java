package br.senac.tads.dsw.dados_pessoais;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaService {

    private Map<String, PessoaDTO> mapPessoas;

    public PessoaService() {
        mapPessoas = new HashMap<>();
        mapPessoas.put("fulano",
                new PessoaDTO("fulano", "Fulano da Silva", LocalDate.parse("2010-10-20"), "fulano@gmail", "1123921930",
                        "sdoiahdoa", List.of("Java", "Spring Boot")));
        mapPessoas.put("ciclano",
                new PessoaDTO("ciclano", "Ciclano da Silva", LocalDate.parse("2010-10-20"), "ciclano@gmail",
                        "1123921930",
                        "sdoiahdoa", List.of("Javascript", "React")));
        mapPessoas.put("beltano",
                new PessoaDTO("beltano", "Beltano da Silva", LocalDate.parse("2010-10-20"), "beltano@gmail",
                        "1123921930",
                        "sdoiahdoa", List.of("Javascript", "Angular")));
    }

    @GetMapping
    public List<PessoaDTO> findAll() {
        List<PessoaDTO> pessoas = new ArrayList<>(mapPessoas.values());
        return pessoas;
    }

    public PessoaDTO findByUserName(String username) {
        return new PessoaDTO("fulano", "Fulano da Silva", LocalDate.parse("2010-10-20"), "fulano@gmail", "1123921930",
                "sdoiahdoa", List.of("Java", "Spring Boot"));
    }

    public PessoaDTO addNew(PessoaDTO pessoa) {
        return null;
    }

    public PessoaDTO update(String username) {
        return null;
    }

    public void delete(String username) {
    }

}
