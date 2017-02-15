package demo.airscouter.brother.apps.bittworx.airdoio.view.content;

import android.graphics.Canvas;
import android.graphics.RectF;

import java.util.ArrayList;
import java.util.List;

import demo.airscouter.brother.apps.bittworx.airdoio.helper.Iter;

/**
 * Created by marcel.weissgerber on 13.02.2017.
 */

public abstract class ElemIter<T> {
    private List<T> list = new ArrayList<>();
    private int area = 0;
    private long period = 0l;

    public ElemIter() {

    }


    public ElemIter(long period) {
        this.period = period;
    }

    public long getPeriod() {
        return period;
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

    public void draw(Canvas canvas,RectF bounds) {
        if (isSingle()) {
            drawElem(get(), canvas,bounds);

        } else {

            for (T t : getAll()) {
                drawElem(t, canvas,bounds);

            }
        }
    }

    public void clearWith(T item) {
        list.clear();
        list.add(item);
        list.set(0, item);
    }
    public int size(){
        return list.size();
    }


    public T get() {
        if (list != null && list.size() > 0 && list.size() > area) {
            return list.get(area);
        }
        return null;
    }

    public List<T> getAll() {

        List<T> result = new ArrayList<>();
        if (isSingle()) {
            result.add(get());
        } else {
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

    public void setArea(int area){
        this.area = area;
        onNext();
    }

    protected abstract void drawElem(T elem, Canvas canvas,RectF bounds);

    public void prev() {
        area = Iter.prev(area, list.size());
        onPrev();
    }

    public void next() {
        area = Iter.next(area, list.size());
        onNext();
    }


    public void onNext() {


    }

    public void onPrev() {

    }


    public void onEnter() {

    }

    public void onLeave() {

    }

}
