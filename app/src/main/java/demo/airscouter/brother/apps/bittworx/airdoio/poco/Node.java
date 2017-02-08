package demo.airscouter.brother.apps.bittworx.airdoio.poco;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.ArrayList;
import java.util.List;

import demo.airscouter.brother.apps.bittworx.airdoio.data.BaseDataObject;
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
public class Node extends BaseDataObject {

    @DbReference(items = Node.class)
    private List<Node> nodes = new ArrayList<>();

    @DbReference(items = Document.class)
    private List<Document> documents = new ArrayList<>();

    @DbTable(name = "title")
    private String title = "";


    private int width = 2;
    private int height = 2;

    public Node() {

    }

    public Node(String title, List<Node> nodes) {
        this.title = title;
        if (nodes != null) {
            this.nodes = nodes;
        }
    }

    public Node(String title, List<Node> nodes, List<Document> documents) {
        this(title, nodes);
        if (documents != null) {
            this.documents = documents;
        }
    }

    @Override
    protected void imported() {

    }

    public void draw(Canvas canvas, Paint injectPaint, GridManager manager, Paint fontPaint) {
        if (nodes != null && nodes.size() > 0) {
            drawNodes(canvas, injectPaint, manager, fontPaint);
        }
        if (documents != null && documents.size() > 0) {
            drawDocuments(canvas, injectPaint, manager, fontPaint);
        }
    }

    protected void drawNodes(Canvas canvas, Paint injectPaint, GridManager manager, Paint fontPaint) {
        int row = 1;
        int cell = 0;
        for (Node node : nodes) {

            RectF tile = manager.getMergeRect(cell, row, cell + width, row + height);
            Paint back = new Paint();
            back.setStyle(Paint.Style.FILL);
            back.setColor(Color.WHITE);
            back.setShadowLayer(tile.height() / 30, 0, 0, Color.BLACK);
            RectF body = new RectF(tile.left + tile.width() / 10, tile.top + tile.width() / 20, tile.right - tile.width() / 10, tile.bottom - tile.width() / 20);
            Grid contents = G.getHorizontalLines(body, body.height() / 3);
            canvas.drawRect(body, back);
            canvas.drawRect(contents.get(0), injectPaint);
            TextHelper.drawTextLeft(canvas, node.getTitle(), contents.get(0), 0, fontPaint);


            cell = cell + width+1;
            if (cell > manager.getHorizontal().size() - width) {
                row = row+height+1;
                cell = 0;
            }
        }

    }

    protected void drawDocuments(Canvas canvas, Paint injectPaint, GridManager manager, Paint fontPaint) {

    }

    public String getTitle() {
        return title;
    }
}
