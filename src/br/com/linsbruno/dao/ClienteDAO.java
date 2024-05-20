package br.com.linsbruno.dao;

import br.com.linsbruno.domain.Cliente;
import java.util.List;

public interface ClienteDAO {
    boolean cadastrarCliente(Cliente cliente);
    Cliente consultarCliente(String cpf);
    List<Cliente> listarClientes();
    boolean atualizarCliente(String cpf, Cliente novoCliente);
    boolean excluirCliente(String cpf);

    void atualizarCliente();
}
