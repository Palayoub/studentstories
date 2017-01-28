package ayoub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.kamran.loginsignupmix.R;

import java.util.ArrayList;

public class Read extends AppCompatActivity {
    MyDBHandler myDB = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        myDB = new MyDBHandler(this, null, null, 1);
        ListView list = (ListView) findViewById(R.id.listView);
        ArrayList<String> authors = myDB.databaseToString().get(0);
        ArrayList<String> subjects = myDB.databaseToString().get(1);
        ArrayList<String> contents = myDB.databaseToString().get(2);
        ArrayList<String> likes = myDB.databaseToString().get(3);
        ListAdapter adapter = new CustomAd(this, authors, subjects, contents, likes);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = String.valueOf(parent.getItemAtPosition(position));
                Intent i = new Intent(Read.this, PostView.class);
                i.putExtra("content", s);
                startActivity(i);
            }
        });
    }
}
