# pokeApi
Desafio looqbox

# Docker: 
docker pull guikirsch/pokeapi:1.0.0

# Deploy na amazon:
Endpoint na AWS: http://Servi-ALB01-1CWZQHQSQ5D1X-477711719.us-east-1.elb.amazonaws.com

## :hammer: endpoints do projeto

### * [**GET /pokemons**](#): http://localhost:8090/pokemons

Required paramns: Name (String)
Optional paramns: limit (Long), order (String) 

Parametros da url:
| Nome | Descrição |
|---|---|
| `Name` | Busca nome do pokemon que contenha os caracteres inseridos |
| `Limit` | Limit: Limita a quatidade de resultados trazidos, defalt value = 20 |
| `Order` | ordena a pesquisa trazida em ordem alfabetica, values: "crescent" e "descending", defalt value = "crescent" |

#### Exemplo: 

  http://localhost:8090/pokemons?name=bu
  
  + Response 200 (application/json)
  
     + Body

```json
          {
          "result": [
            {
              "name": "butterfree"
            },
            {
              "name": "bulbasaur"
            }
          ]
        }
   ```
  
#
###  * [**GET /pokemons/highlight**](#): http://localhost:8090/pokemons/highlight

Required paramns: Name (String)
Optional paramns: limit (Long), order (String) 

Parametros da url:
| Nome | Descrição |
|---|---|
| `Name` | Busca nome do pokemon que contenha os caracteres inseridos |
| `Limit` | Limit: Limita a quatidade de resultados trazidos, defalt value = 20 |
| `Order` | ordena pelo tamanho do nome do pokemon, values: "" e "length", "length": ordena pelo tamanho do nome em ordem decrescente, "": ordena pelo  ordena pelo tamanho do nome em ordem crescente ,defalt value = "" |

#### Exemplo: 

  http://localhost:8090/pokemons/highlight?name=a
  
   + Response 200 (application/json)
  
     + Body
```json
 {
  "result": [
    {
      "name": "kakuna",
      "highlight": "k<pre>a<pre>kun<pre>a<pre>"
    },
    {
      "name": "ivysaur",
      "highlight": "ivys<pre>a<pre>ur"
    },
    {
      "name": "metapod",
      "highlight": "met<pre>a<pre>pod"
    },
    {
      "name": "rattata",
      "highlight": "r<pre>a<pre>tt<pre>a<pre>t<pre>a<pre>"
    },
    {
      "name": "venusaur",
      "highlight": "venus<pre>a<pre>ur"
    },
    {
      "name": "caterpie",
      "highlight": "c<pre>a<pre>terpie"
    },
    {
      "name": "raticate",
      "highlight": "r<pre>a<pre>tic<pre>a<pre>te"
    },
    {
      "name": "bulbasaur",
      "highlight": "bulb<pre>a<pre>s<pre>a<pre>ur"
    },
    {
      "name": "charizard",
      "highlight": "ch<pre>a<pre>riz<pre>a<pre>rd"
    },
    {
      "name": "wartortle",
      "highlight": "w<pre>a<pre>rtortle"
    },
    {
      "name": "blastoise",
      "highlight": "bl<pre>a<pre>stoise"
    },
    {
      "name": "charmander",
      "highlight": "ch<pre>a<pre>rm<pre>a<pre>nder"
    },
    {
      "name": "charmeleon",
      "highlight": "ch<pre>a<pre>rmeleon"
    }
  ]
}

```
#
 http://localhost:8090/pokemons/highlight?name=a&order=length
  
   + Response 200 (application/json)
  
     + Body


```json
{
  "result": [
    {
      "name": "charmander",
      "highlight": "ch<pre>a<pre>rm<pre>a<pre>nder"
    },
    {
      "name": "charmeleon",
      "highlight": "ch<pre>a<pre>rmeleon"
    },
    {
      "name": "bulbasaur",
      "highlight": "bulb<pre>a<pre>s<pre>a<pre>ur"
    },
    {
      "name": "charizard",
      "highlight": "ch<pre>a<pre>riz<pre>a<pre>rd"
    },
    {
      "name": "wartortle",
      "highlight": "w<pre>a<pre>rtortle"
    },
    {
      "name": "blastoise",
      "highlight": "bl<pre>a<pre>stoise"
    },
    {
      "name": "venusaur",
      "highlight": "venus<pre>a<pre>ur"
    },
    {
      "name": "caterpie",
      "highlight": "c<pre>a<pre>terpie"
    },
    {
      "name": "raticate",
      "highlight": "r<pre>a<pre>tic<pre>a<pre>te"
    },
    {
      "name": "ivysaur",
      "highlight": "ivys<pre>a<pre>ur"
    },
    {
      "name": "metapod",
      "highlight": "met<pre>a<pre>pod"
    },
    {
      "name": "rattata",
      "highlight": "r<pre>a<pre>tt<pre>a<pre>t<pre>a<pre>"
    },
    {
      "name": "kakuna",
      "highlight": "k<pre>a<pre>kun<pre>a<pre>"
    }
  ]
}

```
  
