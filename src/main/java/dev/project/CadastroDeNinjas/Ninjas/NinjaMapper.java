package dev.project.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public NinjaModel map(NinjaDTO ninjaDTO){
     NinjaModel ninjaModel = new NinjaModel();
     ninjaModel.setId(ninjaDTO.getId());
     ninjaModel.setNome(ninjaDTO.getNome());
     ninjaModel.setEmail(ninjaDTO.getEmail());
     ninjaModel.setIdade(ninjaDTO.getIdade());
     ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
     ninjaModel.setRank(ninjaDTO.getRank());
     ninjaModel.setMissoes(ninjaDTO.getMissoes());

     return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel){

       NinjaDTO ninjaDTO = new NinjaDTO();
       ninjaDTO.setNome(ninjaModel.getNome());
       ninjaDTO.setId(ninjaModel.getId());
       ninjaDTO.setRank(ninjaModel.getRank());
       ninjaDTO.setEmail(ninjaModel.getEmail());
       ninjaDTO.setImgUrl(ninjaModel.getImgUrl());
       ninjaDTO.setIdade(ninjaModel.getIdade());
       ninjaDTO.setMissoes(ninjaModel.getMissoes());

       return ninjaDTO;

    }
}
