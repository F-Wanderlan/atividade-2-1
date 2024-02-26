import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GravadorXML implements GravadorAluno {
    private static final String ARQUIVO_XML = "alunos.xml";

    @Override
    public void salvar(Aluno aluno) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_XML, true))) {
            // Abre o arquivo XML e escreve as informações do aluno
            writer.write("<aluno>");
            writer.newLine();
            writer.write("    <nome>" + aluno.getNome() + "</nome>");
            writer.newLine();
            writer.write("    <matricula>" + aluno.getMatricula() + "</matricula>");
            writer.newLine();
            writer.write("</aluno>");
            writer.newLine();
            System.out.println("Aluno salvo");
        } catch (IOException e) {
            e.printStackTrace(); // ou trate de outra maneira, dependendo dos requisitos
        }
    }


    @Override
    public List<Aluno> recuperarAlunos() {
        List<Aluno> alunos = new ArrayList<>();

        try {
            // Cria um parser de documentos XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Faz o parsing do arquivo XML
            Document document = builder.parse(new File(ARQUIVO_XML));

            // Obtém a lista de elementos <aluno>
            NodeList alunoNodes = document.getElementsByTagName("aluno");

            // Itera sobre os elementos <aluno>
            for (int i = 0; i < alunoNodes.getLength(); i++) {
                Node alunoNode = alunoNodes.item(i);

                if (alunoNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element alunoElement = (Element) alunoNode;

                    // Obtém os elementos de nome e matrícula do aluno
                    String nome = alunoElement.getElementsByTagName("nome").item(0).getTextContent();
                    String matricula = alunoElement.getElementsByTagName("matricula").item(0).getTextContent();

                    // Cria um objeto Aluno e adiciona à lista
                    Aluno aluno = new Aluno(nome, matricula);
                    alunos.add(aluno);
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); // ou trate de outra maneira, dependendo dos requisitos
        }

        return alunos;
    }
}
