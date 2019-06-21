package utils.evidencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import exceptions.ExceptionUtils;
import readers.Config;
import utils.WebDriverFactory;

public class Evidencia {

	private static WebDriverFactory driver = new WebDriverFactory();

	private static Document document;
	private static String nomeCT;
	private static String nomeEvidencia;
	private static String caminho;

	public Evidencia(String testName) throws MalformedURLException, IOException {
		document = new Document();
		nomeCT = testName;
		renomearEvidencia(Config.getProperty("path.evidencia"));
		document.open();
		gerarCapa();
	}

	public static void gerarCapa() throws MalformedURLException, IOException {

		try {
			Image logo = Image.getInstance(Config.getProperty("path.imagem.lobo"));
			logo.setAlignment(Element.ALIGN_CENTER);
			document.add(logo);
			addFormatedText("Automação Seu Barriga", FontFactory.HELVETICA, 20, Font.BOLDITALIC, BaseColor.BLUE, 20, 20,
					Element.ALIGN_CENTER);
			Image image = Image.getInstance(Config.getProperty("path.imagem.seu.barriga"));
			image.scalePercent(50, 50);
			image.setAlignment(Element.ALIGN_CENTER);
			document.add(image);
			addFormatedText("Evidência de Teste", FontFactory.HELVETICA, 20, Font.BOLDITALIC, BaseColor.BLUE, 20, 20,
					Element.ALIGN_CENTER);
			String data = inserirDataHora();
			addFormatedText("Data e Hora: " + data, FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.BLACK, 180, 20,
					Element.ALIGN_LEFT);
			addFormatedText("Metodologia: Go Horse", FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.BLACK, 0, 20,
					Element.ALIGN_LEFT);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {

			e.printStackTrace();
		}

	}

	public static String inserirDataHora() {

		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String data = date.format(formatado);
		return data;
	}

	public static void inserirPrint() throws MalformedURLException, IOException {

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver.getWebDriver();
		byte[] imagem = takesScreenshot.getScreenshotAs(OutputType.BYTES);

		try {
			Image image = Image.getInstance(imagem);
			image.scaleToFit(520f, 520f);
			document.add(image);
		} catch (Exception e) {
			ExceptionUtils.throwException(e);
		}
	}

	public static void inserirPrint(WebElement... elementos) throws MalformedURLException, IOException {

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver.getWebDriver();
		marcarElemento(elementos);
		byte[] imagem = takesScreenshot.getScreenshotAs(OutputType.BYTES);

		try {
			Image image = Image.getInstance(imagem);
			image.scaleToFit(520f, 520f);
			document.add(image);
		} catch (Exception e) {
			ExceptionUtils.throwException(e);
		}
	}

	public static void addText(String text) {
		try {
			document.add(new Paragraph(text));
		} catch (Exception exception) {
			ExceptionUtils.throwException(exception);
		}
	}

	public static void addFormatedText(String text, String name, int style, BaseColor color) {
		addFormatedText(text, name, 12, style, color, 0, 0, 0);
	}

	public static void addFormatedText(String text, String name, float size, int style, BaseColor color,
			int spaceBefore, int spaceAfter, int align) {
		try {
			Font font = FontFactory.getFont(name, size, style, color);
			Paragraph paragraph = new Paragraph(text, font);
			paragraph.setSpacingBefore(spaceBefore);
			paragraph.setSpacingAfter(spaceAfter);
			paragraph.setAlignment(align);
			document.add(paragraph);
		} catch (Exception exception) {
			ExceptionUtils.throwException(exception);
		}
	}

	public static void addNewPage() {
		document.newPage();
	}

	public static void fecharDocumento() {
		document.close();
	}

	public static void tirarPrint(String text) throws MalformedURLException, IOException {
		addNewPage();
		inserirPrint();
		addFormatedText(text, FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.BLACK, 10, 40, Element.ALIGN_LEFT);
	}

	public static void tirarPrint(String text, WebElement... elementos) throws MalformedURLException, IOException {
		addNewPage();
		inserirPrint(elementos);
		addFormatedText(text, FontFactory.HELVETICA, 12, Font.BOLD, BaseColor.BLACK, 10, 40, Element.ALIGN_LEFT);
	}

	public static void marcarElemento(WebElement... elementos) {

		List<String> style = new ArrayList<String>();

		JavascriptExecutor js = (JavascriptExecutor) driver.getWebDriver();
		for (WebElement elemento : elementos) {
			style.add(elemento.getCssValue("border").toString());
			js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid Darkgreen;');", elemento);
		}
	}

	public static String formataData(String data, String pattern) {

		if (data.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {

			String ano = data.substring(0, 4);
			String mes = data.substring(5, 7);
			String dia = data.substring(8, 10);

			return dia + "/" + mes + "/" + ano;
		}

		return data;
	}

	public static void renomearEvidencia(String path) {

		String date = LocalDate.now().toString();
		String time = LocalTime.now().toString();

		date = formataData(date, "").replace("/", ".");
		String hora = time.substring(0, 2);
		String minutos = time.substring(3, 5);
		String segundos = time.substring(6, 8);

		time = hora + "h" + minutos + "m" + segundos + "s";

		File diretorio = new File(path);
		if (!diretorio.exists()) {
			diretorio.mkdirs();
		}

		setNomeEvidencia(
				"ProjetoSeuBarriga_" + Evidencia.getNomeCt() + "_" + date + "_" + time + " - " + "Evidencia.pdf");
		setCaminho(path);
		try {
			PdfWriter.getInstance(Evidencia.getDocument(),
					new FileOutputStream(Evidencia.getCaminho() + Evidencia.getNome()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public static void setNomeEvidencia(String nomeEvidencia) {
		Evidencia.nomeEvidencia = nomeEvidencia;
	}

	public static void setCaminho(String caminho) {
		Evidencia.caminho = caminho;
	}

	public static Document getDocument() {
		return document;
	}

	public static String getNome() {
		return nomeEvidencia;
	}

	public static String getCaminho() {
		return caminho;
	}

	public static String getNomeCt() {
		return nomeCT;
	}

}
