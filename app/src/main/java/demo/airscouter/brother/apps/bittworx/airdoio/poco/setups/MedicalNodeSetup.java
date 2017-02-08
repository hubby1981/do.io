package demo.airscouter.brother.apps.bittworx.airdoio.poco.setups;

import java.util.ArrayList;
import java.util.List;

import demo.airscouter.brother.apps.bittworx.airdoio.R;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.TE;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.Node;

/**
 * Created by marcel.weissgerber on 08.02.2017.
 */

public class MedicalNodeSetup {


    public static Node getMedicalNodeSample(){
        return new Node(TE.get(R.string.node_workspace),getLevel1());
    }

    private static List<Node> getLevel1(){
        List<Node> result = new ArrayList<>();
        result.add(new Node(TE.get(R.string.node_medical_tree_002),getStations()));
        result.add(new Node(TE.get(R.string.node_medical_tree_003),null));
        result.add(new Node(TE.get(R.string.node_medical_tree_002),null));
        result.add(new Node(TE.get(R.string.node_medical_tree_003),null));
        result.add(new Node(TE.get(R.string.node_medical_tree_003),null));
        return result;
    }

    private static List<Node> getStations(){
        List<Node> result = new ArrayList<>();
        result.add(new Node(TE.get(R.string.node_medical_tree_004),null));
        result.add(new Node(TE.get(R.string.node_medical_tree_005),null));

        return result;
    }
}
