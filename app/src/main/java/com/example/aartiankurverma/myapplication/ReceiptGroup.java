package com.example.aartiankurverma.myapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Aarti Ankur Verma on 2018-03-15.
 */

public class ReceiptGroup extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    ArrayList<String> itemList;
    ArrayAdapter<String> adapter;
    EditText itemText;
    Button addButton;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receipt_group);

        lv = (ListView) findViewById(R.id.list_todo);
        itemText = (EditText) findViewById(R.id.addtext);
        addButton = (Button) findViewById(R.id.addbutton);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.DialogFragment datePicker = new  DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "Date Picker");
            }
        });

        itemList = new ArrayList<>();

        adapter = new ArrayAdapter<String>(ReceiptGroup.this ,android.R.layout.simple_list_item_multiple_choice,itemList);

        View.OnClickListener addlistner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemList.add(itemText.getText().toString());
                itemText.setText("");
                adapter.notifyDataSetChanged();
            }
        };

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray positionchecker = lv.getCheckedItemPositions();
                int count = lv.getCount();
                for (int item=count-1; item>=0; item--){
                    if (positionchecker.get(item)){
                        adapter.remove(itemList.get(item));
                        Toast.makeText(ReceiptGroup.this, "Item delete sucessfully", Toast.LENGTH_SHORT).show();
                    }
                }

                positionchecker.clear();
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        addButton.setOnClickListener(addlistner);
        lv.setAdapter(adapter);



    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDataString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.textview);
        textView.setText(currentDataString);
    }




}
