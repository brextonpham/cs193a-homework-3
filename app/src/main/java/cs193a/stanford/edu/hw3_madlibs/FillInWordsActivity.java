package cs193a.stanford.edu.hw3_madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import stanford.androidlib.SimpleActivity;

public class FillInWordsActivity extends SimpleActivity {
    private Button mOKButton;
    private EditText mMadLibEditText;
    private TextView mWordSpecifierTextView;
    private TextView mWordsLeftTextView;
    private Story mMainStory;
    private Scanner mScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_in_words);

        mOKButton = (Button)findViewById(R.id.ok_button);
        mMadLibEditText = (EditText)findViewById(R.id.mad_lib_editText);
        mWordSpecifierTextView = (TextView)findViewById(R.id.word_specifier_textView);
        mWordsLeftTextView = (TextView)findViewById(R.id.words_left_textView);

        ArrayList<Integer> files = new ArrayList<>();
        files.add(R.raw.madlib0_simple);
        files.add(R.raw.madlib1_tarzan);
        files.add(R.raw.madlib2_university);
        files.add(R.raw.madlib3_clothes);
        files.add(R.raw.madlib4_dance);
        Random random = new Random();
        int index = random.nextInt(files.size());
        int id = files.get(index);
        mScanner = new Scanner(getResources().openRawResource(id));
        mMainStory = new Story(mScanner);

        mWordsLeftTextView.setText(mMainStory.getPlaceholderRemainingCount() + " word(s) left to complete");
        mWordSpecifierTextView.setText(mMainStory.getNextPlaceholder());
        mOKButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mMadLibEditText.getText().toString().equals("")) {
                    mMainStory.fillInPlaceholder(mMadLibEditText.getText().toString());
                    if (mMainStory.getNextPlaceholder().equals("")) {
                        startShowStoryActivity(mMainStory);
                    } else {
                        mMadLibEditText.setText("");
                        mWordsLeftTextView.setText(mMainStory.getPlaceholderRemainingCount() + " word(s) left to complete");
                        mWordSpecifierTextView.setText(mMainStory.getNextPlaceholder());
                    }
                }
            }
        });
    }

    private void startShowStoryActivity(Story story) {
        Intent intent = new Intent(this, ShowStoryActivity.class);
        intent.putExtra("story", story.toString());
        startActivity(intent);
    }

}
