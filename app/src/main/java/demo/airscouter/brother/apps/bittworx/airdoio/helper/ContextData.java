package demo.airscouter.brother.apps.bittworx.airdoio.helper;

import android.graphics.Canvas;
import android.graphics.RectF;

import java.util.Timer;
import java.util.TimerTask;

import demo.airscouter.brother.apps.bittworx.airdoio.DocumentViewActivity;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.Document;
import demo.airscouter.brother.apps.bittworx.airdoio.view.content.ElemIter;

/**
 * Created by marcel.weissgerber on 13.02.2017.
 */

public class ContextData {
    public static DocumentViewActivity activity;
    public static ElemIter<Document> document = new ElemIter<Document>() {

        private Timer timer = new Timer();

        @Override
        protected boolean isSingle() {
            return true;
        }

        @Override
        protected void drawElem(Document elem, Canvas canvas,RectF bounds) {
            if (elem != null)
                if (elem.getSite() != null)
                    elem.getSite().draw(canvas,bounds);
        }

        @Override
        public void onPrev() {
            checkPeriod();
        }

        @Override
        public void onEnter() {
            checkPeriod();
        }

        @Override
        public void onLeave() {
            timer.cancel();
            timer = new Timer();
        }

        @Override
        public void onNext() {
            checkPeriod();
        }

        private void checkPeriod() {
            final Document elem = get();
            if (elem != null && elem.getSite() != null) {
                if (elem.getSite().getPeriod() > 0) {
                    timer.cancel();
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if (ContextData.activity != null) {
                                elem.getSite().next();
                                ContextData.activity.refresh();
                            }
                        }
                    }, elem.getSite().getPeriod(), elem.getSite().getPeriod());

                }
            }
        }
    };
    ;
}
