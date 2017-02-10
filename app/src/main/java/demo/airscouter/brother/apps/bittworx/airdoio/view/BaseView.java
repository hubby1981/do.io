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

import java.util.HashMap;
import java.util.Map;

import demo.airscouter.brother.apps.bittworx.airdoio.BaseActivity;
import demo.airscouter.brother.apps.bittworx.airdoio.MainActivity;
import demo.airscouter.brother.apps.bittworx.airdoio.R;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.B;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.C;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.G;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.TE;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.TextHelper;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.Container;
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
    private BaseActivity baseActivity;
    private Container active = null;
    private HashMap<RectF, Container> tiles;
    private RectF close = null;

    protected Node node;

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

    public void setBaseActivity(BaseActivity activity) {
        baseActivity = activity;
    }


    protected abstract Paint getHeaderPaint();

    protected abstract Paint getToolbarPaint();

    protected abstract int getHeaderTextLine0();

    protected abstract int getHeaderTextLine1();

    protected abstract Bitmap getLogo();

    protected Node getNode() {
        return node == null ? new Node(TE.get(R.string.node_workspace), null) : node;
    }

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


        canvas.drawRect(header, getHeaderPaint());
        canvas.drawRect(toolbar, getToolbarPaint());
        canvas.drawRect(footer, footerPaint);

        Grid headerRight = G.getVerticalLines(header,header.height()*2);
        B.drawBitmap(canvas,R.drawable.doio_white,G.shrinkRectF(headerRight.get(headerRight.size()-1),10,10));

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
                    G.getHorizontalLines(content, content.height() / 9), G.getHorizontalLines(toolbar, toolbar.height() / 8));


        }
        if (active == null) {
            active = getNode();
        }
        if (active != null) {
            drawContainer(canvas, active);
        }


    }

    private void drawContainer(Canvas canvas, Container container) {

        if (container != null && container.isNode()) {
            drawNode(canvas, (Node) container);
        }

    }

    private void drawNode(Canvas canvas, Node node) {
        TextHelper.drawTextLeft(canvas, node.getTitleEx(), contentManager.getMergeRect(0, 0, 9, 0), 0, fontBackgroundContent);

        tiles = node.draw(canvas, getToolbarPaint(), contentManager, fontBackgroundHeader);

        if (contentManager != null) {
            int shrinkWidth = 4;
            int shrinkHeight = 6;

            RectF home = G.shrinkRectF(contentManager.getToolbar().get(1), shrinkWidth, shrinkHeight);
            RectF parent = G.shrinkRectF(contentManager.getToolbar().get(2), shrinkWidth, shrinkHeight);
            close = G.shrinkRectF(contentManager.getToolbar().get(contentManager.getToolbar().size() - 1), shrinkWidth, shrinkHeight);
            B.drawBitmap(canvas, R.drawable.close, close);

            if(((Node)active).getParent()!=null) {
                tiles.put(home, getNode());

                B.drawBitmap(canvas, R.drawable.home, home);

                if (active != null && active.isNode()) {
                    Node parentActive = (Node) active;
                    if (parentActive != null && parentActive.getParent() != null) {
                        tiles.put(parent, parentActive.getParent());
                        B.drawBitmap(canvas, R.drawable.parent, parent);

                    }
                }
            }

        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (close != null && close.contains(event.getX(), event.getY())) {
                if (baseActivity != null) {
                    baseActivity.close();
                }
            } else if (tiles != null) {
                for (Map.Entry<RectF, Container> tile : tiles.entrySet()) {
                    if (tile.getKey().contains(event.getX(), event.getY())) {
                        if(tile.getValue().isNode()){
                            active = tile.getValue();

                        }
                        if (baseActivity != null) {
                            baseActivity.refresh();
                        }
                    }
                }
            }
        }
        return false;
    }
}
