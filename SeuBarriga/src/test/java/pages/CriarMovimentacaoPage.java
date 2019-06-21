package pages;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.WebDriverFactory;
import utils.evidencia.Evidencia;

public class CriarMovimentacaoPage {

	WebDriverFactory DriverFactory = new WebDriverFactory();

	public static final String XPATH_TIPO_MOVIMENTACAO = "//select[@id='tipo']";
	public static final String XPATH_DATA_MOVIMENTACAO = "//input[@id='data_transacao']";
	public static final String XPATH_DATA_PAGAMENTO = "//input[@id='data_pagamento']";
	public static final String XPATH_DESCRICAO = "//input[@id='descricao']";
	public static final String XPATH_INTERESSADO = "//input[@id='interessado']";
	public static final String XPATH_VALOR = "//input[@id='valor']";
	public static final String XPATH_CONTA = "//select[@id='conta']";
	public static final String XPATH_SITUACAO = "//input[contains(@id,'status')]";
	public static final String XPATH_BTNOK = " //button[@type='submit']";
	public static final String XPATH_MSG_SUCESSO = "//div[@class='alert alert-success']";
	public static final String XPATH_MSG_SEM_SUCESSO = "//div[@class='alert alert-danger']";

	public WebElement getTipoMovimentacao() {
		return DriverFactory.getWebDriver().findElement(By.xpath(XPATH_TIPO_MOVIMENTACAO));

	}

	public void setTipoMovimentacao(String values) {
		new Select(getTipoMovimentacao()).selectByVisibleText(values);
	}

	public WebElement getDataMovimentacao() {

		return DriverFactory.getWebDriver().findElement(By.xpath(XPATH_DATA_MOVIMENTACAO));

	}

	public void setdataMovimentacao(String values) {
		getDataMovimentacao().sendKeys(values);

	}

	public WebElement getDataPagamento() {
		return DriverFactory.getWebDriver().findElement(By.xpath(XPATH_DATA_PAGAMENTO));

	}

	public void setdataPagamento(String values) {
		getDataPagamento().sendKeys(values);

	}

	public WebElement getDescricao() {
		return DriverFactory.getWebDriver().findElement(By.xpath(XPATH_DESCRICAO));

	}

	public void setdescricao(String values) {
		getDescricao().sendKeys(values);

	}

	public WebElement getInteressado() {
		return DriverFactory.getWebDriver().findElement(By.xpath(XPATH_INTERESSADO));

	}

	public void setinteressado(String values) {
		getInteressado().sendKeys(values);

	}

	public WebElement getValor() {
		return DriverFactory.getWebDriver().findElement(By.xpath(XPATH_VALOR));

	}

	public void setvalor(String values) {
		getValor().sendKeys(values);

	}

	public WebElement getConta() {
		return DriverFactory.getWebDriver().findElement(By.xpath(XPATH_CONTA));

	}

	public void setConta(String values) {
		new Select(getConta()).selectByVisibleText(values);

	}

	public WebElement getSituacao(String status) {
		return DriverFactory.getWebDriver().findElement(By.xpath(XPATH_SITUACAO));

	}

	public void setBtnSituacao(String status) {
		getSituacao(status).click();
	}

	public WebElement getBtnOk() {
		return DriverFactory.getWebDriver().findElement(By.xpath(XPATH_BTNOK));

	}

	public void clickBtnOk() {
		getBtnOk().click();
	}

	public WebElement getMsgSucesso() {
		return DriverFactory.getWebDriver().findElement(By.xpath(XPATH_MSG_SUCESSO));

	}

	public void setMsgSucesso(String values) {
		getMsgSucesso().sendKeys(values);

	}

	public WebElement getMsgSemSucesso() {
		return DriverFactory.getWebDriver().findElement(By.xpath(XPATH_MSG_SEM_SUCESSO));

	}

	public void setMsgSemSucesso(String values) {
		getMsgSemSucesso().sendKeys(values);

	}

	public boolean movimentacaoAdicionadaComSucesso() throws MalformedURLException, IOException {

		boolean msg = true;
		boolean falso = false;

		try {
			DriverFactory.getWebDriver().findElement(By.xpath(XPATH_MSG_SUCESSO));
			Evidencia.tirarPrint("Movimentação adicionada com sucesso!");
			msg = true;
		} catch (Exception e) {

			DriverFactory.getWebDriver().findElement(By.xpath(XPATH_MSG_SEM_SUCESSO));
			Evidencia.tirarPrint("Não foi possivel realizar a movimentação!");
			falso = false;
		}

		return msg;
	}

}
