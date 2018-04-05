package com.example.aartiankurverma.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Aarti Ankur Verma on 2018-02-07.
 */

public class Profilepage extends AppCompatActivity {
    Button btnAddData;
    EditText editName;
    EditText editemail;
    EditText editphonenumber;
    Databasehelper myDb;
    ImageButton btnpic;
private static final int PICK_IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage2);
        btnpic = (ImageButton) findViewById(R.id.imagebutton);

        btnpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();

            }
        });


        myDb = new Databasehelper(this);

        this.editName = (EditText) findViewById(R.id.editText_name);
        this.editemail = (EditText) findViewById(R.id.editText_email);
        this.editphonenumber = (EditText) findViewById(R.id.editText_Phonenumber);
        this.btnAddData = (Button) findViewById(R.id.button_save);
        AddData();
    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

        @Override
        protected void onActivityResult(int requestcode, int resultcode, Intent data){
            super.onActivityResult(requestcode, resultcode, data);
            if (resultcode == RESULT_OK || requestcode == PICK_IMAGE){
               Uri imageUri = data.getData();
                btnpic.setImageURI(imageUri);
            }
        }

        public void AddData() {
            btnAddData.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            boolean isInserted = myDb.insertData(editName.getText().toString(), editemail.getText().toString(),
                                    editphonenumber.getText().toString());
                            if (isInserted = true)
                                Toast.makeText(Profilepage.this, "Data inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(Profilepage.this, "Data not inserted", Toast.LENGTH_LONG).show();

                        }


                    });
        }


}
