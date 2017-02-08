package demo.airscouter.brother.apps.bittworx.airdoio;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import demo.airscouter.brother.apps.bittworx.airdoio.cast.CastToken;
import demo.airscouter.brother.apps.bittworx.airdoio.cast.DropCast;
import demo.airscouter.brother.apps.bittworx.airdoio.cast.MockCast;
import demo.airscouter.brother.apps.bittworx.airdoio.data.DbHelper;
import demo.airscouter.brother.apps.bittworx.airdoio.view.StartupView;

public class MainActivity extends AppCompatActivity {
    public static Resources res;
    public static DbHelper DATA;
    public final static boolean TRANSPARENT=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        res = getResources();
        DATA = new DbHelper(this);
        setContentView(R.layout.activity_main);

        DropCast cast = new MockCast();
        CastToken token = cast.start();


        boolean ret = token.isValid();
        ret = token.isValid();

        StartupView view =(StartupView)findViewById(R.id.view);
        view.setMainActivity(this);
    }


    public void startIntent(Class intentClass){
        Intent intent = new Intent(this,intentClass);
        startActivity(intent);
    }
}
