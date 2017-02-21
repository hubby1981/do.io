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
                bottom = bounds.bottom-1;
            }
            result.add(new RectF(bounds.left, top, bounds.right, bottom));
            top += height;
        }
        return result;
    }




    public static RectF shrinkRectF(RectF rectF, int shrinkWidth,int shrinkHeight) {
        return new RectF(rectF.left + rectF.width() / shrinkWidth, rectF.top + rectF.height() / shrinkHeight, rectF.right - rectF.width() / shrinkWidth, rectF.bottom - rectF.height() / shrinkHeight);
    }

    public static RectF getRectF(Canvas canvas){
        return new RectF(canvas.getClipBounds().left, canvas.getClipBounds().top, canvas.getClipBounds().right, canvas.getClipBounds().bottom);
    }

    public static RectF getRectFShrinkWidth(RectF rectF,float factor){
        return new RectF(rectF.left, rectF.top, rectF.left+ rectF.width()/factor, rectF.bottom);
    }

    public static RectF getRectFShrinkHeight(RectF rectF,float factor){
        return new RectF(rectF.left, rectF.top, rectF.right, rectF.top+(rectF.height()/factor));
    }
    public static RectF getRectFWithSources(RectF rectF,float left){
        return new RectF(left, rectF.top, rectF.left+ rectF.width(), rectF.bottom);
    }
    public static RectF getRectFWithSourcesHeight(RectF rectF,float top){
        return new RectF(rectF.left, top, rectF.right, rectF.top+rectF.height());
    }

    public static Grid getVerticalLines(RectF bounds, float width) {
        int max = (int) (bounds.width() / width);
        Grid result = new Grid();
        float left = bounds.left;
        for (int i = 0; i < max; i++) {
            float right = left + width;
            if (i + 1 == max) {
                right = bounds.right-1;
            }
            result.add(new RectF(left, bounds.top, right, bounds.bottom));
            left += width;
        }
        return result;
    }


    public static void showGrid(Canvas canvas, ArrayList<RectF> lines) {
        showGrid(canvas,lines,Color.BLACK);
    }
    public static void showGrid(Canvas canvas, ArrayList<RectF> lines,int color) {
        showGrid(canvas,lines,color,1);

    }
    public static void showGrid(Canvas canvas, ArrayList<RectF> lines,int color,int size) {
        Paint liner = new Paint();
        liner.setStyle(Paint.Style.STROKE);
        liner.setColor(color);
        liner.setStrokeWidth(size);
        for (RectF line : lines) {
            canvas.drawRect(line, liner);
        }
    }
}
