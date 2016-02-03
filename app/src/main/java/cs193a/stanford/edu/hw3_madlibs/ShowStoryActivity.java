package cs193a.stanford.edu.hw3_madlibs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.*;
import android.view.*;
import android.widget.*;

import org.w3c.dom.Text;

import java.util.ArrayList;

import stanford.androidlib.SimpleActivity;

public class ShowStoryActivity extends SimpleActivity {
    private TextView mTextView;
    private Button mStartOverButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_story);

        mTextView = (TextView)findViewById(R.id.storyTextView);
        mStartOverButton = (Button)findViewById(R.id.startOverButton);

        Intent intent = getIntent();
        String stringThing = intent.getStringExtra("story");
        mTextView.setText(Html.fromHtml(stringThing));

        mStartOverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActiity();
            }
        });
    }

    private void startMainActiity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
