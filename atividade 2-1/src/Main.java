import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SCA a = new SCA();
        while(true){
            System.out.println("1- Gravar aluno? \n2- Recuperar Aluno\n \n -------------------- \n \n");
            String entrada = input.nextLine();
            if(entrada.equals("1")){
                Aluno aluno = a.receberEntradaUsuario();
                System.out.println("Que formato você quer gravar?\n1- CSV \n2- XML \n3-JSON");
                String entrada1 = input.nextLine();
                if(entrada1.equals("1")){
                    GravadorCSV csv = new GravadorCSV();
                    a.gravador.salvar(aluno);
                }
                if(entrada1.equals("2")){
                    GravadorXML xml = new GravadorXML();
                    a.setGravador(xml);
                    a.gravador.salvar(aluno);
                }
            }
            if(entrada.equals("2")){
                System.out.println("Que formato você quer ler?\n1- CSV \n2- XML \n3-JSON");
                entrada = input.nextLine();
                if(entrada.equals("1")){
                    List<Aluno> alunos = a.gravador.recuperarAlunos();

                    System.out.println("Lista de Alunos:");
                    for (Aluno aluno : alunos) {
                        System.out.println("Nome: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());
                    }
                }
                if(entrada.equals("2")){
                    List<Aluno> alunos = a.gravador.recuperarAlunos();

                    System.out.println("Lista de Alunos:");
                    for (Aluno aluno : alunos) {
                        System.out.println("Nome: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());
                    }
                }
            }

        }


    }
}