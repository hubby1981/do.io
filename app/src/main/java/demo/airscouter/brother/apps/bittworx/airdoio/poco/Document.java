package demo.airscouter.brother.apps.bittworx.airdoio.poco;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import demo.airscouter.brother.apps.bittworx.airdoio.data.BaseDataObject;
import demo.airscouter.brother.apps.bittworx.airdoio.data.DbField;
import demo.airscouter.brother.apps.bittworx.airdoio.data.DbTable;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.DateHelper;
import demo.airscouter.brother.apps.bittworx.airdoio.view.manager.GridManager;

/**
 * Created by marcel.weissgerber on 08.02.2017.
 */

@DbTable(name = "document")
public class Document extends Container {

    @DbField(name = "id")
    private UUID id;

    @DbField(name = "name")
    private String name="";

    @DbField(name="version")
    private float version=1.0f;

    @DbField(name="created")
    private String created;

    @DbField(name="updated")
    private String updated;


    public Document(){
        id=UUID.randomUUID();
        created = DateHelper.getDateTime();
    }

    public Document(String name){
        this();
        this.name = name;
    }

    public Document(String name,float version){
        this(name);
        this.version = version;
    }

    @Override
    protected void imported() {

    }
    public int getHeight(){
        return 2;
    }

    public String getUpdated() {
        return updated;
    }

    public String getCreated() {
        return created;
    }

    public String getVersion() {
        return Float.toString(version);
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean isNode() {
        return false;
    }

    @Override
    public boolean isDocument() {
        return true;
    }

    @Override
    protected HashMap<RectF, Container> drawElements(Canvas canvas, Paint injectPaint, GridManager manager, Paint fontPaint, List<Container> list) {
        return null;
    }


    @Override
    public HashMap<RectF, Container> draw(Canvas canvas, Paint injectPaint, GridManager manager, Paint fontPaint) {
        return null;
    }
}
