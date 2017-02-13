package demo.airscouter.brother.apps.bittworx.airdoio.view.content;

import android.graphics.Canvas;

/**
 * Created by marcel.weissgerber on 13.02.2017.
 */

public class Site extends ElemIter<ContentArea> {
    @Override
    protected boolean isSingle() {
        return false;
    }

    @Override
    protected void drawElem(ContentArea elem, Canvas canvas) {
        if(elem!=null){
            elem.draw(canvas);
        }
    }
}
