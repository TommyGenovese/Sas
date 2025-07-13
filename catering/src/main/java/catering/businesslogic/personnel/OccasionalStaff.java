package catering.businesslogic.personnel;

import java.util.*;

public class OccasionalStaff  extends Personnel {
    public OccasionalStaff(String nome, String indirizzo) {
        super(nome, indirizzo);
    }

    public boolean isAvailable(Date date) {
        return isAvailable(); 
    }
}
