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

    private HashMap<AreaDef, Content> contents = new HashMap<>();

    public ContentArea(int rows, int cells) {
        this.rows = rows;
        this.cells = cells;
    }

    public void draw(Canvas canvas) {
        RectF bounds = G.getRectF(canvas);
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

    private class AreaDef {
        int row = 0;
        int cell = 0;

        AreaDef(int row, int cell) {
            this.row = row;
            this.cell = cell;
        }
    }

    public void touch(float x,float y){

        for (Map.Entry<AreaDef, Content> item : contents.entrySet()) {
            if(item.getValue().isRunable()){
                ((RunableContent)item.getValue()).touch(x,y);
            }
        }
    }
}


