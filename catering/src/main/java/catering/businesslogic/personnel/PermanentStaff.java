package catering.businesslogic.personnel;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class PermanentStaff extends Personnel{
    private int nFerieRimaste;
    private final List<Holiday> holidays;

    public PermanentStaff(String nome, String indirizzo, int ferieIniziali) {
        super(nome, indirizzo);
        this.nFerieRimaste = ferieIniziali;
        this.holidays = new ArrayList<>();
    }

    public Holiday requestHoliday(Date start, Date end) {
        if (nFerieRimaste <= 0) {
            throw new PersonnelException("No days left.");
        }
        Holiday newHoliday = new Holiday(start, end);
        holidays.add(newHoliday);
        nFerieRimaste--;
        return newHoliday;
    }

    public boolean isAvailable(Date d) {
        for (Holiday h : holidays) {
            if (h.isActive(d)) {
                return false; // Non disponibile se in ferie
            }
        }
        return true; // Disponibile se non in ferie
    }

    public int getNFerieRimaste() {
        return nFerieRimaste;
    }

    public List<Holiday> getHolidays() {
        return new ArrayList<>(holidays);
    }
    

    public void setNFerieRimaste(int nFerieRimaste) {
        this.nFerieRimaste = nFerieRimaste;
    }

}
