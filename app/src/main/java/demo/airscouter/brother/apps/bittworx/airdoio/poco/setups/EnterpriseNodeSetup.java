package demo.airscouter.brother.apps.bittworx.airdoio.poco.setups;

import java.util.ArrayList;
import java.util.List;

import demo.airscouter.brother.apps.bittworx.airdoio.R;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.TE;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.Container;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.Document;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.Node;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.enterprise.ProjectNode;
import demo.airscouter.brother.apps.bittworx.airdoio.view.content.enterprise.Projects2017Documents;

/**
 * Created by marcel.weissgerber on 10.02.2017.
 */

public class EnterpriseNodeSetup {

    public static Node getEnterpriseNodeSample(){
        return new Node(TE.get(R.string.node_workspace),getLevel1());
    }

    private static List<Container> getLevel1(){
        List<Container> result = new ArrayList<>();
        result.add(new Node(TE.get(R.string.node_enterprise_tree_001),getProjects()));
        result.add(new Node(TE.get(R.string.node_enterprise_tree_002),null));
        result.add(new Node(TE.get(R.string.node_enterprise_tree_003),null));

        return result;
    }

    private static List<Container> getProjects(){
        List<Container> result = new ArrayList<>();
        result.add(new ProjectNode(TE.get(R.string.node_enterprise_tree_004),null,getDocuments()));
        result.add(new ProjectNode(TE.get(R.string.node_enterprise_tree_005),null));
        result.add(new ProjectNode(TE.get(R.string.node_enterprise_tree_006),null,getDocuments()));
        result.add(new ProjectNode(TE.get(R.string.node_enterprise_tree_007),null));
        result.add(new ProjectNode(TE.get(R.string.node_enterprise_tree_008),null));

        return result;
    }

    private static List<Container> getDocuments(){
        List<Container> result = new ArrayList<>();
        result.add(new Document("1",3.2f).setSite(Projects2017Documents.getDoc1()));
        result.add(new Document("2"));
        result.add(new Document("3"));
        result.add(new Document("4").setSite(Projects2017Documents.getDoc2()));
        result.add(new Document("5",2.3f));
        result.add(new Document("6"));
        result.add(new Document("7"));

        return result;
    }
}
