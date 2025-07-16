package dev.project.CadastroDeNinjas.Missoes;


import dev.project.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    @OneToMany(mappedBy = "missoes")
    private NinjaModel ninja;

    public MissoesModel() {
    }

    public MissoesModel(String nome, String dificuldade, NinjaModel ninja) {
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.ninja = ninja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public NinjaModel getNinja() {
        return ninja;
    }

    public void setNinja(NinjaModel ninja) {
        this.ninja = ninja;
    }

    @Override
    public String toString() {
        return "MissoesModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dificuldade='" + dificuldade + '\'' +
                ", ninja=" + ninja +
                '}';
    }
}
