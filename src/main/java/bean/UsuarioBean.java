package bean;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.UsuarioDao;
import entidades.Usuario;

@ManagedBean
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private List<Usuario> lista;
	
	public String salvar() {
		usuario.setDataCadastro(new Date());
		UsuarioDao.salvar(usuario);
		usuario = new Usuario();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário salvo com sucesso"));
		return null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getLista() {
		if (lista == null) {
			lista = UsuarioDao.listarTodos();
		}
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}
}
