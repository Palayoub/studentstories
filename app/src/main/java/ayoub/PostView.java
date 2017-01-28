package ayoub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.kamran.loginsignupmix.R;

public class PostView extends AppCompatActivity {

    TextView t = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_view);
        t = (TextView) findViewById(R.id.textView8);
        t.setText(getIntent().getExtras().getString("content"));
    }
}
