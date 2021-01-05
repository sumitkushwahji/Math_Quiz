    package com.example.mathquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mCheatButton;
    private TextView mQuestionTextView;
    private static final String TAG= "MainActivity";
    private static final String KEY_INDEX = "index";


        //create array of QuestionBank object
    private QuestionBank[] mQuestionBank= new QuestionBank[]{
            new QuestionBank(R.string.question_1,true), //contructor calling
            new QuestionBank(R.string.question_2,true),
            new QuestionBank(R.string.question_3,false),
            new QuestionBank(R.string.question_4,true),
            new QuestionBank(R.string.question_5,true)
    };
    private int currentIndex = 0; // define index of array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"Inside on create");
        setContentView(R.layout.activity_main);

        mQuestionTextView= (TextView) findViewById(R.id.question_text_view);

        if (savedInstanceState!= null ){
            currentIndex = savedInstanceState.getInt(KEY_INDEX,0);
        }
        
        int question = mQuestionBank[currentIndex].getQuestion();
        mQuestionTextView.setText(question);
        //you can also use updateQuestion() instead of above 2 line

        mTrueButton= (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                //Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            }
        });

        mFalseButton=(Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                //Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex =(currentIndex+1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mCheatButton =(Button) findViewById(R.id.cheat_buttton);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"cheat Button pressed");
               // Intent i= new Intent(MainActivity.this,CheatAtivity.class);
                Intent i =CheatAtivity.newIntent(MainActivity.this,currentIndex);
                startActivity(i);
            }
        });

    }

        @Override
        public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
            super.onSaveInstanceState(savedInstanceState);
            Log.i(TAG,"Inside onSavedInstance");
            savedInstanceState.putInt(KEY_INDEX,currentIndex);

        }

        private void updateQuestion(){
        int question = mQuestionBank[currentIndex].getQuestion();
        mQuestionTextView.setText(question);

    }
    private void checkAnswer (boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[currentIndex].isTrueQuestion();

        int messageResId = 0;
        if(userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
        }
        else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
    }

        @Override
        protected void onStart() {
            super.onStart();
            Log.d(TAG,"Inside onStart");
        }

        @Override
        protected void onPause() {
            super.onPause();
            Log.d(TAG,"Inside onPause");
        }

        @Override
        protected void onResume() {
            super.onResume();
            Log.d(TAG,"Inside onResume"); //for debug
            Log.w(TAG,"e called"); // for warning
            Log.e(TAG,"e called"); //for error
            Log.i(TAG,"e called"); //for info
            Log.v(TAG,"e called"); //for verbose messages
        }

        @Override
        protected void onStop() {
            super.onStop();
            Log.d(TAG,"Inside onStop");
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            Log.d(TAG,"Inside onDestroy");
        }
    }