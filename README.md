
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
