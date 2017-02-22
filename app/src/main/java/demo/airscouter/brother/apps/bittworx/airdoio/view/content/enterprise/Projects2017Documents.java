package demo.airscouter.brother.apps.bittworx.airdoio.view.content.enterprise;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.Toast;

import demo.airscouter.brother.apps.bittworx.airdoio.MainActivity;
import demo.airscouter.brother.apps.bittworx.airdoio.R;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.B;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.G;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.TextHelper;
import demo.airscouter.brother.apps.bittworx.airdoio.view.content.Content;
import demo.airscouter.brother.apps.bittworx.airdoio.view.content.ContentArea;
import demo.airscouter.brother.apps.bittworx.airdoio.view.content.RunableContent;
import demo.airscouter.brother.apps.bittworx.airdoio.view.content.Site;

/**
 * Created by marcel.weissgerber on 13.02.2017.
 */

public class Projects2017Documents {


    public static Site getDoc1() {
        Site result = new Site(10000l);
        result.add(new ContentArea(4, 5).add(1, 2, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {

                TextHelper.drawText(canvas, "Projectmanagement Presentation", bounds, 1, TextHelper.getFont(bounds));
            }
        }));

        result.add(new ContentArea(1, 1).add(0, 0, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {
                Paint p = new Paint();
                p.setStyle(Paint.Style.FILL);
                p.setColor(Color.BLACK);
                canvas.drawRect(bounds, p);
                G.showGrid(canvas,G.getVerticalLines(bounds,bounds.width()/5),Color.WHITE,4);
                G.showGrid(canvas,G.getHorizontalLines(bounds,bounds.height()/2),Color.WHITE,4);

            }
        }));
        result.add(new ContentArea(2, 5).add(0, 0, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {


                B.drawBitmap(canvas, R.drawable.project0000, bounds);
            }
        }));
        result.add(new ContentArea(2, 5).add(0, 1, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {


                B.drawBitmap(canvas, R.drawable.project0001, bounds);
            }
        }));
        result.add(new ContentArea(2, 5).add(0, 2, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {


                B.drawBitmap(canvas, R.drawable.project0002, bounds);
            }
        }));
        result.add(new ContentArea(2, 5).add(0, 3, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {


                B.drawBitmap(canvas, R.drawable.project0003, bounds);
            }
        }));
        result.add(new ContentArea(2, 5).add(0, 4, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {


                B.drawBitmap(canvas, R.drawable.project0004, bounds);
            }
        }));
        result.add(new ContentArea(2, 5).add(1, 0, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {


                B.drawBitmap(canvas, R.drawable.project0005, bounds);
            }
        }));
        result.add(new ContentArea(2, 5).add(1, 1, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {


                B.drawBitmap(canvas, R.drawable.project0006, bounds);
            }
        }));
        result.add(new ContentArea(2, 5).add(1, 2, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {


                B.drawBitmap(canvas, R.drawable.project0007, bounds);
            }
        }));
        result.add(new ContentArea(2, 5).add(1, 3, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {


                B.drawBitmap(canvas, R.drawable.project0008, bounds);
            }
        }));
        result.add(new ContentArea(2, 5).add(1, 4, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {


                B.drawBitmap(canvas, R.drawable.project0009, bounds);
            }
        }));
        result.add(new ContentArea(1,1,true).add(0,0, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {


                Paint p = new Paint();
                p.setStyle(Paint.Style.FILL);
                p.setColor(Color.argb(175,200,200,200));
                canvas.drawRect(bounds, p);
            }
        }));
        result.add(new ContentArea(4, 5).add(1, 2, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {


                TextHelper.drawText(canvas, "Any questions?", bounds, 2, TextHelper.getFont(bounds, Color.BLACK));
            }
        }));
        return result;
    }

    public static Site getDoc2() {
        Site result = new Site();

        result.add(new ContentArea(4, 1).add(0, 0, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {

                TextHelper.drawText(canvas, "2-1", bounds, 1, TextHelper.getFont(bounds));

            }
        }));
        result.add(new ContentArea(4, 1).add(2, 0, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {

                TextHelper.drawText(canvas, "2-2", bounds, 1, TextHelper.getFont(bounds));

            }
        }));
        return result;
    }
}
