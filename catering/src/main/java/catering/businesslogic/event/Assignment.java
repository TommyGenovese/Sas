package catering.businesslogic.event;

import catering.businesslogic.personnel.Personnel;
import java.util.Date;

/**
 * Rappresenta l'incarico di un membro del personale per soddisfare una necessità.
 * Questa è una classe scheletro per permettere la compilazione.
 * Ancora da implementare
 */
public class Assignment {
    private int id;
    private String stato;
    private Date dataProposta;
    private Date dataScadenza;

    // Riferimenti ad altre classi come da DCD
    //private Need need;  //da implementare ancora
    private Personnel personnel;

    public Assignment() {
        
    }
}