package demo.airscouter.brother.apps.bittworx.airdoio.view.content.enterprise;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.widget.Toast;

import demo.airscouter.brother.apps.bittworx.airdoio.MainActivity;
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
        Site result = new Site();

        result.add(new ContentArea(4, 4).add(0, 0, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {


                TextHelper.drawText(canvas,"1-1",bounds,1,TextHelper.getFont(bounds));
            }
        }));

        result.add(new ContentArea(4, 4).add(1, 0, new RunableContent() {
            @Override
            protected void drawContent(Canvas canvas, RectF bounds) {
                TextHelper.drawText(canvas,"1-2",bounds,1,TextHelper.getFont(bounds));
            }

            @Override
            protected Runnable getAction() {
                return new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.context,"Test the touch",Toast.LENGTH_SHORT).show();
                    }
                } ;
            }
        }));

        result.add(new ContentArea(4, 4).add(2, 0, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {
                TextHelper.drawText(canvas,"1-3",bounds,1,TextHelper.getFont(bounds));

            }
        }));

        return result;
    }

    public static Site getDoc2() {
        Site result = new Site();

        result.add(new ContentArea(4, 1).add(0, 0, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {

                TextHelper.drawText(canvas,"2-1",bounds,1,TextHelper.getFont(bounds));

            }
        }));
        result.add(new ContentArea(4, 1).add(2, 0, new Content() {
            @Override
            public void draw(Canvas canvas, RectF bounds) {

                TextHelper.drawText(canvas,"2-2",bounds,1,TextHelper.getFont(bounds));

            }
        }));
        return result;
    }
}
