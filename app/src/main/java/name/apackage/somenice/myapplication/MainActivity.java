package name.apackage.somenice.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    public TextView weather_i; //declaring a private variable of typle textview
    private EditText searchurl;
    private TextView msearchresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);//this line will set the layout for this activity
        weather_i = (TextView)findViewById(R.id.weather);
        searchurl=(EditText)findViewById(R.id.msearchurl);
        msearchresult=(TextView)findViewById(R.id.searchresult);
        makeSearch();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int itemThatWasClickedId= item.getItemId();
        if (itemThatWasClickedId == R.id.action_settings) {
            Context context = MainActivity.this;
            String textToShow = "Search clicked";
            Toast.makeText(context, textToShow, Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);


    }

    }

    private void makeSearch() {

        String msearch = searchurl.getText().toString();
        URL weatherurl = NetworkUtils.buildUrl(msearch);
        msearchresult.setText(weatherurl.toString());
        String msearchresult= null;
        new FetchWeatherTask().execute(weatherurl);

    }
    }

public class FetchWeatherTask extends AsyncTask<URL,Void,String> {
    @Override
    protected String doInBackground(URL... params) {
        URL[] urls;
        URL searchurl = urls[0];
        String weather_i = null;
        try {
            weather_i = NetworkUtils.getResponseFromHttpUrl(searchurl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
       }
        @Override
protected void onPostExecute(String s) {
        if(s!=null && !s.equals("")) {
        msearchresult.setText(s);

        }


        }


    }

}



