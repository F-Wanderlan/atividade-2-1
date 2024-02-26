import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GravadorCSV implements GravadorAluno {

    private static final String NOME_ARQUIVO = "alunos.csv";

    @Override
    public void salvar(Aluno aluno) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
            // Se o arquivo não existir, cria o cabeçalho
            if (!arquivoExiste()) {
                writer.write("Nome,Idade,Matricula\n");
            }

            // Escreve os dados do aluno no arquivo
            writer.write(aluno.getNome() + "," + aluno.getMatricula() + "\n");

            System.out.println("Aluno salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o aluno: " + e.getMessage());
        }
    }

    @Override
    public List<Aluno> recuperarAlunos() {
        List<Aluno> alunos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            // Ignora a primeira linha (cabeçalho)
            reader.readLine();

            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 2) {
                    String nome = dados[0];
                    String matricula = dados[1];
                    Aluno aluno = new Aluno(nome, matricula);
                    alunos.add(aluno);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao recuperar alunos: " + e.getMessage());
        }

        return alunos;
    }
    private boolean arquivoExiste() {
        // Verifica se o arquivo já existe
        return new java.io.File(NOME_ARQUIVO).exists();
    }
}