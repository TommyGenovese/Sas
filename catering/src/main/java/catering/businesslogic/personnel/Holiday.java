package catering.businesslogic.personnel;

import catering.businesslogic.event.Owner;
import java.util.Date;

/**
 * Rappresenta un periodo di ferie richiesto da un membro del personale.
 * Contiene le date, lo stato della richiesta e i metodi per gestirla.
 */
public class Holiday {

    public enum HolidayState {
        RICHIESTA,  // 0
        APPROVATA,  // 1
        RIFIUTATA   // 2
    }

    private int id;
    private Date dataInizio;
    private Date dataFine;
    private HolidayState stato;

    /**
     * Costruttore per una nuova richiesta di ferie.
     * @param dataInizio La data di inizio delle ferie.
     * @param dataFine La data di fine delle ferie.
     */
    public Holiday(Date dataInizio, Date dataFine) {
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.stato = HolidayState.RICHIESTA; // Una nuova richiesta parte sempre da questo stato
    }

    /**
     * Metodo concettuale per avviare il processo di approvazione.
     */
    public void requestApproval() {
        System.out.println("Processo di approvazione avviato per le ferie con id: " + this.id);
    }

    /**
     * Approva la richiesta di ferie.
     * @param owner L'owner che effettua l'approvazione.
     */
    public void approve(Owner owner) {
        this.stato = HolidayState.APPROVATA;
    }

    //Rifiuta la richiesta di ferie.
    public void reject(Owner owner) {
        this.stato = HolidayState.RIFIUTATA;
    }

    /**
     * Controlla se le ferie sono attive in una data specifica.
     * Le ferie sono attive se approvate e se la data rientra nell'intervallo.
     */
    public boolean isActive(Date date) {
        if (this.stato != HolidayState.APPROVATA) {
            return false;
        }
        // Controlla se 'date' non è prima di 'dataInizio' E non è dopo 'dataFine'
        return !date.before(this.dataInizio) && !date.after(this.dataFine);
    }

    // GETTERS E SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public HolidayState getStato() {
        return stato;
    }
}