package com.example.ashok.customlistview;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ImageActivity extends AppCompatActivity
{
    ImageView iv;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        iv=(ImageView)findViewById(R.id.imageView);
        MyTask mt=new MyTask();
        mt.execute("https://lh4.googleusercontent.com/-v0soe-ievYE/AAAAAAAAAAI/AAAAAAAAAAA/OixOH_h84Po/photo.jpg");
    }

    class MyTask extends AsyncTask<String,Void,Bitmap>
    {
        ProgressDialog pd;
        protected void onPreExecute()
        {
            super.onPreExecute();
            pd = new ProgressDialog(ImageActivity.this);
            pd.setMessage("Downloading Image");
            pd.show();
        }
        protected Bitmap doInBackground(String... params)
        {
            try
            {
                URL u = new URL(params[0]);
                URLConnection con = u.openConnection();
                InputStream in = con.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(in);
                Bitmap bm = BitmapFactory.decodeStream(bis);
                return bm;
            }
            catch (Exception e)
            {
                Log.d("android", e.toString());
            }
            return null;
        }
        protected void onPostExecute(Bitmap bm)
        {
            //super.onPostExecute(bm);
            iv.setImageBitmap(bm);
            pd.cancel();
        }
    }
}
