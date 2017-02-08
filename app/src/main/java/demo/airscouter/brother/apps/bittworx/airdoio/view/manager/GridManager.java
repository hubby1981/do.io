package demo.airscouter.brother.apps.bittworx.airdoio.view.manager;

import android.graphics.RectF;

import java.util.ArrayList;

/**
 * Created by marcel.weissgerber on 08.02.2017.
 */

public class GridManager {

    private Grid vertical;
    private Grid horizontal;
    private Grid toolbar;

    public GridManager(Grid vertical, Grid horizontal, Grid toolbar) {

        this.vertical = vertical;
        this.horizontal = horizontal;
        this.toolbar = toolbar;
    }

    public Grid getVertical() {
        return vertical;
    }

    public Grid getHorizontal() {
        return horizontal;
    }

    public RectF getMergeRect(int vertical,int horizontal){
        RectF v = this.vertical.size()>vertical?this.vertical.get(vertical):this.vertical.get(this.vertical.size()-1);
        RectF h = this.horizontal.size()>horizontal?this.horizontal.get(horizontal):this.horizontal.get(this.horizontal.size()-1);

        return new RectF(v.left,h.top,v.right,h.bottom);
    }

    public RectF getMergeRect(int vertical,int horizontal,int vertical2,int horizontal2){
        RectF v = this.vertical.size()>vertical?this.vertical.get(vertical):this.vertical.get(this.vertical.size()-1);
        RectF h = this.horizontal.size()>horizontal?this.horizontal.get(horizontal):this.horizontal.get(this.horizontal.size()-1);
        RectF v2 = this.vertical.size()>vertical2?this.vertical.get(vertical2):this.vertical.get(this.vertical.size()-1);
        RectF h2 = this.horizontal.size()>horizontal2?this.horizontal.get(horizontal2):this.horizontal.get(this.horizontal.size()-1);

        return new RectF(v.left,h.top,v2.right,h2.bottom);
    }
}
