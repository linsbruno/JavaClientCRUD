package br.com.linsbruno;

import br.com.linsbruno.dao.ClienteDAO;
import br.com.linsbruno.dao.ClienteMapDAO;
import br.com.linsbruno.domain.Cliente;

import javax.swing.*;

public class App {
    private static ClienteDAO clienteDAO;

    public static void main(String[] args) {
        clienteDAO = new ClienteMapDAO();

        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Escolha uma opção:\n" +
                            "1. Cadastrar cliente\n" +
                            "2. Consultar cliente\n" +
                            "3. Listar clientes\n" +
                            "4. Atualizar cliente\n" +
                            "5. Excluir cliente\n" +
                            "6. Sair"
            ));

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    consultarCliente();
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    atualizarCliente();
                    break;
                case 5:
                    excluirCliente();
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saindo do programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 6);
    }

    private static void cadastrarCliente() {
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
        String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente:");
        String numero = JOptionPane.showInputDialog("Digite o número do cliente:");
        String telefone = JOptionPane.showInputDialog("Digite o telefone do cliente:");
        String cidade = JOptionPane.showInputDialog("Digite a cidade do cliente:");
        String estado = JOptionPane.showInputDialog("Digite o estado do cliente:");

        Cliente cliente = new Cliente(nome, cpf, numero, telefone, cidade, estado);
        if (clienteDAO.cadastrarCliente(cliente)) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente. CPF já cadastrado.");
        }
    }

    private static void consultarCliente() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente:");
        Cliente cliente = clienteDAO.consultarCliente(cpf);
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, cliente.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
        }
    }

    private static void listarClientes() {
        StringBuilder sb = new StringBuilder("Clientes cadastrados:\n");
        for (Cliente cliente : clienteDAO.listarClientes()) {
            sb.append(cliente.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void atualizarCliente() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente a ser atualizado:");
        Cliente clienteExistente = clienteDAO.consultarCliente(cpf);
        if (clienteExistente != null) {
            String nome = JOptionPane.showInputDialog("Digite o novo nome do cliente:");
            String numero = JOptionPane.showInputDialog("Digite o novo número do cliente:");
            String telefone = JOptionPane.showInputDialog("Digite o novo telefone do cliente:");
            String cidade = JOptionPane.showInputDialog("Digite a nova cidade do cliente:");
            String estado = JOptionPane.showInputDialog("Digite o novo estado do cliente:");

            Cliente novoCliente = new Cliente(nome, cpf, numero, telefone, cidade, estado);
            if (clienteDAO.atualizarCliente(cpf, novoCliente)) {
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
        }
    }

    private static void excluirCliente() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente a ser excluído:");
        if (clienteDAO.excluirCliente(cpf)) {
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente. Cliente não encontrado.");
        }
    }
}
