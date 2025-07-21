package dev.project.CadastroDeNinjas.Ninjas;

import dev.project.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private MissoesModel missoes;
    private String rank;

}
