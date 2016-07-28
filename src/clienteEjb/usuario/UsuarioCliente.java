package clienteEjb.usuario;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import testeEjb.usuario.Usuario;
import testeEjb.usuario.UsuarioServico;


public class UsuarioCliente {

	public static void main(String[] args) throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);
        
        String jndi = "ejb:testeEjbEar/testeEjb/UsuarioServiceImpl!testeEjb.usuario.UsuarioServico";
        
        UsuarioServico servico = (UsuarioServico) context.lookup(jndi);
        List<Usuario> usuarios = servico.obterTodosUsuarios();
        for(Usuario u : usuarios){
        	System.out.println("Login: "+u.getLogin());
        	System.out.println("Senha: "+u.getSenha());
        }
        
	}
}

