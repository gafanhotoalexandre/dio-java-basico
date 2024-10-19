import br.com.dio.bootcamp.dominio.Bootcamp;
import br.com.dio.bootcamp.dominio.Curso;
import br.com.dio.bootcamp.dominio.Dev;
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

        /*System.out.println(c1);
        System.out.println(c2);
        System.out.println(mJava);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição do Bootcamp Java Developer");
        bootcamp.getConteudos().add(c1);
        bootcamp.getConteudos().add(c2);
        bootcamp.getConteudos().add(mJava);

        Dev devMarcos = new Dev();
        devMarcos.setNome("Marcos");
        devMarcos.inscreverBootcamp(bootcamp);
        System.out.println("=== Conteúdos Inscritos de " + devMarcos.getNome() + " ===");
        System.out.println(devMarcos.getConteudosInscritos());

        devMarcos.progredir();
        System.out.println("Conteúdos Inscritos Restantes: " + devMarcos.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos: " + devMarcos.getConteudosConcluidos());
        System.out.println("XP: " + devMarcos.calcularTotalXp());

        Dev devDias = new Dev();
        devDias.setNome("Dias");
        devDias.inscreverBootcamp(bootcamp);
        System.out.println("=== Conteúdos Inscritos de " + devDias.getNome() + " ===");
        System.out.println(devDias.getConteudosInscritos());

        devDias.progredir();
        devDias.progredir();
        devDias.progredir();
        System.out.println("Conteúdos Inscritos Restantes: " + devDias.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos: " + devDias.getConteudosConcluidos());
        System.out.println("XP: " + devDias.calcularTotalXp());
    }
}