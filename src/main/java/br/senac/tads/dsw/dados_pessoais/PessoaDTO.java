package br.senac.tads.dsw.dados_pessoais;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@ConfirmPassword
public class PessoaDTO {
    private String repeticaoSenha;

    @NotBlank
    @Size(min = 3, max = 64)
    @UserNameUnico
    private String username;

    @NotBlank
    @Size(min = 2, max = 1000)
    private String nome;

    @PastOrPresent
    private LocalDate dataNasc;

    @NotBlank
    @Size(max = 100)
    @Email()
    private String email;

    @Size(max = 20)
    private String telefone;

    @NotBlank
    @Size(min = 8)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "A senha deve ter no mínimo 8 caracteres, incluindo letra maiúscula, minúscula, número e caractere especial.")
    private String senha;

    @Size(min = 1)
    private List<@NotBlank String> interesses;

    public PessoaDTO() {
    }

    public PessoaDTO(String username, String nome, LocalDate dataNasc, String email, String telefone, String senha,
            List<String> interesses, String repeticaoSenha) {
        this.username = username;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.interesses = interesses;
        this.repeticaoSenha = repeticaoSenha;
    }

    public String getRepeticaoSenha() {
        return repeticaoSenha;
    }

    public void setRepeticaoSenha(String repeticaoSenha) {
        this.repeticaoSenha = repeticaoSenha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<String> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<String> interesses) {
        this.interesses = interesses;
    }
}
