package br.senac.tads.dsw.dados_pessoais;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class PessoaService {

    private Map<String, PessoaDTO> mapPessoas;

    public PessoaService() {
        mapPessoas = new HashMap<>();
        mapPessoas.put("fulano",
                new PessoaDTO("fulano", "Fulano da Silva", LocalDate.parse("2010-10-20"), "fulano@gmail", "1123921930",
                        "sdoiahdoa", List.of("Java", "Spring Boot"), "1123921930"));
        mapPessoas.put("ciclano",
                new PessoaDTO("ciclano", "Ciclano da Silva", LocalDate.parse("2010-10-20"), "ciclano@gmail",
                        "1123921930",
                        "sdoiahdoa", List.of("Javascript", "React"), "1123921930"));
        mapPessoas.put("beltano",
                new PessoaDTO("beltano", "Beltano da Silva", LocalDate.parse("2010-10-20"), "beltano@gmail",
                        "1123921930",
                        "sdoiahdoa", List.of("Javascript", "Angular"), "1123921930"));
    }

    @GetMapping
    public List<PessoaDTO> findAll() {
        List<PessoaDTO> pessoas = new ArrayList<>(mapPessoas.values());
        return pessoas;
    }

    public PessoaDTO findByUserName(String username) {
        return mapPessoas.get(username);
    }

    public PessoaDTO addNew(PessoaDTO pessoa) {
        mapPessoas.put(pessoa.getUsername(), pessoa);
        return pessoa;
    }

    public PessoaDTO update(String username, PessoaDTO pessoa) {
        if (!mapPessoas.containsKey(username)) {
            return null;
        }
        mapPessoas.put(username, pessoa);
        return pessoa;
    }

    public void delete(String username) {
        mapPessoas.remove(username);
    }

}
