package com.Malshika.controller;

import com.Malshika.model.Recipe;
import com.Malshika.model.User;
import com.Malshika.service.RecipeService;
import com.Malshika.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @PostMapping("/user/{userId}")
    public Recipe createRecipe(@RequestBody Recipe recipe, @PathVariable Long userId) throws Exception {

        User user =userService.findUserById(userId);

        Recipe createdRecipe=recipeService.createRecipe(recipe,user);
        return createdRecipe;
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe,
                               @PathVariable Long id) throws Exception {


        Recipe updateRecipe=recipeService.updateRecipe(recipe,id);
        return updateRecipe;
    }

    @GetMapping()
    public List<Recipe> getAllRecipe() throws Exception {

        List<Recipe> recipes=recipeService.findAllRecipe();
        return recipes;
    }

    @DeleteMapping("/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) throws Exception {

        recipeService.deleteRecipe(recipeId);
        return "recipe deleted successfully";
    }

    @PutMapping("/{id}/like/user/{userId}")
    public Recipe likeRecipe(@PathVariable Long userId,
                               @PathVariable Long id) throws Exception {

        User user =userService.findUserById(userId);

        Recipe updateRecipe=recipeService.likeRecipe(id,user);
        return updateRecipe;
    }
}
