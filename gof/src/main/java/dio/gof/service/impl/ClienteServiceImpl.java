package dio.gof.service.impl;

import dio.gof.model.Cliente;
import dio.gof.service.ClienteService;
import org.springframework.stereotype.Service;

/**
 * Implementação da <strong>Strategy</strong> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <strong>Singleton</strong>.
 *
 * @author gafanhotoalexandre
 */
@Service
public class ClienteServiceImpl implements ClienteService {
    @Override
    public Iterable<Cliente> buscarTodos() {
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

    }

    @Override
    public void deletar(Long id) {

    }
}
