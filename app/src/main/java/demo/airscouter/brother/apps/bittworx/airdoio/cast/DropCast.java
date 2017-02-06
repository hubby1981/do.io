package demo.airscouter.brother.apps.bittworx.airdoio.cast;

/**
 * Created by marcel.weissgerber on 06.02.2017.
 */

public interface DropCast {

    <T> void cast(T contents,CastToken token);
    void cancel(CastToken token);
    CastToken start();

}
