package cs193a.stanford.edu.hw3_madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.Toast;

import java.util.*;
import stanford.androidlib.SimpleActivity;

public class MainActivity extends SimpleActivity {
    private Button mGetStartedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGetStartedButton = (Button)findViewById(R.id.get_started_button);
        mGetStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFillInWordsActivity();
            }
        });
    }

    private void startFillInWordsActivity() {
        Intent intent = new Intent(this, FillInWordsActivity.class);
        startActivity(intent);
    }
}
