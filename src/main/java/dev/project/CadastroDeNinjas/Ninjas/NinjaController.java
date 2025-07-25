package dev.project.CadastroDeNinjas.Ninjas;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")

public class NinjaController {
    @Autowired
    private NinjaService ninjaService;

   @GetMapping("/boasvindas")
   public String boasVindas(){
       return "Esta e minha primeira mensagem";
   }

   //Adicionar Ninja
    @PostMapping("/criar")
    public ResponseEntity criarNinja(@RequestBody NinjaDTO ninjaDTO){
       NinjaDTO ninjaDto = ninjaService.criaNinja(ninjaDTO);
      return ResponseEntity.status(HttpStatus.CREATED)
               .body("Ninja Criado com Sucesso: " + ninjaDto.getNome() + " ID: " + ninjaDto.getId());
    }

   //Procurar Ninja por ID
   @GetMapping("/listar/{id}")
   public ResponseEntity<?> mostrarTodosNinjasPorId(@PathVariable long id) {
       NinjaDTO ninjaDTO = ninjaService.buscarId(id);
       if (ninjaDTO!=null){
           return ResponseEntity.ok(ninjaDTO);
       }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID nao encontrado");
       }
   }

   //Alterar dados dos ninjas
   @PutMapping("/alterar/{id}")
    public ResponseEntity alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO body) {
       if(ninjaService.buscarId(id)!=null) {
           NinjaDTO ninjaDTO = ninjaService.alterarNinjaId(id, body);
           return ResponseEntity.ok("Ninja alterado com sucesso");
       }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao Encontrado");
       }
    }


   //Deletar Ninja
    @DeleteMapping("/deletar/{id}")
       public ResponseEntity<String> deletaNinjaPorId(@PathVariable long id) {
       if (ninjaService.buscarId(id)!= null){
           ninjaService.deletaNinjaId(id);
           return ResponseEntity.ok("Deletado com Sucesso id: " + id);
       }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Nao Encontrado");
       }

       }



   //Mostrar todos os ninjas

   @GetMapping("/listar")
   public ResponseEntity<List<NinjaDTO>> mostrarTodosNinjas() {
      List<NinjaDTO>ninjaDTOS =  ninjaService.listar();
      return ResponseEntity.ok()
              .body(ninjaDTOS);
   }
 }


