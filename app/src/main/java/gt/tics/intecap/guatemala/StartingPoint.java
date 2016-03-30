package gt.tics.intecap.guatemala;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartingPoint extends Activity {

    private TextView mostrar;
    private Button agregar, restar;
    private int contador;

    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_main);

        iniciaVars();
    }

    private void iniciaVars() {
        contador = 0;
        mostrar = (TextView) findViewById(R.id.tvMostrar);
        agregar = (Button) findViewById(R.id.bAgregar);
        restar = (Button) findViewById(R.id.bRestar);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                mostrar.setText("El total es " + contador);
            }
        });
        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador--;
                mostrar.setText("El total es " + contador);

            }
        });
    }
}