package demo.airscouter.brother.apps.bittworx.airdoio.view.content;

import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * Created by marcel.weissgerber on 13.02.2017.
 */

public abstract class RunableContent extends Content {


    private RectF bounds = null;

    protected abstract void drawContent(Canvas canvas, RectF bounds);

    protected abstract Runnable getAction();

    public void touch(float x, float y) {
        if (bounds.contains(x, y) && getAction() != null)
            getAction().run();
    }

    @Override
    protected void draw(Canvas canvas, RectF bounds) {
        this.bounds = bounds;
        drawContent(canvas, bounds);
    }

    @Override
    public boolean isRunable() {
        return true;
    }
}
