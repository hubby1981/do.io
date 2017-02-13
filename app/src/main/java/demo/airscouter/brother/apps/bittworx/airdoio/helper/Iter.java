package demo.airscouter.brother.apps.bittworx.airdoio.helper;

/**
 * Created by marcel.weissgerber on 13.02.2017.
 */

public class Iter {


    public static int next(int x, int max) {
        if (x < max - 1)
            x++;
        else
            x = 0;
        return x;
    }

    public static int prev(int x, int max) {
        if (x > 0)
            x--;
        else
            x = max - 1;
        return x;
    }
}
