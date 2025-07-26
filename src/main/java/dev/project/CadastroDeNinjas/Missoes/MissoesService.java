package dev.project.CadastroDeNinjas.Missoes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    @Autowired
    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDTO>mostrarMissoes(){
        List<MissoesModel> missoesModels = missoesRepository.findAll();
        return missoesModels.stream().map(missoesMapper::toDto)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarMissaoId(long id){
        Optional<MissoesModel> missoesModel =missoesRepository.findById(id);
       return missoesModel.map(missoesMapper::toDto).orElse(null);
    }

    public  MissoesDTO criaMissao(MissoesDTO missao){
        MissoesModel missoesModel = missoesMapper.toModel(missao);
        missoesRepository.save(missoesModel);
        return missoesMapper.toDto(missoesModel);
    }

    public void deletaMissaoId(Long id){
        missoesRepository.deleteById(id);
    }
    public MissoesModel listarMissaoId(Long id){
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        return missao.orElse(null);
    }

    public MissoesDTO alteraMissaoId(Long id, MissoesDTO missao){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        if (missoesModel.isPresent()){
            missao.setId(id);
            MissoesModel missaoAtualizada = missoesMapper.toModel(missao);
            missoesRepository.save(missaoAtualizada);
            return missoesMapper.toDto(missaoAtualizada);
        }
        return null;
    }
}
