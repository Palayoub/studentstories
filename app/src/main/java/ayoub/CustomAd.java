package ayoub;

/**
 * Created by ayoub on 27/01/2017.
 */


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kamran.loginsignupmix.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by ayoub on 17/01/2017.
 */

public class CustomAd extends ArrayAdapter<String> {
    private ArrayList<String> authors;
    private ArrayList<String> subjects;
    private ArrayList<String> likes;
    public CustomAd(Context context, ArrayList<String> authors, ArrayList<String> subjects, ArrayList<String> contents, ArrayList<String> likes) {
        super(context, R.layout.custom_row, contents);
        //this.names1 = names1;
        this.authors = authors;
        this.subjects = subjects;
        this.likes = likes;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inf = LayoutInflater.from(getContext());
        View customView = inf.inflate(R.layout.custom_row, parent, false);

        String sContents = getItem(position);
        TextView t1 = (TextView) customView.findViewById(R.id.textView1);
        TextView t2 = (TextView) customView.findViewById(R.id.textView2);
        TextView t3 = (TextView) customView.findViewById(R.id.textView3);
        TextView t4 = (TextView) customView.findViewById(R.id.textView4);
        ImageView img = (ImageView) customView.findViewById(R.id.imageView6);

        t1.setText(subjects.get(position).substring(0, Math.min(subjects.get(position).length(), 20)));
        t2.setText(sContents.substring(0, Math.min(sContents.length(), 40)));
        t3.setText(authors.get(position));
        t4.setText(likes.get(position));
        if(position%2 == 0) {
            img.setImageResource(R.drawable.row);
        }
        else {
            img.setImageResource(R.drawable.row1);
        }
        return customView;
    }
}
