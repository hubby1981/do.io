package demo.airscouter.brother.apps.bittworx.airdoio.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import demo.airscouter.brother.apps.bittworx.airdoio.helper.C;
import demo.airscouter.brother.apps.bittworx.airdoio.EnterpriseActivity;
import demo.airscouter.brother.apps.bittworx.airdoio.FinanceActivity;
import demo.airscouter.brother.apps.bittworx.airdoio.MainActivity;
import demo.airscouter.brother.apps.bittworx.airdoio.MedicalActivity;
import demo.airscouter.brother.apps.bittworx.airdoio.R;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.TE;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.TextHelper;

/**
 * Created by marce on 07.02.2017.
 */

public class StartupView extends View {
    private Paint backgroudPaint = new Paint();
    private Paint tileBackground = new Paint();
    private Paint fontBackground = new Paint();
    private MainActivity activity;

    RectF scenario0;
    RectF scenario1;
    RectF scenario2;

    public StartupView(Context context, AttributeSet attrs) {
        super(context, attrs);

        backgroudPaint.setStyle(Paint.Style.FILL);
        backgroudPaint.setColor(Color.WHITE);

        tileBackground.setStyle(Paint.Style.FILL);
        tileBackground.setColor(C.blueLight);

        fontBackground.setStyle(Paint.Style.FILL);
        fontBackground.setColor(Color.WHITE);

        setLayerType(LAYER_TYPE_SOFTWARE, null);

    }

    public void setMainActivity(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN && activity != null) {
            if (scenario0.contains(event.getX(), event.getY())) {

                activity.startIntent(MedicalActivity.class);

            }
            if (scenario1.contains(event.getX(), event.getY())) {

                activity.startIntent(EnterpriseActivity.class);

            }
            if (scenario2.contains(event.getX(), event.getY())) {

                activity.startIntent(FinanceActivity.class);

            }
        }
        return false;
    }

    @Override
    public void onDraw(Canvas canvas) {

        Rect bounds = canvas.getClipBounds();
        canvas.drawRect(bounds, backgroudPaint);

        drawTitleArea(canvas, bounds);
        drawFooterArea(canvas, bounds);
        drawTileSampleScenario(canvas, bounds);


    }

    private void drawTitleArea(Canvas canvas, Rect bounds) {
        RectF title = new RectF(bounds.left, bounds.top, bounds.right, bounds.top + bounds.height() / 3);
        fontBackground.setTextSize(title.height() / 5);
        fontBackground.setColor(Color.BLACK);


        TextHelper.drawText(canvas, R.string.sample_view_title, title, 1.8f,fontBackground);

        RectF logo = new RectF(title.centerX() - title.width() / 10, title.top + title.height() / 8, title.centerX() + title.width() / 10, (title.height() / 2) + title.height() / 10);

        Bitmap logoBitmap = BitmapFactory.decodeResource(MainActivity.res, R.drawable.doio);
        canvas.drawBitmap(logoBitmap, new Rect(0, 0, logoBitmap.getWidth(), logoBitmap.getHeight()), logo, null);
    }

    private void drawFooterArea(Canvas canvas, Rect bounds) {
        RectF footer = new RectF(bounds.left, bounds.bottom - bounds.height() / 4, bounds.right, bounds.bottom);

        RectF logo = new RectF(footer.centerX() - footer.width() / 6, footer.top + footer.height() / 3, footer.centerX() + footer.width() / 6, footer.bottom - (footer.height() / 8));

        Bitmap logoBitmap = BitmapFactory.decodeResource(MainActivity.res, R.drawable.brother);
        canvas.drawBitmap(logoBitmap, new Rect(0, 0, logoBitmap.getWidth(), logoBitmap.getHeight()), logo, null);

    }


    private void drawTileSampleScenario(Canvas canvas, Rect rc) {

        float h = rc.height() / 6.5f;
        float w = rc.width() / 10;
        fontBackground.setColor(Color.WHITE);

        tileBackground.setShadowLayer(w / 20, 0, 0, Color.BLACK);
        fontBackground.setShadowLayer(w / 25, 0, 0, Color.BLACK);

        scenario0 = new RectF(rc.exactCenterX() - (w * 4), rc.exactCenterY() - (h), rc.exactCenterX() - (w * 1.5f), rc.exactCenterY() + (h * 1.5f));
        scenario1 = new RectF(rc.exactCenterX() - (w * 1.25f), rc.exactCenterY() - (h), rc.exactCenterX() + (w * 1.25f), rc.exactCenterY() + (h * 1.5f));
        scenario2 = new RectF(rc.exactCenterX() + (w * 1.5f), rc.exactCenterY() - (h), rc.exactCenterX() + (w * 4), rc.exactCenterY() + (h * 1.5f));

        canvas.drawRoundRect(scenario0, w / 10, w / 10, tileBackground);
        canvas.drawRoundRect(scenario1, w / 10, w / 10, tileBackground);
        canvas.drawRoundRect(scenario2, w / 10, w / 10, tileBackground);

        float sizeBit = scenario0.width() / 4;
        drawImage(canvas, sizeBit, scenario0, R.drawable.medical, 0);
        drawImage(canvas, sizeBit, scenario1, R.drawable.enterprise, 0);
        drawImage(canvas, sizeBit, scenario2, R.drawable.finance, 0);

        fontBackground.setTextSize(scenario0.height() / 7);

        TextHelper.drawText(canvas, R.string.sample_medical, scenario0, 2, fontBackground);
        TextHelper.drawText(canvas, R.string.sample_enterprise, scenario1, 2, fontBackground);
        TextHelper.drawText(canvas, R.string.sample_finance, scenario2, 2, fontBackground);

        fontBackground.setTextSize(scenario0.height() / 9);
        TextHelper.drawText(canvas, R.string.sample_text, scenario0, 4, fontBackground);
        TextHelper.drawText(canvas, R.string.sample_text, scenario1, 4, fontBackground);
        TextHelper.drawText(canvas, R.string.sample_text, scenario2, 4, fontBackground);


    }


    private void drawImage(Canvas canvas, float sizeBit, RectF scenario, int bitmapRes, float factor) {
        float sizeBitX = sizeBit;
        if (factor > 0) {
            sizeBitX = (sizeBitX / factor);
        }
        RectF bitmapScenario0 = new RectF(scenario.centerX() - sizeBitX, scenario.centerY() - (sizeBit * 1.5f), scenario.centerX() + sizeBitX, scenario.centerY() + (sizeBit * 0.5f));
        Bitmap scenarioBitmap = BitmapFactory.decodeResource(MainActivity.res, bitmapRes);
        canvas.drawBitmap(scenarioBitmap, new Rect(0, 0, scenarioBitmap.getWidth(), scenarioBitmap.getHeight()), bitmapScenario0, null);
    }
}
