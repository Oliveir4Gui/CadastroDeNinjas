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
    public List<MissoesDTO> listar(){
        return missoesService.mostrarMissoes();
    }

    @PostMapping("/criar")
    public MissoesDTO criaMissao(@RequestBody MissoesDTO missao){
       return missoesService.criaMissao(missao);
    }

    @DeleteMapping("/excluir/{id}")
    public void deletaNinjaId(@PathVariable long id){
        missoesService.deletaMissaoId(id);
    }

    @PutMapping("/alterar/{id}")
    public MissoesDTO alteraMissao(@PathVariable long id , @RequestBody MissoesDTO missao){
        return missoesService.alteraMissaoId(id,missao);
    }

}
