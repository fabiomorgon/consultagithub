package br.com.alura.consultagithub.excecao;

public class ErroConsultaGitHubException extends RuntimeException{

    public ErroConsultaGitHubException(String mensagem) {
        this.mensagem = mensagem;
    }

    private String mensagem;

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
