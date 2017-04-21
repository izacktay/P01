package sg.edu.rp.c347.p01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioGroup rgRead = (RadioGroup) findViewById(R.id.rgRead);
        final RadioGroup rgTime = (RadioGroup) findViewById(R.id.rgTime);
        final RadioGroup rgProblem = (RadioGroup) findViewById(R.id.rgProblem);
        final EditText etReflect = (EditText) findViewById(R.id.etReflection);

        //get saved info
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        int read = prefs.getInt("read", 0);
        int time = prefs.getInt("time", 0);
        int problem = prefs.getInt("problem", 0);
        String reflect = prefs.getString("reflect", "");

        //set the radio button and reflection
        rgRead.check(read);
        rgTime.check(time);
        rgProblem.check(problem);
        etReflect.setText(reflect);

        Button btnOk = (Button) findViewById(R.id.btnOK);
        btnOk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // rgRead
                int rgReadSelected = rgRead.getCheckedRadioButtonId();
                RadioButton rbRead = (RadioButton) findViewById(rgReadSelected);
                TextView tvRead = (TextView) findViewById(R.id.tvRead);

                // rgTime
                int rgTimeSelected = rgTime.getCheckedRadioButtonId();
                RadioButton rbTime = (RadioButton) findViewById(rgTimeSelected);
                TextView tvTime = (TextView) findViewById(R.id.tvTime);

                // rgProblem
                int rgProblemSelected = rgProblem.getCheckedRadioButtonId();
                RadioButton rbProblem = (RadioButton) findViewById(rgProblemSelected);
                TextView tvProblem = (TextView) findViewById(R.id.tvProblem);

                //edit Text reflection
                TextView tvReflect = (TextView) findViewById(R.id.tvReflection);

                //put question into array
                String[] questions = {tvRead.getText().toString(), tvTime.getText().toString(), tvProblem.getText().toString(), tvReflect.getText().toString()};

                // put info into array
                String[] summaryInfo = {rbRead.getText().toString(), rbTime.getText().toString(), rbProblem.getText().toString(), etReflect.getText().toString()};


                // start new intent: Summary
                Intent i = new Intent(MainActivity.this, SummaryActivity.class);
                i.putExtra("info", summaryInfo);
                i.putExtra("questions", questions);
                startActivity(i);

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEdit = prefs.edit();


                prefEdit.putInt("read", rgReadSelected);
                prefEdit.putInt("time", rgTimeSelected);
                prefEdit.putInt("problem", rgProblemSelected);
                prefEdit.putString("reflect", etReflect.getText().toString());
                // always remember to commit for sharedPref
                prefEdit.commit();

            }


        });


        // some changes
    }
}
