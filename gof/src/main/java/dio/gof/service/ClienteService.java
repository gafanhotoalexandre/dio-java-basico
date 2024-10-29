package dio.gof.service;

import dio.gof.model.Cliente;

/**
 * Interface que define o padrão <strong>Strategy</strong> no domínio de cliente. Com
 * isso, se necessário, podemos ter múltiplas implementações dessa mesma
 * interface
 *
 * @author gafanhotoalexandre
 */
public interface ClienteService {

    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);
}
