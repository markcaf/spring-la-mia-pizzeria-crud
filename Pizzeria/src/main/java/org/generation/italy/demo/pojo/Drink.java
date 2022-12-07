package org.generation.italy.demo.pojo;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Drink {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotEmpty(message = "Il nome deve contenere qualcosa")
	@Column(unique=true)
	private String nome;
	
	@Lob
	@Nullable
	@Column(name="descrizione")
	private String descrizione;
	
	@NotNull(message = "Il prezzo non può essere vuoto")
	@Min(value=1, message = "Il prezzo deve essere maggiore di zero")
	private int prezzo;
	
	public Drink() { }
	public Drink(String nome, String descrizione, int prezzo) {
		setNome(nome);
		setDescrizione(descrizione);
		setPrezzo(prezzo);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		return "\nID: " + getId()
				+ "\nNome: " + getNome()
				+ "\nDescrizione: " + getDescrizione()
				+ "\nPrezzo: " + getPrezzo();
	}
}
