package com.example.myapplication;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private ImageView m1Imageview;
    private ImageView m2Imageview;
    Bitmap bmp;
    Bitmap bmp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.imageView);
        m1Imageview = (ImageView) findViewById(R.id.imageView2);
        m2Imageview = (ImageView) findViewById(R.id.imageView3);

         bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
       //  bmp1 = BitmapFactory.decodeFile("/sdcard/test.png");
       // mImageView.setImageBitmap(bmp);
       // m1Imageview.setImageBitmap(bmp1);

        new TestAsync().execute();

    }

    class TestAsync extends AsyncTask<Void, Void, Bitmap> {
        public ProgressDialog progressDialog;

        protected void onPreExecute() {
            Log.d("PreExecute", "On pre Execute......");
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Loading");
            progressDialog.setMessage("Please Wait...");
            progressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(Void... voids) {
            bmp1 = BitmapFactory.decodeFile("/sdcard/test.png");

            return bmp1;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (progressDialog != null) {
                progressDialog.dismiss();
                mImageView.setImageBitmap(bmp);
                m1Imageview.setImageBitmap(bmp1);

                Toast.makeText(MainActivity.this, "Task Completed", Toast.LENGTH_LONG).show();
            }
        }

    }

}


