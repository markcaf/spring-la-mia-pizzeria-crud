
### Repo
**spring-la-mia-pizzeria-crud**

### Package
-ragionevole-

## Parte 1
### Todo
Dobbiamo realizzare un’applicazione web che ci aiuti a gestire la nostra pizzeria. Abbiamo bisogno di creare la prima pagina (index) dove mostriamo tutte le pizze che prepariamo.

Una pizza e' caratterizzata da:
- nome : string
- descrizione : string : longtext
- prezzo : int

Per l'entita' creare la tripletta di *Entity*, *Repository* e *Service*.

Aggiungere poi un controller di nome *PizzaController* che implementi il metodo index che restituisce una view per mostrare l’elenco delle pizze caricate dal database (possiamo creare una tabella con bootstrap o altro).

Nel caso in cui l'elenco delle pizze sia vuoto mostrare un messaggio che indichi all’utente che non ci sono pizze presenti nella nostra applicazione al momento.

Generare inoltre le rotte necessarie al completamento della *CRUD* (creazione, eliminazione e aggiornamento di una pizza).

Ove possibile sfruttare i *fragment* per il riutilizzo del codice `HTML`

## Parte 2
### Todo
All'interno dello stesso progetto dell'esercizio precedente, aggiungere la seguente entita' e svolgere il necessario per attivare la CRUD completa:

#### Drink
- name : String : not null : unique
- description : String : lob : nullable
- price : int : not null : > 0

Andranno quindi creati i 3 file per l'entita' (Entity, Repository e Service) e poi create tutte le rotte nessarie in un nuovo controller di nome *DrinkController* basato sulla rotta `/drink` (`@RequestMapping` del *controller*).

---

#### Bonus
Introdurre il concetto di errore + validazione + ritorno messaggio prima per l'entita' `Pizza` e poi eventualmente per i `Drink`

##### Hint
Snippet per controllo errori + gestione messaggi redirect

**Controller**
```java
@PostMapping("/create")
	public String getStoreDrink(@Valid Drink drink, 
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			
			System.err.println("ERROR ------------------------------------------");
			System.err.println(bindingResult.getAllErrors());
			System.err.println("------------------------------------------------");
			
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			
			return "redirect:/drink/create";
		}
		
		drinkServ.save(drink);
		
		return "redirect:/drink";
	}
```

**HTML (create)**
```html
<div
		th:if="${errors}"
	>
		ERROR:<br>
		<ul>
			<li
				th:each="error : ${errors}"
				th:object="${error}"
			>
				[[*{defaultMessage}]]
			</li>
		</ul>
	</div>
```


## Parte 3
### Todo
In aggiunta all'esercizio precedente (sulla stessa *repo*) aggiungere una rotta per la ricerca di `Drink` e una per la ricerca di `Pizza`, come visto in classe.

Per la ricerca utilizzare le *Named Query* basandosi su questo [link](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation) per la costruzione dei metodi all'interno dei *repositories*.

Si veda snippet di codice allegato per la gestione della search e dei *parametri in ingresso* (metodo `GET`) lato *java* + lato *HTML*:

**Controller**
```java
	@GetMapping("/search")
	public String getSearchDrinkByName(Model model, 
			@RequestParam(name = "q", required = false) String query) {
		
//		List<Drink> drinks = null;
//		if (query == null) {
//			
//			drinks = drinkServ.findAll();
//			
//		} else {
//			
//			drinks = drinkServ.findByName(query);
//		}
		List<Drink> drinks = query == null 
							? drinkServ.findAll()
							: drinkServ.findByName(query); 
		
		model.addAttribute("drinks", drinks);
		model.addAttribute("query", query);
		
		return "drink-search";
	}
```

**HTML**
```html
	<form>
		<label>Name: </label>
		<input type="text" name="q" th:value="${query}">
		<br><br>
		<input type="submit" value="SEARCH">
	</form>
```

#### Bonus
Generare una rotta per la ricerca sia su `Drink` che su `Pizza` in un unica pagina (sempre a partire dal nome).
