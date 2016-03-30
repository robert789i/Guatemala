package gt.tics.intecap.guatemala;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

    private String clases[] = {
        "StartingPoint", "TextoPlay", "Email",
        "Camara", "Ejemplo5", "Ejemplo6"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter
                <String>(
                Menu.this,
                android.R.layout.simple_list_item_1,
                clases));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String interno = clases[position];
        try {
            Class miClase = Class.forName("gt.tics.intecap.guatemala." + interno);
            Intent miIntento = new Intent(Menu.this, miClase);
            startActivity(miIntento);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}