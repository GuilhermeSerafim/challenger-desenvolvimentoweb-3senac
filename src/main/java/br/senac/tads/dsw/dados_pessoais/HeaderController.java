package br.senac.tads.dsw.dados_pessoais;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderController {
    @GetMapping("/headers")
    public Map<String, Object> obterTodosHeaders(@RequestHeader Map<String, Object> headers) {
        return headers;
    }

    @GetMapping("/headers/users-agent")
    public String obterUserAgent(@RequestHeader("user-agent") String x) {
        return x;
    }
}
