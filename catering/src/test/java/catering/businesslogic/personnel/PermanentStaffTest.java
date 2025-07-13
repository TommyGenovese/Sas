package catering.businesslogic.personnel;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class PermanentStaffTest {

    @Test
    void testHolidayRequestAndAvailability() {
        PermanentStaff staff = new PermanentStaff("Mario Rossi", "Via Roma", 2);

        // Richiesta ferie
        Date start = new Date(2025-1900, 6, 15); // 15 luglio 2025
        Date end = new Date(2025-1900, 6, 20);   // 20 luglio 2025
        Holiday holiday = staff.requestHoliday(start, end);

        // All'inizio la ferie NON è attiva (non approvata)
        assertFalse(holiday.isActive(new Date(2025-1900, 6, 16)));
        assertTrue(staff.isAvailable(new Date(2025-1900, 6, 16)));

        // Approva la ferie
        holiday.approve(null);

        // Ora la ferie è attiva
        assertTrue(holiday.isActive(new Date(2025-1900, 6, 16)));
        assertFalse(staff.isAvailable(new Date(2025-1900, 6, 16)));

        // Fuori dal periodo ferie
        assertFalse(holiday.isActive(new Date(2025-1900, 6, 25)));
        assertTrue(staff.isAvailable(new Date(2025-1900, 6, 25)));

        System.out.println("Ferie attiva: " + holiday.isActive(new Date(2025-1900, 6, 16)));
        System.out.println("Disponibile: " + staff.isAvailable(new Date(2025-1900, 6, 16)));
    }
}