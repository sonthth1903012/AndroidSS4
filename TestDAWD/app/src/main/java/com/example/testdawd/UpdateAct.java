package com.example.testdawd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateAct extends AppCompatActivity implements View.OnClickListener {
    private DBHelper db;
    private int _id; private EditText edName;
    private EditText edGender;
    private EditText edDes;
    private EditText edSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super. onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        db = new DBHelper(this);
        initView();
        //Get Data From ListUserActivity
        Intent intent = getIntent(); _id = intent.getIntExtra(DBHelper.ID, 0);
        String name = intent.getStringExtra(DBHelper.NAME);
        String gender = intent.getStringExtra(DBHelper.GENDER);
        String des = intent.getStringExtra(DBHelper.DES);
        String salary = intent.getStringExtra(DBHelper.SALARY);
        edName.setText(name); edGender.setText(gender); edDes.setText(des); edSalary.setText(salary);
    }

    private void initView() {
        edName = (EditText) findViewById(R.id.edName);
        edGender = (EditText) findViewById(R.id.edGender);
        edDes = (EditText) findViewById(R.id.edDes);
        edSalary = (EditText) findViewById(R.id.edSalary);
        Button btUpdate = (Button) findViewById(R.id.btUpdate);
        btUpdate.setOnClickListener(this);
        Button btDelete = (Button) findViewById(R.id.btDelete);
        btDelete.setOnClickListener(this);
    }

    private void onUpdate() {
        String isUpdate = db.updateUser(_id, edName.getText().toString(), edGender.getText().toString() + " update", edDes.getText().toString(), edSalary.getText().toString());
        Toast.makeText(this, isUpdate, Toast.LENGTH_SHORT).show();
        finish();
    }

    private void onDelete() {
        Toast.makeText(this, db.deleteUser(_id), Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btUpdate:
                onUpdate();
                break;
            case R.id.btDelete:
                onDelete();
                break;
            default:
                break;
        }
    }

}
