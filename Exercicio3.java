import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Exercicio3 {
    public static void main(String[] args) {
        try {
            File file = new File("dados.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("row");

            double menor = Double.MAX_VALUE;
            double maior = Double.MIN_VALUE;
            double soma = 0;
            int diasComFaturamento = 0;

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                double valor = Double.parseDouble(element.getElementsByTagName("valor").item(0).getTextContent());

                if (valor > 0) {
                    soma += valor;
                    diasComFaturamento++;
                    if (valor < menor) menor = valor;
                    if (valor > maior) maior = valor;
                }
            }

            double media = soma / diasComFaturamento;
            int diasAcimaDaMedia = 0;

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                double valor = Double.parseDouble(element.getElementsByTagName("valor").item(0).getTextContent());

                if (valor > media) {
                    diasAcimaDaMedia++;
                }
            }

            System.out.printf("Menor valor de faturamento: %.2f\n", menor);
            System.out.printf("Maior valor de faturamento: %.2f\n", maior);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
    }
}
