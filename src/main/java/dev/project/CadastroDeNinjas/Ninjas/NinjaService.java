package dev.project.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar Todos os Ninjas
    public List<NinjaModel> listar(){
         return ninjaRepository.findAll();
    }

    public NinjaModel buscarId( Long id){
       Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
       return ninjaModel.orElse(null);
    }

    public NinjaModel criaNinja(NinjaModel ninjaModel){
        return ninjaRepository.save(ninjaModel);
    }

    public void deletaNinjaId(Long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaModel alterarNinjaId()


}
