package gt.tics.intecap.guatemala;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;

public class Splash extends Activity {

    private static final long TIEMPO = 7000;
    private MediaPlayer miCancion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        miCancion = MediaPlayer
                .create(Splash.this, R.raw.fuistetu);
        miCancion.start();

        Thread miHilo = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(TIEMPO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent miIntento =
                            new Intent("gt.tics.intecap.guatemala.MENU");
                    startActivity(miIntento);
                }
            }
        };
        miHilo.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
        miCancion.release();
    }
}