import java.util.Scanner;

public class SCA {

    GravadorAluno gravador = new GravadorCSV();
    Scanner input = new Scanner(System.in);




    public void setGravador(GravadorAluno gravador){
        this.gravador = gravador;

    }

    public Aluno receberEntradaUsuario(){
        System.out.println("Nome");
        String nome = input.nextLine();
        System.out.println("Matricula");
        String matricula = input.nextLine();
        Aluno aluno = new Aluno(nome,matricula);
        return aluno;

    }




}
