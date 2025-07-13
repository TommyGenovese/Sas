package catering.businesslogic.personnel;

import catering.businesslogic.event.Hiring;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class OccasionalStaffTest {

    @Test
    void testCreationAndContactInfo() {
        // 1. SETUP: Creiamo un nuovo membro del personale occasionale.
        String expectedContactInfo = "333-1234567";
        OccasionalStaff staff = new OccasionalStaff("Carla Neri", "Via Prova 123", expectedContactInfo);

        // 2. VERIFICA: Controlliamo che le informazioni di contatto siano state salvate correttamente.
        assertEquals(expectedContactInfo, staff.getInfoContatto(), "Le info di contatto non corrispondono a quelle fornite.");
        assertEquals("Carla Neri", staff.getNome(), "Il nome non corrisponde.");
    }

    @Test
    void testAvailabilityInheritance() {
        OccasionalStaff staff = new OccasionalStaff("Marco Verdi", "Via Test 456", "test@email.com");
        Date oggi = new Date();

        // Appena creato, NON è disponibile
        assertFalse(staff.isAvailable(oggi), "Il personale appena creato NON dovrebbe essere disponibile.");

        // Aggiungi disponibilità
        staff.addDisponibilita(oggi);
        assertTrue(staff.isAvailable(oggi), "Il personale dovrebbe essere disponibile dopo aver aggiunto la data.");

        // Rimuovi disponibilità
        staff.removeDisponibilita(oggi);
        assertFalse(staff.isAvailable(oggi), "Il personale non dovrebbe essere disponibile dopo la rimozione.");
    }

    @Test
    void testConfirmEngagementCall() {
        // 1. SETUP
        OccasionalStaff staff = new OccasionalStaff("Luca Gialli", "Via Roma 10", "luca.gialli@email.it");
        Hiring testHiring = new Hiring(); // Usiamo l'oggetto scheletro che abbiamo creato

        // 2. AZIONE E VERIFICA: Per ora, questo test si assicura solo che il metodo
        // possa essere chiamato senza generare errori.
        assertDoesNotThrow(() -> {
            staff.confirmEngagement(testHiring);
        }, "La chiamata a confirmEngagement non dovrebbe generare un'eccezione.");
    }
}