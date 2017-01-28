package ayoub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kamran.loginsignupmix.R;

public class signup extends AppCompatActivity {
    private TextView sup,act,sin,fbook;
    private EditText usrusr,pswd,mail;
    MyDBHandler myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        sup = (TextView)findViewById(R.id.sup);
        sin = (TextView)findViewById(R.id.sin);
        //fbook = (TextView)findViewById(R.id.fboook);
        act = (TextView)findViewById(R.id.bb2);
        mail = (EditText)findViewById(R.id.mal);
        pswd = (EditText)findViewById(R.id.pswd);
        usrusr = (EditText)findViewById(R.id.usrusr);
        myDB = new MyDBHandler(this, null, null, 1);


        sin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(signup.this, login.class);
                startActivity(it);
            }
        });
        act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = usrusr.getText().toString();
                String email = mail.getText().toString();
                String pass = pswd.getText().toString();
                //Toast.makeText(signup.this, "CREAT THIS USER!!!", Toast.LENGTH_SHORT).show();
                Student s = new Student(name, email, pass);
                if(name.equals("") || email.equals("") || pass.equals("")) {
                    Toast.makeText(signup.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    myDB.addStudent(s);
                    Toast.makeText(signup.this, "The user has been added successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
