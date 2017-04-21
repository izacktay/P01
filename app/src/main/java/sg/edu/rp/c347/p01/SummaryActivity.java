package sg.edu.rp.c347.p01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        //create one textview
        TextView tv = (TextView) findViewById(R.id.tvSummary);

        Intent i = getIntent();
        //get questions and info from prev intent
        String [] questions = i.getStringArrayExtra("questions");
        String [] info = i.getStringArrayExtra("info");

        // append text to the tv
        for (int x = 0; x <= 3; x++){
            tv.append(questions[x] + ": " + info[x] + "\n\n");
        }

    }
}
