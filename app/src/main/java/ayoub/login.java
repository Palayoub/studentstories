package ayoub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kamran.loginsignupmix.R;

public class login extends AppCompatActivity
{
    private TextView fbook,acc,sin,sup, sinnp;
    private EditText mal,pswd;
    MyDBHandler myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sup = (TextView)findViewById(R.id.sup);
        sin = (TextView)findViewById(R.id.sin);
        //fbook = (TextView)findViewById(R.id.fboook);
        acc = (TextView)findViewById(R.id.bb2);
        mal = (EditText)findViewById(R.id.mal);
        pswd = (EditText)findViewById(R.id.pswd);
        sinnp = (TextView) findViewById(R.id.sinnp);
        myDB = new MyDBHandler(this, null, null, 1);
        sup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(login.this, signup.class);
                startActivity(it);
            }
        });
        sinnp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(login.this, Welcome.class);
                if (myDB.CheckIfExists(mal.getText().toString(), pswd.getText().toString())) {
                    it.putExtra("username", mal.getText().toString());
                    startActivity(it);
                }
                else {
                    Toast.makeText(login.this, "Username or password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
