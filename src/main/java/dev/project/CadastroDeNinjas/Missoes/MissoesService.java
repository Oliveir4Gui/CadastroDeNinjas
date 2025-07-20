package dev.project.CadastroDeNinjas.Missoes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {
    @Autowired
    private MissoesRepository missoesRepository;

    public List<MissoesModel>mostrarMissoes(){
        return missoesRepository.findAll();
    }

    public  MissoesModel criaMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    public void deletaMissaoId(Long id){
        missoesRepository.deleteById(id);
    }
    public MissoesModel listarMissaoId(Long id){
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        return missao.orElse(null);
    }

    public MissoesModel alteraMissaoId(Long id, MissoesModel missao){
        if (missoesRepository.existsById(id)){
            missao.setId(id);
          return  missoesRepository.save(missao);
        }
        return null;
    }
}
