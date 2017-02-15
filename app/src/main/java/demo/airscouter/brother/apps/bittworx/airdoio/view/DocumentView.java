package demo.airscouter.brother.apps.bittworx.airdoio.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import demo.airscouter.brother.apps.bittworx.airdoio.DocumentViewActivity;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.C;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.ContextData;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.G;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.TextHelper;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.Document;
import demo.airscouter.brother.apps.bittworx.airdoio.view.content.ContentArea;
import demo.airscouter.brother.apps.bittworx.airdoio.view.gesture.GestureView;
import demo.airscouter.brother.apps.bittworx.airdoio.view.manager.Grid;

/**
 * Created by marcel.weissgerber on 13.02.2017.
 */

public class DocumentView extends GestureView {

    private DocumentViewActivity activity;

    Grid vertical;
    Grid horizontal;
    Grid horizontalLayer;
    Paint backLeft = new Paint();
    Paint backMiddle = new Paint();
    Paint backRight = new Paint();

    Paint backTop = new Paint();
    Paint backBottom = new Paint();

    private boolean showTop = false;
    private boolean showBottom = false;
    private boolean showLeft = false;
    private boolean showMiddle = false;
    private boolean showRight = false;

    public DocumentView(Context context, AttributeSet attrs) {
        super(context, attrs);

        backLeft.setStyle(Paint.Style.FILL);
        backMiddle.setStyle(Paint.Style.FILL);
        backRight.setStyle(Paint.Style.FILL);
        backTop.setStyle(Paint.Style.FILL);
        backBottom.setStyle(Paint.Style.FILL);
        int alpha = 128;


        backLeft.setColor(Color.argb(alpha, C.getRedArray()[4], C.getGreenArray()[4], C.getBlueArray()[4]));
        backMiddle.setColor(Color.argb(alpha, C.getRedArray()[5], C.getGreenArray()[5], C.getBlueArray()[5]));
        backRight.setColor(Color.argb(alpha, C.getRedArray()[6], C.getGreenArray()[6], C.getBlueArray()[6]));
        backTop.setColor(Color.argb(alpha, C.getRedArray()[0], C.getGreenArray()[0], C.getBlueArray()[0]));
        backBottom.setColor(Color.argb(alpha, C.getRedArray()[1], C.getGreenArray()[1], C.getBlueArray()[1]));

    }


    public void setActivity(DocumentViewActivity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean ret =true;
        if (horizontalLayer != null && horizontalLayer.size() > 0) {
            int index = 0;
            for (RectF rectF : horizontalLayer) {
                if (rectF.contains(event.getX(), event.getY())) {
                    if (ContextData.document != null) {
                        if (ContextData.document.get() != null&&  ContextData.document.get().getSite()!=null) {
                            ContextData.document.get().getSite().setArea(index);
                            ret=false;
                            if (ContextData.activity != null)
                                ContextData.activity.refresh();
                        }
                    }
                }
                index++;
            }
        }
        if(ret)
            ret = super.onTouchEvent(event);

        if (!ret) {
             if (ContextData.document != null && ContextData.document.getAll() != null) {
                for (Document document : ContextData.document.getAll()) {
                    if (document != null && document.getSite() != null) {
                        for (ContentArea contentArea : document.getSite().getAll()) {
                            contentArea.touch(event.getX(), event.getY());
                        }
                    }
                }
            }
        }
        return ret;
    }


    @Override
    public void onDraw(Canvas canvas) {
        RectF bounds = new RectF(canvas.getClipBounds().left, canvas.getClipBounds().top, canvas.getClipBounds().right, canvas.getClipBounds().bottom);
        RectF layers = G.getRectFShrinkWidth(bounds, 30);
        horizontal = G.getHorizontalLines(bounds, bounds.height() / 3);
        vertical = G.getVerticalLines(horizontal.get(1), bounds.width() / 3);


        if (isShowLeft())
            canvas.drawRect(vertical.get(0), backLeft);
        if (isShowMiddle())
            canvas.drawRect(vertical.get(1), backMiddle);
        if (isShowRight())
            canvas.drawRect(vertical.get(2), backRight);
        if (isShowTop())
            canvas.drawRect(horizontal.get(0), backTop);
        if (isShowBottom())
            canvas.drawRect(horizontal.get(2), backBottom);

        if (ContextData.document != null) {
            if (ContextData.document.get() != null) {
                Paint p = new Paint();
                p.setStyle(Paint.Style.FILL);
                p.setColor(Color.argb(185, C.getRedArray()[7], C.getGreenArray()[7], C.getBlueArray()[7]));
                ContextData.document.get().getSite().draw(canvas, G.getRectFWithSources(bounds, layers.right));
                int max = ContextData.document.get().getSite().size();
                horizontalLayer = G.getHorizontalLines(layers, bounds.height() / max);
                int all = ContextData.document.get().getSite().getAll().size();
                int index = 0;
                for (RectF rectF : horizontalLayer) {

                    TextHelper.drawText(canvas,Integer.toString(index+1),rectF,0.5f,TextHelper.getFont(rectF,Color.WHITE,30));
                    if (index < all) {
                        canvas.drawRect(rectF, p);
                    }

                    index++;
                }
                G.showGrid(canvas, horizontalLayer, Color.WHITE);
            }
        }


    }


    public boolean isShowLeft() {
        return showLeft;
    }

    public void setShowLeft(boolean showLeft) {
        this.showLeft = showLeft;
    }

    public boolean isShowTop() {
        return showTop;
    }

    public void setShowTop(boolean showTop) {
        this.showTop = showTop;
    }

    public boolean isShowBottom() {
        return showBottom;
    }

    public void setShowBottom(boolean showBottom) {
        this.showBottom = showBottom;
    }

    public boolean isShowMiddle() {
        return showMiddle;
    }

    public void setShowMiddle(boolean showMiddle) {
        this.showMiddle = showMiddle;
    }

    public boolean isShowRight() {
        return showRight;
    }

    public void setShowRight(boolean showRight) {
        this.showRight = showRight;
    }

    @Override
    public void onSwipeTop() {
        if (activity != null) {
            if (activity != null) {
                //setShowTop(!showTop);
                if (ContextData.document != null) {
                    ContextData.document.get().getSite().next();
                }
                activity.refresh();
            }
        }
    }

    @Override
    public void onSwipeLeft() {
        if (activity != null) {
            //setShowLeft(!showLeft);
            if (ContextData.document != null) {
                ContextData.document.prev();
                while (ContextData.document.get().getSite() == null) {
                    ContextData.document.prev();
                }
            }
            activity.refresh();
        }
    }

    @Override
    public void onSwipeBottom() {
        if (activity != null) {
            //setShowBottom(!showBottom);
            if (ContextData.document != null) {
                ContextData.document.get().getSite().prev();
            }
            activity.refresh();
        }
    }

    @Override
    public void onSwipeRight() {
        if (activity != null) {
            //setShowRight(!showRight);
            if (ContextData.document != null) {
                ContextData.document.next();
                while (ContextData.document.get().getSite() == null) {
                    ContextData.document.next();
                }
            }
            activity.refresh();
        }
    }
}
