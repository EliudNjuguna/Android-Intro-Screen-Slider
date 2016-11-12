package rhynix.eliud.screenslider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences = getSharedPreferences(Config.FLAG, Context.MODE_PRIVATE);

                if (sharedPreferences.getBoolean(Config.FLAG,true)){

                    startActivity(new Intent(MainActivity.this,DefaultIntro.class));

                    SharedPreferences.Editor e = sharedPreferences.edit();
                    e.apply();
                }
            }
        });

        t.start();
    }
}
