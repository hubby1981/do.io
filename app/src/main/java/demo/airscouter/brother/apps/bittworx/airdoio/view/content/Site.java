package demo.airscouter.brother.apps.bittworx.airdoio.view.content;

import android.graphics.Canvas;

import java.util.Timer;

/**
 * Created by marcel.weissgerber on 13.02.2017.
 */

public class Site extends ElemIter<ContentArea> {

    public Site(){
        super();
    }
    public Site(long period){
        super(period);
    }
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
