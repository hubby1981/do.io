package demo.airscouter.brother.apps.bittworx.airdoio.view.content;

import android.graphics.Canvas;
import android.graphics.RectF;

import java.util.HashMap;
import java.util.Map;

import demo.airscouter.brother.apps.bittworx.airdoio.helper.G;
import demo.airscouter.brother.apps.bittworx.airdoio.view.manager.GridManager;

/**
 * Created by marcel.weissgerber on 13.02.2017.
 */

public class ContentArea {
    private int rows = 1;
    private int cells = 1;
    private boolean next = false;
    private boolean prev = false;

    private HashMap<AreaDef, Content> contents = new HashMap<>();

    public ContentArea(int rows, int cells) {
        this(rows, cells, false);
    }

    public ContentArea(int rows, int cells, boolean next) {
        this(rows,cells,next,false);
    }
    public ContentArea(int rows, int cells, boolean next,boolean prev) {
        this.rows = rows;
        this.cells = cells;
        this.next = next;
        this.prev = prev;
    }


    public void draw(Canvas canvas, RectF boundsExternal) {
        RectF bounds = boundsExternal == null ? G.getRectF(canvas) : boundsExternal;
        GridManager manager = new GridManager(
                G.getVerticalLines(bounds, bounds.width() / cells),
                G.getHorizontalLines(bounds, bounds.height() / rows),
                null
        );
        for (Map.Entry<AreaDef, Content> item : contents.entrySet()) {
            if (item.getValue() != null)
                item.getValue().draw(canvas, manager.getMergeRect(item.getKey().cell, item.getKey().row));

        }


    }

    public ContentArea add(int row, int cell, Content content) {
        contents.put(new AreaDef(row, cell), content);
        return this;
    }

    public boolean isNext() {
        return next;
    }

    public boolean isPrev() {
        return prev;
    }

    private class AreaDef {
        int row = 0;
        int cell = 0;

        AreaDef(int row, int cell) {
            this.row = row;
            this.cell = cell;
        }
    }

    public void touch(float x, float y) {

        for (Map.Entry<AreaDef, Content> item : contents.entrySet()) {
            if (item.getValue().isRunable() && item.getValue() != null) {
                try {
                    ((RunableContent) item.getValue()).touch(x, y);
                } catch (Exception e) {
                }

            }
        }
    }
}


