import br.com.dio.bootcamp.dominio.Curso;
import br.com.dio.bootcamp.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso c1 = new Curso();
        c1.setTitulo("Curso Java");
        c1.setDescricao("Descrição do curso de Java");
        c1.setCargaHoraria(8);

        Curso c2 = new Curso();
        c2.setTitulo("Curso JavaScript");
        c2.setDescricao("Descrição do curso de JavaScript");
        c2.setCargaHoraria(4);

        Mentoria mJava = new Mentoria();
        mJava.setTitulo("Mentoria Java");
        mJava.setDescricao("Descrição da mentoria Java");
        mJava.setData(LocalDate.now());

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(mJava);
    }
}