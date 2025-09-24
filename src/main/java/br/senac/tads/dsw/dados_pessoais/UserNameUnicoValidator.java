package br.senac.tads.dsw.dados_pessoais;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserNameUnicoValidator implements ConstraintValidator<UserNameUnico, String> {

    @Autowired
    private PessoaService pessoaService;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return pessoaService.findByUserName(username) == null;
    }

}
