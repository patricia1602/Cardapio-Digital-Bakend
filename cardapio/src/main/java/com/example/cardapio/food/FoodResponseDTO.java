package com.example.cardapio.food;

public record FoodResponseDTO( // Essa classe declara as propriedades //
        Long id,
        String title,
        String image,
        Integer price) {

    public FoodResponseDTO(Food food) {
        this(food.getId(),
                food.getTitle(),
                food.getImage(),
                food.getPrice());
    }

}
