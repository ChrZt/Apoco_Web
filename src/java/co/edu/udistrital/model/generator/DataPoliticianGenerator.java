package co.edu.udistrital.model.generator;

import co.edu.udistrital.model.structures.SimpleList;
import co.edu.udistrital.model.entities.*;
import co.edu.udistrital.model.structures.enums.EnumLastNames;
import co.edu.udistrital.model.structures.enums.MenEnumNames;
import co.edu.udistrital.model.structures.enums.WomenEnumNames;
import java.util.Random;

/**
 * Clase de utilidad para crear datos aleatorios y no hacerlo a mano
 *
 * @author Jimmy86gb
 */
public class DataPoliticianGenerator {

    /**
     * Genera una lista de politicos con nombres y dinero al azar entre $1000 y
     * $5000000, usa tambien random para crear nombres al azar
     *
     * @param size la cantidad de politicos que queremos crear
     * @return una lista simple llena de politicos
     */
    public static SimpleList<Politician> generatePoliticians(double size) {
        SimpleList<Politician> listP = new SimpleList<>();
        Random ran = new Random();
        double minMoney = 1000;
        double maxMoney = 5000000;
        int randomUtility = 0;
        
        //Importar los nombres del enum
        MenEnumNames[] menNames = MenEnumNames.values();
        WomenEnumNames[] womenNames = WomenEnumNames.values();
        EnumLastNames[] lastNames = EnumLastNames.values();
        
        for (int i = 0; i < size; i++) {
            
            randomUtility = ran.nextInt(1);
            
            String name = (randomUtility == 0) ? menNames[ran.nextInt(10)] + " " + lastNames[ran.nextInt(10)] + " " + "(Politico Corrupto No." + (i + 1) + ")" : womenNames[ran.nextInt(10)] + " " + lastNames[ran.nextInt(10)] + " " + "(Politico Corrupto No." + (i + 1) + ")" ;
            double ranMoney = minMoney + (maxMoney - minMoney) * ran.nextDouble();
            ranMoney = Math.round(ranMoney * 100) / 100;
            listP.add(new Politician(name, ranMoney));
        }
        return listP;
    }
}
