package catering.businesslogic.personnel;

import catering.businesslogic.event.Assignment;
import catering.businesslogic.shift.Shift; 

import java.util.Date;
import java.util.List;

/**
 * Classe astratta che rappresenta un membro del personale.
 * Funge da base per tutte le tipologie di personale (cuochi, chef, staff, ecc.).
 */
public abstract class Personnel {

    private int id;
    private String nome;
    private String indirizzo;
    private boolean disponibilita;

    // COSTRUTTORE
    public Personnel(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.disponibilita = true; 
    }


    // METODI ASTRATTI

    /**
     * Controlla se il membro del personale è disponibile in una data specifica.
     * La logica potrebbe variare tra personale fisso e occasionale.
     * @param d La data da controllare.
     * @return true se disponibile, false altrimenti.
     */
    public abstract boolean isAvailable(Date d);


    // METODI CONCRETI
    /**
     * Assegna un turno a questo membro del personale.
     * @param s Il turno da assegnare.
     */
    public void assignShift(Shift s) {
        System.out.println("Turno assegnato a " + this.nome);
    }

    /**
     * Marca il membro del personale come non disponibile per un periodo.
     * @param start Data di inizio indisponibilità.
     * @param end Data di fine indisponibilità.
     */
    public void markUnavailable(Date start, Date end) {
        this.disponibilita = false;
        System.out.println(this.nome + " non disponibile da " + start + " a " + end);
    }

    /**
     * Recupera la lista degli incarichi (Assignment) per questo membro del personale.
     * @return Una lista di oggetti Assignment.
     */
    public List<Assignment> getAssignments() {
        //da implementare con la persistenza del database
        return null;
    }


    // GETTERS E SETTERS

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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public boolean isDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(boolean disponibilita) {
        this.disponibilita = disponibilita;
    }
}