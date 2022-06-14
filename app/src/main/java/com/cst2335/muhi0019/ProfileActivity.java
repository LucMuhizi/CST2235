package com.cst2335.muhi0019;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.provider.MediaStore;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageButton takePictureBtn;
    Button goToChatBtn;
    public static final String TAG = "PROFILE_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.e(TAG, "In funtion: onCreate");

        ActivityResultLauncher<Intent> myPictureTakerLauncher =
                registerForActivityResult( new ActivityResultContracts.StartActivityForResult()
                        ,new ActivityResultCallback<ActivityResult>() {


                            @Override
                            public void onActivityResult(ActivityResult result) {
                                if (result.getResultCode() == Activity.RESULT_OK)
                                { Intent data = result.getData();
                                    Bitmap imgbitmap = (Bitmap) data.getExtras().get("data");
                                    ImageView imgView = null;
                                    imgView.setImageBitmap(imgbitmap); // the imageButton
                                }
                                else if(result.getResultCode() == Activity.RESULT_CANCELED)
                                    Log.i(TAG, "User refused to capture a picture.");
                            }
                        } );

        // get the intent that got us here
        Intent loginPage = getIntent();

        String emailTyped = loginPage.getStringExtra("emailTyped");

        //Put the string that was sent from FirstActivity into the edit text:
        EditText enterText = (EditText) findViewById(R.id.EmailEditText);
        enterText.setText(emailTyped);

        takePictureBtn = (ImageButton) findViewById(R.id.ImageButton);
        takePictureBtn.setOnClickListener(c -> {


            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

                myPictureTakerLauncher.launch(takePictureIntent);}

        });
        goToChatBtn = (Button) findViewById(R.id.GoToChatBtn);
        goToChatBtn.setOnClickListener(c -> {
            Intent goToChatPage = new Intent(ProfileActivity.this, ChatRoomActivity.class);
            startActivityForResult(goToChatPage, 345);

        });



    }




    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "In function: onStart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "In function: onStart()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "In function: onStart()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "In function: onStart()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "In function: onStart()");
    }
}
