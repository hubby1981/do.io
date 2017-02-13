package demo.airscouter.brother.apps.bittworx.airdoio.view.content;

import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * Created by marcel.weissgerber on 13.02.2017.
 */

public abstract class Content {


    public boolean isRunable() {
        return false;
    }

    protected abstract void draw(Canvas canvas, RectF bounds);

}
