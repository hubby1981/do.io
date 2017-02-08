package demo.airscouter.brother.apps.bittworx.airdoio.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by marcel.weissgerber on 08.02.2017.
 */

public class DateHelper {

    public static String getDateTime(){
        return new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date());
    }
}
