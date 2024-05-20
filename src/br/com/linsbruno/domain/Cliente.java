package br.com.linsbruno.domain;

public class Cliente {
    private String nome;
    private String cpf;
    private String numero;
    private String telefone;
    private String cidade;
    private String estado;

    // Construtor
    public Cliente(String nome, String cpf, String numero, String telefone, String cidade, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.numero = numero;
        this.telefone = telefone;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Cliente(String nome, String cpf, String num) {
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // ToString para representação textual do objeto
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", numero='" + numero + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
