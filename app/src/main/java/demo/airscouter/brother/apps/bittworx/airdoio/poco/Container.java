package demo.airscouter.brother.apps.bittworx.airdoio.poco;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.HashMap;
import java.util.List;

import demo.airscouter.brother.apps.bittworx.airdoio.data.BaseDataObject;
import demo.airscouter.brother.apps.bittworx.airdoio.view.manager.GridManager;

/**
 * Created by marcel.weissgerber on 10.02.2017.
 */

public abstract class Container extends BaseDataObject {

    public abstract boolean isNode();
    public abstract boolean isDocument();

    protected  abstract HashMap<RectF,Container> drawElements(Canvas canvas, Paint injectPaint, GridManager manager, Paint fontPaint,List<Container> list);


    public abstract HashMap<RectF,Container> draw(Canvas canvas, Paint injectPaint, GridManager manager, Paint fontPaint) ;

    public int getWidth(){
        return 1;
    }

    public int getHeight(){
        return 1;
    }

}
