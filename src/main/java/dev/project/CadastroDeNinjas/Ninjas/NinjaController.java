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
    public String criarNinja(){
       return "Ninja Criado";
    }

   //Procurar Ninja por ID
   @GetMapping("/buscar/{id}")
   public NinjaModel mostrarTodosNinjasPorId(@PathVariable long id) {
       return (NinjaModel) ninjaService.buscarId(id);
   }

   //Alterar dados dos ninjas
    @PutMapping("/alterarId")
    public String alterarNinjaPorId() {
        return "Alterando Ninjas Ninjas";
    }


   //Deletar Ninja
    @DeleteMapping("/deletarid")
       public String deletaNinjaPorId() {
           return "Alterando Ninjas Ninjas";
       }



   //Mostrar todos os ninjas

   @GetMapping("/listar")
   public List<NinjaModel> mostrarTodosNinjas() {
      return ninjaService.listar();
   }
 }


