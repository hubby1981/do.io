package demo.airscouter.brother.apps.bittworx.airdoio.poco;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import demo.airscouter.brother.apps.bittworx.airdoio.data.BaseDataObject;
import demo.airscouter.brother.apps.bittworx.airdoio.data.DbField;
import demo.airscouter.brother.apps.bittworx.airdoio.data.DbTable;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.DateHelper;

/**
 * Created by marcel.weissgerber on 08.02.2017.
 */

@DbTable(name = "document")
public class Document extends BaseDataObject {

    @DbField(name = "id")
    private UUID id;

    @DbField(name = "name")
    private String name="";

    @DbField(name="version")
    private float version=0.0f;

    @DbField(name="created")
    private String created;

    @DbField(name="updated")
    private String updated;


    public Document(){
        id=UUID.randomUUID();
        created = DateHelper.getDateTime();
    }

    @Override
    protected void imported() {

    }

    public String getUpdated() {
        return updated;
    }

    public String getCreated() {
        return created;
    }

    public float getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
