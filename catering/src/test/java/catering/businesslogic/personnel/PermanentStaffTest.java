package catering.businesslogic.personnel;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class PermanentStaffTest {

    @Test
    void testMultipleStaffHolidayRequests() {
        PermanentStaff[] staff = {
            new PermanentStaff("Mario Rossi", "Via Roma", 2),
            new PermanentStaff("Luca Bianchi", "Via Milano", 3),
            new PermanentStaff("Giulia Verdi", "Via Torino", 1),
            new PermanentStaff("Anna Neri", "Via Napoli", 2),
            new PermanentStaff("Paolo Gialli", "Via Firenze", 4)
        };

        // Richiesta ferie per ciascun utente
        Date[][] ferie = {
            {new Date(2025-1900, 6, 10), new Date(2025-1900, 6, 15)}, // Mario
            {new Date(2025-1900, 6, 12), new Date(2025-1900, 6, 18)}, // Luca
            {new Date(2025-1900, 6, 20), new Date(2025-1900, 6, 25)}, // Giulia
            {new Date(2025-1900, 6, 15), new Date(2025-1900, 6, 17)}, // Anna
            {new Date(2025-1900, 6, 14), new Date(2025-1900, 6, 16)}  // Paolo
        };

        Holiday[] holidays = new Holiday[5];
        for (int i = 0; i < staff.length; i++) {
            holidays[i] = staff[i].requestHoliday(ferie[i][0], ferie[i][1]);
            System.out.println(staff[i].getNome() + " ha richiesto ferie dal " + ferie[i][0] + " al " + ferie[i][1]);
        }

        // Approva le ferie di Mario, Giulia e Paolo
        holidays[0].approve(null);
        holidays[2].approve(null);
        holidays[4].approve(null);

        // Rifiuta le ferie di Luca e Anna
        holidays[1].reject(null);
        holidays[3].reject(null);

        // Verifica stato e disponibilità per una data specifica
        Date checkDate = new Date(2025-1900, 6, 15); // 15 luglio 2025
        for (int i = 0; i < staff.length; i++) {
            System.out.println(staff[i].getNome() + " - Ferie attiva il " + checkDate + ": " + holidays[i].isActive(checkDate)
                + " |\n Disponibile: " + staff[i].isAvailable(checkDate)
                + " | Stato richiesta: " + holidays[i].getStato()+ "\n");
        }

        // Verifica anche una data fuori dalle ferie
        Date checkDate2 = new Date(2025-1900, 6, 26); // 26 luglio 2025
        for (int i = 0; i < staff.length; i++) {
            System.out.println(staff[i].getNome() + " - Ferie attiva il " + checkDate2 + ": " + holidays[i].isActive(checkDate2)
                + " | Disponibile: " + staff[i].isAvailable(checkDate2)
                + " | Stato richiesta: " + holidays[i].getStato());
        }
    }
}