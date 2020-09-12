package br.com.leilao.test;

import org.openqa.selenium.WebDriver;

public class CriadorCenarios {
	
    private WebDriver driver;

    CriadorCenarios(WebDriver driver) {
        this.driver = driver;
    }

    CriadorCenarios umUsuario(String nome, String email) {
        UsuariosPage usuarios = new UsuariosPage(driver);
        usuarios.visita();
        usuarios.novo().cadastra(nome, email);
        return this;
    }

    CriadorCenarios umLeilao(String usuario, String produto, Double valor, Boolean usado) {
        LeiloesPage leiloes = new LeiloesPage(driver);
        leiloes.visita();
        leiloes.novo().preenche(produto, valor, usuario, usado);
        return this;
    }
}
