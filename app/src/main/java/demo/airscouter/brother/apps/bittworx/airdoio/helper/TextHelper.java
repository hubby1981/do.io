package demo.airscouter.brother.apps.bittworx.airdoio.helper;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by marcel.weissgerber on 08.02.2017.
 */

public class TextHelper {

    public static void drawText(Canvas canvas, int text, RectF bounds, float factor, Paint fontBackground) {
        drawText(canvas, TE.get(text), bounds, factor, fontBackground);
    }

    public static void drawText(Canvas canvas, String text, RectF bounds, float factor, Paint fontBackground) {
        float sizeT = fontBackground.measureText(text);

        canvas.drawText(text, bounds.centerX() - sizeT / 2, bounds.centerY() + fontBackground.getTextSize() * factor, fontBackground);
    }

    public static void drawTextLeft(Canvas canvas, int text, RectF bounds, float factor, Paint fontBackground) {
        drawTextLeft(canvas, TE.get(text), bounds, factor, fontBackground);
    }

    public static void drawTextLeft(Canvas canvas, String text, RectF bounds, float factor, Paint fontBackground) {


        canvas.drawText(text, bounds.left + 8, bounds.centerY() + bounds.height() / 6, fontBackground);
    }

    public static Paint getFont(RectF bounds) {

        return getFont(bounds,Color.WHITE);
    }

    public static Paint getFont(RectF bounds,int color) {

        return getFont(bounds,color,(int)(bounds.height() / 3));
    }

    public static Paint getFont(RectF bounds,int color,int size) {
        Paint font = new Paint();
        font.setStyle(Paint.Style.FILL);

        font.setTextSize(size);
        font.setColor(color);
        return font;
    }
}
