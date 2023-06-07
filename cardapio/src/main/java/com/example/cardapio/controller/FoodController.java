package com.example.cardapio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;
import com.example.cardapio.repository.FoodRepository;

@RestController // Essa classe é um controller da aplicação //
@RequestMapping("food") // Mapeando o que vai cair aqui //
public class FoodController {

    @Autowired // Faz a injeção da dependência //
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*") // Verificar a origem da configuração //
    @PostMapping // Envia os dados da requisição //
    public void saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping // Quando este método for chamado //
    public List<FoodResponseDTO> getAll() {

        List<FoodResponseDTO> foodList = repository.findAll()
                .stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
