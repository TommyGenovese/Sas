package catering.businesslogic.personnel;

import catering.businesslogic.event.Hiring;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Rappresenta un membro del personale occasionale (a chiamata).
 * Estende Personnel con informazioni di contatto e la gestione degli ingaggi.
 */
public class OccasionalStaff extends Personnel {

    private String infoContatto; // es. numero di telefono, email
    private Set<Date> disponibilita = new HashSet<>();

    /**
     * Costruttore per un nuovo membro del personale occasionale.
     */
    public OccasionalStaff(String nome, String indirizzo, String infoContatto) {
        super(nome, indirizzo); // Chiama il costruttore della classe genitore
        this.infoContatto = infoContatto;
    }


    /**
     * Conferma l'accettazione di un ingaggio.
     */
    public void confirmEngagement(Hiring h) {
        System.out.println(getNome() + " ha confermato l'ingaggio.");
        // In futuro, questo metodo potrebbe cambiare lo stato dell'oggetto Hiring
        // e marcare il membro del personale come non disponibile per le date dell'ingaggio.
    }
    /**
     * Controlla la disponibilità del personale occasionale.
     * Per ora, la logica si basa semplicemente sullo stato di disponibilità generale.
     */
    @Override
    public boolean isAvailable(Date d) {
        return disponibilita.contains(d);
    }

    // Metodo per aggiungere una disponibilità
    public void addDisponibilita(Date d) {
        disponibilita.add(d);
    }

    // Metodo per rimuovere una disponibilità
    public void removeDisponibilita(Date d) {
        disponibilita.remove(d);
    }

    public String getInfoContatto() {
        return infoContatto;
    }

    public void setInfoContatto(String infoContatto) {
        this.infoContatto = infoContatto;
    }
}