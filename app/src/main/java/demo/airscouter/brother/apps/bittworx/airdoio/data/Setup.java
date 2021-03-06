package demo.airscouter.brother.apps.bittworx.airdoio.data;

import java.util.ArrayList;
import java.util.List;

import demo.airscouter.brother.apps.bittworx.airdoio.poco.Document;


/**
 * Created by marcel.weissgerber on 09.05.2016.
 */
public class Setup {
    private List<Class> tables;
    private SecureDataSetup secure;

    public Setup() {
        secure = new SecureDataSetup();
        tables = new ArrayList<>();

///TODO: tables to add

        tables.add(Document.class);
    }

    public SecureDataSetup secure() {
        return secure;
    }

    public List<String> getCreateTables() {
        List<String> result = new ArrayList<>();
        for (Class c : tables) {
            String statement = ObjectHelper.createTableStatement(c);
            if (statement != null)
                result.add(statement);
            List<String> refs = ObjectHelper.createReferenceTableStatement(c);
            for (String s : refs)
                if (s != null)
                    result.add(s);
        }
        return result;
    }

    public List<String> getDropTables() {
        List<String> result = new ArrayList<>();
        for (Class c : tables) {
            String statement = ObjectHelper.createDropTableStatement(c);
            if (statement != null)
                result.add(statement);
            List<String> refs = ObjectHelper.createDropReferenceTableStatement(c);
            for (String s : refs)
                if (s != null)
                    result.add(s);
        }
        return result;
    }
}
