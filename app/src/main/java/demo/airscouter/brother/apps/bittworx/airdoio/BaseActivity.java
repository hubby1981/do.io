package demo.airscouter.brother.apps.bittworx.airdoio;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import demo.airscouter.brother.apps.bittworx.airdoio.helper.ContextData;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.Container;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.Document;
import demo.airscouter.brother.apps.bittworx.airdoio.view.BaseView;
import demo.airscouter.brother.apps.bittworx.airdoio.view.content.ElemIter;

/**
 * Created by marcel.weissgerber on 10.02.2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    Runnable refreshAction = new Runnable() {
        @Override
        public void run() {
            View v = findViewById(R.id.mainView);
            if (v != null) {
                try {
                    v.invalidate();
                } catch (Exception e) {

                }
            }
        }
    };

    protected abstract int layoutRes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutRes());

        View v = findViewById(R.id.mainView);
        if (v != null) {
            try {
                ((BaseView) v).setBaseActivity(this);
            } catch (Exception e) {

            }
        }
    }

    public void refresh() {
        runOnUiThread(refreshAction);
    }

    public void close() {
        finish();
    }

    public void openDocument(Document document) {
        ContextData.document.clear();
        for (Container container : document.getParent().getDocuments()) {
            if (container.isDocument())
                if (((Document) container).getSite() != null)
                    ContextData.document.add((Document) container);

        }

        ContextData.document.set(document);
        ContextData.document.onEnter();
        startActivity(new Intent(this, DocumentViewActivity.class));
    }
}
