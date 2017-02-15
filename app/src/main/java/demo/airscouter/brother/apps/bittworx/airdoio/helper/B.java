package demo.airscouter.brother.apps.bittworx.airdoio.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import demo.airscouter.brother.apps.bittworx.airdoio.MainActivity;

/**
 * Created by marcel.weissgerber on 17.10.2016.
 */

public class B {
    public static Bitmap get(int id){
        return BitmapFactory.decodeResource(MainActivity.res,id);
    }

    public static void drawBitmap(Canvas canvas,int bitmap,RectF rectF){
        Bitmap bit = get(bitmap);
        if(bit!=null){
            canvas.drawBitmap(bit,new Rect(0,0,bit.getWidth(),bit.getHeight()),rectF,null);

        }
        if(!bit.isRecycled())
            bit.recycle();
    }
}
