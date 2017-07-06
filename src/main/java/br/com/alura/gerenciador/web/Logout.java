package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		String mensagem = "<html><body><mensagem></body></html>";
		if(cookie == null){
			mensagem = mensagem.replace("<mensagem>", "Usuario não estava logado");
			return;
		}
		
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		PrintWriter writer = resp.getWriter();
		writer.write(mensagem.replace("<mensagem>","Deslogado com sucesso"));		
	}

}
