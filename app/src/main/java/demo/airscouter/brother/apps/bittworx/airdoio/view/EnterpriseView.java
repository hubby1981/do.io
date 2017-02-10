package demo.airscouter.brother.apps.bittworx.airdoio.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import demo.airscouter.brother.apps.bittworx.airdoio.R;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.B;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.C;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.TE;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.Node;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.setups.EnterpriseNodeSetup;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.setups.MedicalNodeSetup;

/**
 * Created by marcel.weissgerber on 08.02.2017.
 */

public class EnterpriseView extends BaseView {
    private Paint headerPaint = new Paint();
    private Paint toolbarPaint = new Paint();
    private int access = 2;

    public EnterpriseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        headerPaint.setStyle(Paint.Style.FILL);
        headerPaint.setColor(Color.argb(255, C.getRedArray()[access], C.getGreenArray()[access], C.getBlueArray()[access]));

        toolbarPaint.setStyle(Paint.Style.FILL);
        toolbarPaint.setColor(Color.argb(150, C.getRedArray()[access], C.getGreenArray()[access], C.getBlueArray()[access]));
        node = EnterpriseNodeSetup.getEnterpriseNodeSample();

    }

    @Override
    protected Paint getHeaderPaint() {
        return headerPaint;
    }

    @Override
    protected Paint getToolbarPaint() {
        return toolbarPaint;
    }

    @Override
    protected int getHeaderTextLine0() {
        return R.string.sample_enterprise_header_line0;
    }

    @Override
    protected int getHeaderTextLine1() {
        return R.string.sample_enterprise_header_line1;
    }

    @Override
    protected Bitmap getLogo() {
        return B.get(R.drawable.enterprise);
    }


}