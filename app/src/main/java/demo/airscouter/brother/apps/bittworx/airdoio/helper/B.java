package demo.airscouter.brother.apps.bittworx.airdoio.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import demo.airscouter.brother.apps.bittworx.airdoio.MainActivity;

/**
 * Created by marcel.weissgerber on 17.10.2016.
 */

public class B {
    public static Bitmap get(int id){
        return BitmapFactory.decodeResource(MainActivity.res,id);
    }
}
