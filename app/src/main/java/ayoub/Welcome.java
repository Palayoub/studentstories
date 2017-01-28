package ayoub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kamran.loginsignupmix.R;

public class Welcome extends AppCompatActivity {

    Button bb1 = null;
    Button bb2 = null;
    MyDBHandler myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        myDB = new MyDBHandler(this, null, null, 1);
        bb1 = (Button) findViewById(R.id.bb1);
        bb2 = (Button) findViewById(R.id.bb2);
        bb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Welcome.this, Share.class);
                int fk = myDB.getId(getIntent().getExtras().getString("username"));
                it.putExtra("fk", fk + "");
                startActivity(it);
            }
        });
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Welcome.this, Read.class);
                int fk = myDB.getId(getIntent().getExtras().getString("username"));
                it.putExtra("fk", fk + "");
                startActivity(it);
            }
        });
    }
}
