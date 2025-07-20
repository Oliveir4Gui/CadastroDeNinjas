package dev.project.CadastroDeNinjas.Missoes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {
    @Autowired
    private MissoesService missoesService;

    @GetMapping("/listar")
    public List<MissoesModel> listar(){
        return missoesService.mostrarMissoes();
    }

    @PostMapping("/criar")
    public MissoesModel criaMissao(@RequestBody MissoesModel missao){
       return missoesService.criaMissao(missao);
    }

    @DeleteMapping("/excluir/{id}")
    public void deletaNinjaId(@PathVariable long id){
        missoesService.deletaMissaoId(id);
    }

    @PutMapping("/alterar/{id}")
    public MissoesModel alteraMissao(@PathVariable long id , @RequestBody MissoesModel missao){
        return missoesService.alteraMissaoId(id,missao);
    }

}
