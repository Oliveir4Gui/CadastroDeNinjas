package dev.project.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel toModel(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setNinja(missoesDTO.getNinja());
        return missoesModel;
    }

    public MissoesDTO toDto(MissoesModel model){
        MissoesDTO missoesDTO= new MissoesDTO();
        missoesDTO.setId(model.getId());
        missoesDTO.setNome(model.getNome());
        missoesDTO.setDificuldade(model.getDificuldade());
        missoesDTO.setNinja(model.getNinja());
        return missoesDTO;
    }
}
