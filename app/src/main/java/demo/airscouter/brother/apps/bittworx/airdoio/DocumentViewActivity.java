package demo.airscouter.brother.apps.bittworx.airdoio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;

import demo.airscouter.brother.apps.bittworx.airdoio.poco.Document;
import demo.airscouter.brother.apps.bittworx.airdoio.view.DocumentView;

public class DocumentViewActivity extends AppCompatActivity {

    Runnable refreshAction = new Runnable() {
        @Override
        public void run() {
            View v = findViewById(R.id.viewDoc);
            if (v != null) {
                try {
                    v.invalidate();
                } catch (Exception e) {

                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_view);

        View view = findViewById(R.id.viewDoc);
        if (view != null) {
            ((DocumentView) view).setActivity(this);
        }


    }


    public void close() {
        this.finish();
    }

    public void refresh() {
        runOnUiThread(refreshAction);
    }


}
