package app.sec


import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Options
import io.micronaut.http.annotation.Produces

@Controller("/pokemons")
class PokemonController {
    val pokemons: String = """[ {"name":"Pikachu", "img":"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png" , "attack": 25},
        |{"name":"Bulbasor", "img":"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png" , "attack": 30},
        |{"name":"Charizard", "img":"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png" , "attack": 45},
        |{"name":"Mewtwo", "img":"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/150.png" , "attack": 50}  ]""".trimMargin()

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun index(): String {
        return  pokemons
    }

    @Options(value = "/")
    fun optionsForCors() {}
}