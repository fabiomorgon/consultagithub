package br.com.alura.consultagithub.modelos;

import br.com.alura.consultagithub.excecao.ErroConsultaGitHubException;

public class UsuarioGit {

    private String login;
    private String htmlUrl;

    public UsuarioGit (RetornoGitRecord retornoGitRecord) {
        if (retornoGitRecord.message() == null) {
            this.login = retornoGitRecord.login();
            this.htmlUrl = retornoGitRecord.html_url();
        } else {
            throw new ErroConsultaGitHubException("usuário não encontrado");
        }
    }

    @Override
    public String toString() {
        return "UsuarioGit{" +
                "login= " + this.login +
                ", url= " + this.htmlUrl +
                '}';
    }
}
