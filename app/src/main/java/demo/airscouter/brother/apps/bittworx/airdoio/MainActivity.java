package demo.airscouter.brother.apps.bittworx.airdoio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import demo.airscouter.brother.apps.bittworx.airdoio.cast.CastToken;
import demo.airscouter.brother.apps.bittworx.airdoio.cast.DropCast;
import demo.airscouter.brother.apps.bittworx.airdoio.cast.MockCast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        DropCast cast  = new MockCast();
        CastToken token = cast.start();


        boolean ret = token.isValid();
        ret = token.isValid();
    }
}
