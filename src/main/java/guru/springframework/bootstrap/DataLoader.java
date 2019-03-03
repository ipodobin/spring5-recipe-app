package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public DataLoader(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadRecipes();
    }

    private void loadRecipes() {
        log.debug("Loading initial recipes:");
        Category mexicanCategory = categoryRepository.findByDescription("Mexican").orElse(null);
        UnitOfMeasure piece = unitOfMeasureRepository.findByDescription("Piece").orElse(null);
        UnitOfMeasure teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon").orElse(null);
        UnitOfMeasure tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon").orElse(null);
        UnitOfMeasure clove = unitOfMeasureRepository.findByDescription("Clove").orElse(null);
        UnitOfMeasure cup = unitOfMeasureRepository.findByDescription("Cup").orElse(null);
        UnitOfMeasure pint = unitOfMeasureRepository.findByDescription("Pint").orElse(null);

        // Perfect Guacamole
        log.debug("- Perfect Guacamole");
        Recipe recipe1 = new Recipe();
        recipe1.setDescription("Perfect Guacamole");
        recipe1.setDifficulty(Difficulty.EASY);
        recipe1.setCookTime(0);
        recipe1.setPrepTime(15);
        recipe1.setSource("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        Notes notes1 = new Notes();
        notes1.setRecipeNotes("<p><b>1 Cut avocado, remove flesh:</b> Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. Place in a bowl.</p>" +
                "<p><b>2 Mash with a fork:</b>&nbsp;Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)</p>" +
                "<p><strong>3 Add salt, lime juice, and the rest:</strong>&nbsp;Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.</p>" +
                "<p>Add the chopped onion, cilantro, black pepper, and chiles.&nbsp;Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.</p>" +
                "<p>Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.</p>" +
                "<p><b>4 Cover with plastic and chill to store:</b>&nbsp;Place&nbsp;plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole&nbsp;brown.) Refrigerate until ready to serve.</p>" +
                "<p>Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.</p>" +
                "<p><b>Variations</b></p>" +
                "<p>For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.</p>" +
                "<p>Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added&nbsp;pineapple, mango, or strawberries.</p>" +
                "<p>The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.</p>" +
                "<p>To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.</p>");
        recipe1.setNotes(notes1);
        recipe1.getCategories().add(mexicanCategory);
        Ingredient ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(2));
        ingredient.setUom(piece);
        ingredient.setDescription("ripe avocado");
        recipe1.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(0.5));
        ingredient.setUom(teaspoon);
        ingredient.setDescription("kosher salt");
        recipe1.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(1));
        ingredient.setUom(tablespoon);
        ingredient.setDescription("fresh lime juice or lemon juice");
        recipe1.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(2));
        ingredient.setUom(tablespoon);
        ingredient.setDescription("minced red onion or thinly sliced green onion");
        recipe1.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(2));
        ingredient.setUom(piece);
        ingredient.setDescription("serrano chiles, stems and seeds removed, minced");
        recipe1.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(2));
        ingredient.setUom(tablespoon);
        ingredient.setDescription("cilantro (leaves and tender stems), finely chopped");
        recipe1.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(1));
        ingredient.setUom(piece);
        ingredient.setDescription("dash of freshly grated black pepper");
        recipe1.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(0.5));
        ingredient.setUom(piece);
        ingredient.setDescription("ripe tomato, seeds and pulp removed, chopped");
        recipe1.addIngredient(ingredient);
        recipe1 = recipeRepository.save(recipe1);


        // Spicy Grilled Chicken Tacos
        log.debug("- Spicy Grilled Chicken Tacos");
        Recipe recipe2 = new Recipe();
        recipe2.setDescription("Spicy Grilled Chicken Tacos");
        recipe2.setDifficulty(Difficulty.MODERATE);
        recipe2.setCookTime(15);
        recipe2.setPrepTime(30);
        recipe2.setSource("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        Notes notes2 = new Notes();
        notes2.setRecipeNotes("<div><p><strong>1 Prepare a gas or charcoal grill for medium-high, direct heat.</strong></p>" +
                "<p><strong>2 Make the marinade and coat the chicken:</strong> In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.</p>" +
                "<p>Set aside to marinate while the grill heats and you prepare the rest of the toppings.</p>" +
                "<p><strong>3 Grill the chicken: </strong>Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.</p>" +
                "<p><strong>4</strong> <strong>Warm the tortillas</strong>: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.</p>" +
                "<p>Wrap warmed tortillas in a tea towel to keep them warm until serving.</p>" +
                "<p><strong>5 Assemble the tacos:</strong> Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.</p>");
        recipe2.setNotes(notes2);
        recipe2.getCategories().add(mexicanCategory);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(2));
        ingredient.setUom(tablespoon);
        ingredient.setDescription("ancho chili powder");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(1));
        ingredient.setUom(teaspoon);
        ingredient.setDescription("dried oregano");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(1));
        ingredient.setUom(teaspoon);
        ingredient.setDescription("dried cumin");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(1));
        ingredient.setUom(teaspoon);
        ingredient.setDescription("sugar");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(0.5));
        ingredient.setUom(teaspoon);
        ingredient.setDescription("salt");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(1));
        ingredient.setUom(clove);
        ingredient.setDescription("garlic, finely chopped");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(1));
        ingredient.setUom(tablespoon);
        ingredient.setDescription("finely grated orange zest");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(3));
        ingredient.setUom(tablespoon);
        ingredient.setDescription("resh-squeezed orange juice");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(2));
        ingredient.setUom(tablespoon);
        ingredient.setDescription("olive oil");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(6));
        ingredient.setUom(piece);
        ingredient.setDescription("skinless, boneless chicken thighs (1 1/4 pounds)");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(8));
        ingredient.setUom(piece);
        ingredient.setDescription("small corn tortillas");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(3));
        ingredient.setUom(cup);
        ingredient.setDescription("packed baby arugula (3 ounces)");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(2));
        ingredient.setUom(piece);
        ingredient.setDescription("medium ripe avocados, sliced");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(4));
        ingredient.setUom(piece);
        ingredient.setDescription("radishes, thinly sliced");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(0.5));
        ingredient.setUom(pint);
        ingredient.setDescription("cherry tomatoes, halved");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(0.25));
        ingredient.setUom(piece);
        ingredient.setDescription("red onion, thinly sliced");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(1));
        ingredient.setUom(piece);
        ingredient.setDescription("Roughly chopped cilantro");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(0.5));
        ingredient.setUom(cup);
        ingredient.setDescription("sour cream");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(0.25));
        ingredient.setUom(cup);
        ingredient.setDescription("milk");
        recipe2.addIngredient(ingredient);
        ingredient = new Ingredient();
        ingredient.setAmount(BigDecimal.valueOf(1));
        ingredient.setUom(piece);
        ingredient.setDescription("lime, cut into wedges");
        recipe2.addIngredient(ingredient);
        recipe2 = recipeRepository.save(recipe2);
    }
}
