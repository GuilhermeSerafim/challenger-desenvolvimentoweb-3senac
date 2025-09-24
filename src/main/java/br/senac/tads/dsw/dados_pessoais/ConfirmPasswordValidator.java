package br.senac.tads.dsw.dados_pessoais;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPassword, PessoaDTO> {
    @Override
    public boolean isValid(PessoaDTO arg0, ConstraintValidatorContext arg1) {
        if(arg0.getSenha() == null) return false;
        return arg0.getSenha().equals(arg0.getRepeticaoSenha());
    }

}
