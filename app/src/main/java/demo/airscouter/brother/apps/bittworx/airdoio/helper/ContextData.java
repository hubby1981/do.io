package demo.airscouter.brother.apps.bittworx.airdoio.helper;

import android.graphics.Canvas;

import demo.airscouter.brother.apps.bittworx.airdoio.poco.Document;
import demo.airscouter.brother.apps.bittworx.airdoio.view.content.ElemIter;

/**
 * Created by marcel.weissgerber on 13.02.2017.
 */

public class ContextData {

    public static ElemIter<Document> document = new ElemIter<Document>() {
        @Override
        protected boolean isSingle() {
            return true;
        }

        @Override
        protected void drawElem(Document elem, Canvas canvas) {
            if(elem!=null)
                if(elem.getSite()!=null)
                    elem.getSite().draw(canvas);
        }
    };;
}
