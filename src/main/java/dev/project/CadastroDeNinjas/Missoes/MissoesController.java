package dev.project.CadastroDeNinjas.Missoes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity criaMissao(@RequestBody MissoesDTO missao){

       MissoesDTO missaoDTO =  missoesService.criaMissao(missao);
       return ResponseEntity.status(HttpStatus.CREATED)
               .body("Missao: " + missaoDTO.getNome() + " criado com sucesso.");
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> deletaNinjaId(@PathVariable long id){
        if (missoesService.listarMissaoId(id)!= null){
            missoesService.deletaMissaoId(id);
            return ResponseEntity.ok("Ninja Deletado com sucesso.");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao : " + id + "nao existe");
        }

    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alteraMissao(@PathVariable long id , @RequestBody MissoesDTO missao){
        if (missoesService.listarMissaoId(id)!=null){
            missoesService.alteraMissaoId(id,missao);
            return ResponseEntity.ok()
                    .body("Alterado com Sucesso");
        }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao nao encontrada");
        }


    }

}
