package br.com.linsbruno.dao;

import br.com.linsbruno.domain.Cliente;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClienteMapDAO implements ClienteDAO {
    private Map<String, Cliente> clientes;

    public ClienteMapDAO() {
        this.clientes = new HashMap<>();
    }

    @Override
    public boolean cadastrarCliente(Cliente cliente) {
        if (clientes.containsKey(cliente.getCpf())) {
            return false; // CPF já cadastrado
        }
        clientes.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public Cliente consultarCliente(String cpf) {
        return clientes.get(cpf);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clientes.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean atualizarCliente(String cpf, Cliente novoCliente) {
        if (!clientes.containsKey(cpf)) {
            return false; // Cliente não encontrado
        }
        clientes.put(cpf, novoCliente);
        return true;
    }

    @Override
    public boolean excluirCliente(String cpf) {
        cpf = null;
        return clientes.remove(cpf) != null;
    }

    @Override
    public void atualizarCliente() {
        
    }
}