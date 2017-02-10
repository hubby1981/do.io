package demo.airscouter.brother.apps.bittworx.airdoio.poco;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import demo.airscouter.brother.apps.bittworx.airdoio.data.DbReference;
import demo.airscouter.brother.apps.bittworx.airdoio.data.DbTable;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.G;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.TextHelper;
import demo.airscouter.brother.apps.bittworx.airdoio.view.manager.Grid;
import demo.airscouter.brother.apps.bittworx.airdoio.view.manager.GridManager;

/**
 * Created by marcel.weissgerber on 08.02.2017.
 */

@DbTable(name = "node")
public class Node extends Container {

    @DbReference(items = Node.class)
    private List<Container> nodes = new ArrayList<>();

    @DbReference(items = Document.class)
    private List<Container> documents = new ArrayList<>();

    @DbTable(name = "title")
    private String title = "";


    private Node parent = null;

    public Node() {

    }

    public Node(String title, List<Container> nodes) {
        this.title = title;
        if (nodes != null) {
            this.nodes = nodes;
        }
    }

    public Node(String title, List<Container> nodes, List<Container> documents) {
        this(title, nodes);
        if (documents != null) {
            this.documents = documents;
        }
    }

    public Node parent(Node node) {
        this.parent = node;
        return this;
    }

    @Override
    protected void imported() {

    }

    public HashMap<RectF, Container> draw(Canvas canvas, Paint injectPaint, GridManager manager, Paint fontPaint) {
        HashMap<RectF, Container> result = new HashMap<>();

        if (nodes != null && nodes.size() > 0) {
            result.putAll(drawElements(canvas, injectPaint, manager, fontPaint, nodes));
        }
        if (documents != null && documents.size() > 0) {
            result.putAll(drawElements(canvas, injectPaint, manager, fontPaint, documents));

        }
        return result;
    }


    public String getTitle() {
        return title;
    }

    public Node getParent() {
        return parent;
    }

    public String getTitleEx() {
        return parent != null ? parent.getTitleEx() + " > " + getDeeperChild(this) + "." + getTitle() : getDeeperChild(this) + "." + getTitle();
    }


    public int getDeeperChild(Node that) {
        return parent != null ? parent.nodes.indexOf(that) + 1 : 1;
    }

    @Override
    public boolean isNode() {
        return true;
    }

    @Override
    public boolean isDocument() {
        return false;
    }

    @Override
    protected HashMap<RectF, Container> drawElements(Canvas canvas, Paint injectPaint, GridManager manager, Paint fontPaint, List<Container> list) {
        HashMap<RectF, Container> result = new HashMap<>();
        int row = 1;
        int cell = 0;
        int index = 0;
        for (Container container : list) {
            index++;
            RectF tile = manager.getMergeRect(cell, row, cell + container.getWidth(), row + container.getHeight());
            Paint back = new Paint();
            back.setStyle(Paint.Style.FILL);
            back.setColor(Color.WHITE);
            back.setShadowLayer(tile.height() / 30, 0, 0, Color.GRAY);
            RectF body = new RectF(tile.left + tile.width() / 10, tile.top + tile.width() / 20, tile.right - tile.width() / 10, tile.bottom - tile.width() / 20);

            if (container.isDocument()) {
                body = G.shrinkRectF(body, 8, 1);
            }
            Grid contents = G.getHorizontalLines(body, body.height() / (container.isNode() ? 3 : 12));

            canvas.drawRect(body, back);
            if (container.isNode()) {
                canvas.drawRect(contents.get(0), injectPaint);

                TextHelper.drawTextLeft(canvas, ((Node) container).getTitle(), contents.get(0), 0, fontPaint);
                result.put(tile, ((Node) container).parent(this));
            } else if (container.isDocument()) {

                canvas.drawRect(body, injectPaint);

                TextHelper.drawText(canvas, Integer.toString(index), body, 1, fontPaint);
                result.put(tile, container);

            }


            cell = cell + container.getWidth() + 1;
            if (cell > manager.getHorizontal().size() - (container.getWidth() + 1)) {
                row = row + container.getHeight() + 1;
                cell = 0;
            }
        }
        return result;
    }
}
