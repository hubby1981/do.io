package demo.airscouter.brother.apps.bittworx.airdoio;

import android.app.ActivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import demo.airscouter.brother.apps.bittworx.airdoio.view.BaseView;

/**
 * Created by marcel.weissgerber on 10.02.2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    Runnable refreshAction=new Runnable() {
        @Override
        public void run() {
            View v = findViewById(R.id.mainView);
            if(v!=null){
                try{
                    v.invalidate();
                }catch (Exception e){

                }
            }
        }
    };

    protected abstract  int layoutRes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutRes());

        View v = findViewById(R.id.mainView);
        if(v!=null){
            try{
                ((BaseView)v).setBaseActivity(this);
            }catch (Exception e){

            }
        }
    }

    public void refresh(){
        runOnUiThread(refreshAction);
    }

    public void close(){
        finish();
    }
}
