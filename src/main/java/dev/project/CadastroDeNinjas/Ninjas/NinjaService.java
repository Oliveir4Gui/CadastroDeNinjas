package dev.project.CadastroDeNinjas.Ninjas;
import dev.project.CadastroDeNinjas.Ninjas.NinjaMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    @Autowired
    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar Todos os Ninjas
    public List<NinjaModel> listar(){
         return ninjaRepository.findAll();
    }

    public NinjaModel buscarId( Long id){
       Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
       return ninjaModel.orElse(null);
    }

    public NinjaDTO criaNinja(NinjaDTO ninjaDTO){
     NinjaModel ninja = new NinjaMapper().map(ninjaDTO);
     ninja = ninjaRepository.save(ninja);
     return ninjaMapper.map(ninja);
    }

    public void deletaNinjaId(Long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaModel alterarNinjaId(Long id, NinjaModel atualizado){
       if(ninjaRepository.existsById(id)){
       atualizado.setId(id);
       return ninjaRepository.save(atualizado);
       }else {
           return null;
       }

    }


}
