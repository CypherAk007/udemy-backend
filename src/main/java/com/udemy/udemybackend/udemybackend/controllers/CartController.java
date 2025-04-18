package com.udemy.udemybackend.udemybackend.controllers;

import com.udemy.udemybackend.udemybackend.dtos.CartRequestDTO;
import com.udemy.udemybackend.udemybackend.dtos.CartResponseDTO;
import com.udemy.udemybackend.udemybackend.dtos.ResponseStatus;
import com.udemy.udemybackend.udemybackend.models.Course;
import com.udemy.udemybackend.udemybackend.services.AddToCartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CartController {
    private final AddToCartService addToCartService;

    public CartController(AddToCartService addToCartService) {
        this.addToCartService = addToCartService;
    }

    @PostMapping("/course/{courseId}/addToCart")
    @Tag(name = "Add to Cart", description = "APIs for course Add to Cart!!")
    public ResponseEntity<CartResponseDTO> addToCart(CartRequestDTO requestDTO){
        CartResponseDTO responseDTO = new CartResponseDTO();
        try{
            Course course =addToCartService.addToCart(requestDTO.getUserId(), requestDTO.getCourseId());
            responseDTO.setCourseId(course.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("Course Added to cart Successfully!!");
            return ResponseEntity.ok(responseDTO);
        }catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("Unable to add Course to cart!!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }
    }
}
