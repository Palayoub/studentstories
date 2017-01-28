package ayoub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kamran.loginsignupmix.R;

public class Share extends AppCompatActivity {

    TextView tt1 = null;
    TextView tt3 = null;
    TextView tt4 = null;
    EditText ed1 = null;
    Button bb1 = null;
    Button bb2 = null;
    MyDBHandler myDB = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        tt1 = (TextView) findViewById(R.id.tt1);
        tt3 = (TextView) findViewById(R.id.tt3);
        tt4 = (TextView) findViewById(R.id.tt4);
        ed1 = (EditText) findViewById(R.id.ed1);
        bb1 = (Button) findViewById(R.id.bb1);
        bb2 = (Button) findViewById(R.id.bb2);
        myDB = new MyDBHandler(this, null, null, 1);
        bb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Post p = new Post(Integer.parseInt(getIntent().getExtras().getString("fk")), ed1.getText().toString(),tt4.getText().toString());
                myDB.addPost(p);
                //Toast.makeText(Share.this, getIntent().getExtras().getString("fk"), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Share.this, Read.class);
                i.putExtra("fk", getIntent().getExtras().getString("fk"));
                startActivity(i);
                Toast.makeText(Share.this, "Thank you for sharing your story!", Toast.LENGTH_SHORT).show();
                ed1.setText(""); tt4.setText("");
            }
        });
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Share.this, ed1.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
