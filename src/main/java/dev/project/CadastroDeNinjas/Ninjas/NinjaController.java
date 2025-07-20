package dev.project.CadastroDeNinjas.Ninjas;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
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
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
      return ninjaService.criaNinja(ninja);
    }

   //Procurar Ninja por ID
   @GetMapping("/listar/{id}")
   public NinjaModel mostrarTodosNinjasPorId(@PathVariable long id) {
       return (NinjaModel) ninjaService.buscarId(id);
   }

   //Alterar dados dos ninjas
   @PutMapping("/atualizar/{id}")
    public NinjaModel alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaModel body) {
        return ninjaService.alterarNinjaId(id,body);
    }


   //Deletar Ninja
    @DeleteMapping("/deletar/{id}")
       public void deletaNinjaPorId(@PathVariable long id) {
       ninjaService.deletaNinjaId(id);
       }



   //Mostrar todos os ninjas

   @GetMapping("/listar")
   public List<NinjaModel> mostrarTodosNinjas() {
      return ninjaService.listar();
   }
 }


