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
import android.view.View;

import demo.airscouter.brother.apps.bittworx.airdoio.C;
import demo.airscouter.brother.apps.bittworx.airdoio.MainActivity;
import demo.airscouter.brother.apps.bittworx.airdoio.R;

/**
 * Created by marce on 07.02.2017.
 */

public class StartupView extends View {
    private Paint backgroudPaint = new Paint();
    private Paint tileBackground = new Paint();
    private Paint fontBackground = new Paint();
    private Bitmap scenario0Bitmap;
    private Bitmap scenario1Bitmap;
    private Bitmap scenario2Bitmap;

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


    @Override
    public void onDraw(Canvas canvas) {

        Rect bounds = canvas.getClipBounds();

        canvas.drawRect(bounds, backgroudPaint);
        drawButtons(canvas, bounds);

    }


    private void drawButtons(Canvas canvas, Rect rc) {

        float h = rc.height() / 6;
        float w = rc.width() / 10;

        tileBackground.setShadowLayer(w / 20, 0, 0, Color.BLACK);
        fontBackground.setShadowLayer(w / 20, 0, 0, Color.BLACK);


        scenario0 = new RectF(rc.exactCenterX() - (w * 4), rc.exactCenterY() - (h), rc.exactCenterX() - (w * 2), rc.exactCenterY() + (h));
        scenario1 = new RectF(rc.exactCenterX() - (w * 1), rc.exactCenterY() - (h), rc.exactCenterX() + (w * 1), rc.exactCenterY() + (h));
        scenario2 = new RectF(rc.exactCenterX() + (w * 2), rc.exactCenterY() - (h), rc.exactCenterX() + (w * 4), rc.exactCenterY() + (h));

        canvas.drawRoundRect(scenario0, w / 10, w / 10, tileBackground);
        canvas.drawRoundRect(scenario1, w / 10, w / 10, tileBackground);
        canvas.drawRoundRect(scenario2, w / 10, w / 10, tileBackground);

        float sizeBit = scenario0.width() / 4;
        RectF bitmapScenario0 = new RectF(scenario0.centerX() - sizeBit, scenario0.centerY() - (sizeBit * 1.5f), scenario0.centerX() + sizeBit, scenario0.centerY() + (sizeBit * 0.5f));
        scenario0Bitmap = BitmapFactory.decodeResource(MainActivity.res, R.drawable.medical);
        canvas.drawBitmap(scenario0Bitmap, new Rect(0, 0, scenario0Bitmap.getWidth(), scenario0Bitmap.getHeight()), bitmapScenario0, null);

        RectF bitmapScenario1 = new RectF(scenario1.centerX() - sizeBit, scenario1.centerY() - (sizeBit * 1.5f), scenario1.centerX() + sizeBit, scenario1.centerY() + (sizeBit * 0.5f));
        scenario1Bitmap = BitmapFactory.decodeResource(MainActivity.res, R.drawable.enterprise);
        canvas.drawBitmap(scenario1Bitmap, new Rect(0, 0, scenario1Bitmap.getWidth(), scenario1Bitmap.getHeight()), bitmapScenario1, null);

        RectF bitmapScenario2 = new RectF(scenario2.centerX() - sizeBit, scenario2.centerY() - (sizeBit * 1.5f), scenario2.centerX() + sizeBit, scenario2.centerY() + (sizeBit * 0.5f));
        scenario2Bitmap = BitmapFactory.decodeResource(MainActivity.res, R.drawable.finance);
        canvas.drawBitmap(scenario2Bitmap, new Rect(0, 0, scenario2Bitmap.getWidth(), scenario2Bitmap.getHeight()), bitmapScenario2, null);

        fontBackground.setTextSize(scenario0.height() / 7);
        float sizeT = fontBackground.measureText("MEDICAL");
        float yText = scenario0.centerY() + sizeT / 2f;
        canvas.drawText("MEDICAL", scenario0.centerX() - sizeT / 2, yText, fontBackground);
        sizeT = fontBackground.measureText("ENTERPRISE");
        canvas.drawText("ENTERPRISE", scenario1.centerX() - sizeT / 2, yText, fontBackground);
        sizeT = fontBackground.measureText("FINANCE");
        canvas.drawText("FINANCE", scenario2.centerX() - sizeT / 2, yText, fontBackground);

    }
}
