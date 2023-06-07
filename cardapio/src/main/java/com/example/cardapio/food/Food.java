package com.example.cardapio.food;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "food") // Nome da tabela //
@Entity(name = "food") // Nome da entidade //
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    @Id // A chave que indica cada uma das unidades //
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera a chave automaticamente //
    private Long id;
    private String title; // título //
    private String image; // imagem //
    private Integer price; // preço //

    public Food(FoodRequestDTO data) {
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();
    }
}
