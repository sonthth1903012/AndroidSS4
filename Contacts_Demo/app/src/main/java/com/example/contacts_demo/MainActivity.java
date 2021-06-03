package com.example.contacts_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnChildItemClick {
    private List<ContactModel> listContact = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private ImageView ivUser;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        mAdapter = new ContactAdapter(this, listContact);
        mAdapter.registerChildItemClick(this);
        lvContact.setAdapter(mAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactModel model = listContact.get(i);
                Toast.makeText(MainActivity.this, model.getName() + ":" +model.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        lvContact = (ListView) findViewById(R.id.lvContact);
        ivUser = (ImageView) findViewById(R.id.ivUser);
        tvName = (TextView) findViewById(R.id.tvName);
    }


    private void initData() {
        listContact.add(new ContactModel("Jimmy Owen One", "+84941256301", R.drawable.ic_user_c));
        listContact.add(new ContactModel("Chapter Scarlet Two", "+84941256302", R.drawable.ic_user_c));
        listContact.add(new ContactModel("Jonathan Awesome Three", "+84941256303", R.drawable.ic_user_c));
        listContact.add(new ContactModel("Gentle Private Four", "+84941256304", R.drawable.ic_user_c));
        listContact.add(new ContactModel("Genesis Fire Five", "+84941256305", R.drawable.ic_user_c));
        listContact.add(new ContactModel("Gap None Six", "+84941256306", R.drawable.ic_user_c));
        listContact.add(new ContactModel("Anna Seven", "+84941256307", R.drawable.ic_user_c));
        listContact.add(new ContactModel("Willy Willing Eight", "+84941256308", R.drawable.ic_user_c));
        listContact.add(new ContactModel("Sammy The Nine", "+84941256309", R.drawable.ic_user_c));
        listContact.add(new ContactModel("Kathy Blast Ten", "+84941256310", R.drawable.ic_user_c));
        listContact.add(new ContactModel("Well Old Will Eleven", "+84941256311", R.drawable.ic_user_c));
        listContact.add(new ContactModel("Great Manhattan Twelve", "+84941256312", R.drawable.ic_user_c));
    }

    @Override
    protected void onDestroy() {
            super.onDestroy();
            mAdapter.unRegisterChildItemClick();
    }

    @Override
    public void onItemChildClick(int position){
            ContactModel contact = listContact.get(position);
            ivUser.setImageResource(contact.getImage());
            tvName.setText(contact.getName());
    }

}
