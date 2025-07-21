package dev.project.CadastroDeNinjas.Ninjas;

import dev.project.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "nome")
    private String nome;


    @Column(unique = true , name = "email")
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade")
    private int idade;

    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing Key
    private MissoesModel missoes;

    @JoinColumn(name ="rank")
    private String rank;

}
