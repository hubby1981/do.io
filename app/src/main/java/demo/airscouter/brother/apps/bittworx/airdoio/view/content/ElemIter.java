package demo.airscouter.brother.apps.bittworx.airdoio.view.content;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

import demo.airscouter.brother.apps.bittworx.airdoio.helper.Iter;

/**
 * Created by marcel.weissgerber on 13.02.2017.
 */

public abstract class ElemIter<T> {
    private List<T> list = new ArrayList<>();
    private int area = 0;

    public ElemIter() {

    }

    protected abstract boolean isSingle();

    public ElemIter(List<T> contentAreas) {
        this.list = contentAreas;
    }

    public T add(T area) {
        list.add(area);
        return area;
    }

    public void set(T item) {
        area = list.indexOf(item);
        area = area < 0 ? 0 : area;
    }

    public void draw(Canvas canvas) {
        if(isSingle()){
            drawElem(get(), canvas);

        }else{
            for (T t : getAll()) {
                drawElem(t,canvas);
            }
        }
    }



    public T get() {
        if (list != null && list.size() > 0 && list.size() > area) {
            return list.get(area);
        }
        return null;
    }

    public List<T> getAll(){

        List<T> result=new ArrayList<>();
        if (isSingle())
        {
            result.add(get());
        }else {
            int index = 0;
            for (T t : list) {
                if (area >= index) {
                    result.add(t);
                }
                index++;
            }
        }
        return result;
    }

    protected abstract void drawElem(T elem, Canvas canvas);

    public void prev() {
        area = Iter.prev(area, list.size());
    }

    public void next() {
        area = Iter.next(area, list.size());
    }
}
