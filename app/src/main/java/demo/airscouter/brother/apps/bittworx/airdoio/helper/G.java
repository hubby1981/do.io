package demo.airscouter.brother.apps.bittworx.airdoio.helper;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.ArrayList;

import demo.airscouter.brother.apps.bittworx.airdoio.view.manager.Grid;
import demo.airscouter.brother.apps.bittworx.airdoio.view.manager.GridManager;

/**
 * Created by marcel.weissgerber on 08.02.2017.
 */

public class G {


    public static Grid getHorizontalLines(RectF bounds, float height) {
        int max = (int) (bounds.height() / height);
        Grid result = new Grid();
        float top = bounds.top;
        for (int i = 0; i < max; i++) {
            float bottom = top + height;
            if (i + 1 == max) {
                bottom = bounds.bottom;
            }
            result.add(new RectF(bounds.left, top, bounds.right, bottom));
            top += height;
        }
        return result;
    }

    public static RectF shrinkRectF(RectF rectF, int shrinkWidth,int shrinkHeight) {
        return new RectF(rectF.left + rectF.width() / shrinkWidth, rectF.top + rectF.height() / shrinkHeight, rectF.right - rectF.width() / shrinkWidth, rectF.bottom - rectF.height() / shrinkHeight);
    }

    public static Grid getVerticalLines(RectF bounds, float width) {
        int max = (int) (bounds.width() / width);
        Grid result = new Grid();
        float left = bounds.left;
        for (int i = 0; i < max; i++) {
            float right = left + width;
            if (i + 1 == max) {
                right = bounds.right;
            }
            result.add(new RectF(left, bounds.top, right, bounds.bottom));
            left += width;
        }
        return result;
    }


    public static void showGrid(Canvas canvas, ArrayList<RectF> lines) {
        Paint liner = new Paint();
        liner.setStyle(Paint.Style.STROKE);
        liner.setColor(Color.BLACK);
        liner.setStrokeWidth(1);
        for (RectF line : lines) {
            canvas.drawRect(line, liner);
        }
    }
}
