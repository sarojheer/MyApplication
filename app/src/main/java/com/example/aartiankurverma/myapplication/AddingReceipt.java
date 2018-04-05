package com.example.aartiankurverma.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import java.io.File;


/**
 * Created by Aarti Ankur Verma on 2018-03-22.
 */

public class AddingReceipt extends AppCompatActivity {

    Button btnimg;
    ImageView cam_pic;
    static final int cam_request=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adding_receipt);
        btnimg = (Button) findViewById(R.id.cam_btn);
        cam_pic = (ImageView) findViewById(R.id.imgview);
        btnimg.setOnClickListener(listener);

    }

    View.OnClickListener listener =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId()==btnimg.getId()){
                camera();
            }
        }
    };

   private void camera(){
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);
   }

   @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
       super.onActivityResult(requestCode,resultCode,data);
       if(resultCode==RESULT_OK){
           Bitmap btp = (Bitmap) data.getExtras().get("data");
           cam_pic.setImageBitmap(btp);
       }
   }







}
