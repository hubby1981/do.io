package demo.airscouter.brother.apps.bittworx.airdoio.poco.enterprise;

import java.util.List;

import demo.airscouter.brother.apps.bittworx.airdoio.poco.Container;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.Document;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.Node;

/**
 * Created by marcel.weissgerber on 10.02.2017.
 */

public class ProjectNode extends Node {

    public ProjectNode() {
        super();
    }

    public ProjectNode(String title, List<Container> nodes) {
        super(title, nodes);
    }

    public ProjectNode(String title, List<Container> nodes, List<Container> documents) {
        super(title, nodes, documents);
    }


    @Override
    public int getWidth() {
        return 2;
    }

    @Override
    public int getHeight() {
        return 2;
    }
}
