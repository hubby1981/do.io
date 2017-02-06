package demo.airscouter.brother.apps.bittworx.airdoio.cast;

/**
 * Created by marcel.weissgerber on 06.02.2017.
 */

public final class CastToken {
    private long duration;
    private long stamp;


    private CastToken(long duration) {
        this.duration = duration * 1000;
        this.stamp = System.currentTimeMillis();
    }

    public static CastToken create(long duration) {
        return new CastToken(duration);
    }

    public boolean isValid() {
        return (stamp + duration) > System.currentTimeMillis();
    }
}
