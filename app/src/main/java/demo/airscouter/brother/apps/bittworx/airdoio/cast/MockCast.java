package demo.airscouter.brother.apps.bittworx.airdoio.cast;

/**
 * Created by marcel.weissgerber on 06.02.2017.
 */

public class MockCast implements DropCast {
    private boolean cast = false;

    @Override
    public <T> void cast(T contents, CastToken token) {
        if (token != null && token.isValid()) {
            //provide the content for the service to cast to AiRScouter HDMI
        }
    }

    @Override
    public void cancel(CastToken token) {
        if (token != null && token.isValid()) {
            cast = false;
        }
    }

    @Override
    public CastToken start() {
        cast = true;
        return CastToken.create(5);
    }
}
