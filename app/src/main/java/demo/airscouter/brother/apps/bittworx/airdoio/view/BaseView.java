package demo.airscouter.brother.apps.bittworx.airdoio.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import demo.airscouter.brother.apps.bittworx.airdoio.MainActivity;
import demo.airscouter.brother.apps.bittworx.airdoio.R;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.C;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.G;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.TextHelper;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.Node;
import demo.airscouter.brother.apps.bittworx.airdoio.view.manager.Grid;
import demo.airscouter.brother.apps.bittworx.airdoio.view.manager.GridManager;

/**
 * Created by marcel.weissgerber on 08.02.2017.
 */

public abstract class BaseView extends View {
    private Paint backgroundPaint = new Paint();
    private Paint fontBackgroundHeader = new Paint();
    private Paint fontBackgroundContent = new Paint();

    private Paint footerPaint = new Paint();

    private GridManager contentManager;


    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        backgroundPaint.setStyle(Paint.Style.FILL);
        backgroundPaint.setColor(Color.WHITE);
        footerPaint.setStyle(Paint.Style.FILL);
        footerPaint.setColor(C.grayLight);
        fontBackgroundHeader.setStyle(Paint.Style.FILL);
        fontBackgroundHeader.setColor(Color.WHITE);
        fontBackgroundContent.setStyle(Paint.Style.FILL);
        fontBackgroundContent.setColor(Color.BLACK);
        setLayerType(LAYER_TYPE_SOFTWARE, null);

    }


    protected abstract Paint getHeaderPaint();

    protected abstract Paint getToolbarPaint();

    protected abstract int getHeaderTextLine0();

    protected abstract int getHeaderTextLine1();

    protected abstract Bitmap getLogo();

    protected abstract Node getNode();

    @Override
    public void onDraw(Canvas canvas) {
        Rect bounds = canvas.getClipBounds();
        if (!MainActivity.TRANSPARENT) {
            canvas.drawRect(bounds, backgroundPaint);
        }

        RectF header = new RectF(bounds.left, bounds.top, bounds.right, bounds.height() / 10);

        RectF toolbar = new RectF(bounds.left, header.bottom, bounds.left + bounds.width() / 10, bounds.bottom);
        RectF toolbarComplete = new RectF(bounds.left, header.top, bounds.left + bounds.width() / 10, bounds.bottom);

        RectF footer = new RectF(toolbar.right, bounds.bottom - bounds.height() / 20, bounds.right, bounds.bottom);

        fontBackgroundHeader.setTextSize(header.height() / 2.75f);
        fontBackgroundContent.setTextSize(header.height() / 2.75f);


        //fontBackgroundHeader.setShadowLayer(2,0,0,Color.BLACK);

        canvas.drawRect(header, getHeaderPaint());
        canvas.drawRect(toolbar, getToolbarPaint());
        canvas.drawRect(footer, footerPaint);


        RectF content = new RectF(toolbar.right, bounds.top, header.right, bounds.bottom);

        Grid headerGrid = G.getHorizontalLines(content, header.height() / 2f);
        Grid linesToolbarState = G.getHorizontalLines(toolbarComplete, toolbar.width());


        RectF logo = linesToolbarState.get(0);
        logo = new RectF(logo.centerX() - logo.width() / 2.5f, logo.centerY() - logo.height() / 2.5f, logo.centerX() + logo.width() / 2.5f, logo.centerY() + logo.height() / 2.5f);
        canvas.drawBitmap(getLogo(), new Rect(0, 0, getLogo().getWidth(), getLogo().getHeight()), logo, null);

        TextHelper.drawTextLeft(canvas, getHeaderTextLine0(), headerGrid.get(0), 4f, fontBackgroundHeader);
        TextHelper.drawTextLeft(canvas, getHeaderTextLine1(), headerGrid.get(1), 20f, fontBackgroundHeader);


        content = new RectF(toolbar.right, header.bottom, header.right, footer.top);
        if (contentManager == null) {
            contentManager = new GridManager(G.getVerticalLines(content, content.width() / 9),
                    G.getHorizontalLines(content, content.height() / 9), G.getHorizontalLines(toolbar, toolbar.height() / 10));
        }
        if(getNode()!=null){
            drawNode(canvas);
        }




    }
    private void drawNode(Canvas canvas){


        Node n = getNode();

        TextHelper.drawTextLeft(canvas,n.getTitle(),contentManager.getMergeRect(0,0,9,0),0,fontBackgroundContent);

        n.draw(canvas,getToolbarPaint(),contentManager,fontBackgroundHeader);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

        }
        return false;
    }
}
