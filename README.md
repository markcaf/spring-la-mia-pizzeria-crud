
### Repo
**spring-la-mia-pizzeria-crud**

### Package
-ragionevole-

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
