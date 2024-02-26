import java.util.List;

public interface GravadorAluno {

    public void salvar(Aluno aluno);
    public List<Aluno> recuperarAlunos();
}
