import org.example.Cliente;
import org.example.Suporte;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClienteTest {
    @Test
    public void deveNotificarUmCliente() {
        Suporte suporte = new Suporte("Atendente 1");
        Cliente cliente = new Cliente("Cliente 1");
        cliente.solicitarSuporte(suporte);
        suporte.receberPedido("Por favor, resolva o problema X.");
        assertEquals("Cliente 1, você tem uma nova atualização do suporte: Suporte{Atendido por: Atendente 1\n ultimaMensagem='Por favor, resolva o problema X.'}",
                cliente.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarClientes() {
        Suporte suporte = new Suporte("Atendente 1");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.solicitarSuporte(suporte);
        cliente2.solicitarSuporte(suporte);
        suporte.receberPedido("Problema Y foi resolvido.");
        assertEquals("Cliente 1, você tem uma nova atualização do suporte: Suporte{Atendido por: Atendente 1\n ultimaMensagem='Problema Y foi resolvido.'}",
                cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, você tem uma nova atualização do suporte: Suporte{Atendido por: Atendente 1\n ultimaMensagem='Problema Y foi resolvido.'}",
                cliente2.getUltimaNotificacao());
    }

    @Test
    public void naoDeveNotificarCliente() {
        Suporte suporte = new Suporte("Atendente 1");
        Cliente cliente = new Cliente("Cliente 1");
        suporte.receberPedido("Problema Z foi resolvido.");
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarClienteEspecifico() {
        Suporte suporte1 = new Suporte("Atendente 1");
        Suporte suporte2 = new Suporte("Atendente 2");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.solicitarSuporte(suporte1);
        cliente2.solicitarSuporte(suporte2);
        suporte1.receberPedido("Problema A foi resolvido.");
        assertEquals("Cliente 1, você tem uma nova atualização do suporte: Suporte{Atendido por: Atendente 1\n ultimaMensagem='Problema A foi resolvido.'}",
                cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}
