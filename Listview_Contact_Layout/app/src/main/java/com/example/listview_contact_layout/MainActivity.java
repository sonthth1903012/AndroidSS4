package com.example.listview_contact_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvContact;
    private List<ContactModel> listContacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        lvContact = (ListView) findViewById(R.id.lvContact);
        ContactAdapter adapter = new ContactAdapter(listContacts,this);
        lvContact.setAdapter(adapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactModel contactModel = listContacts.get(position);
                Toast.makeText(MainActivity.this, contactModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        ContactModel contact = new ContactModel("Nguyen Van A", "012312312", R.drawable.ic_user_c);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van B", "112312312", R.drawable.ic_user_c);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van C", "2012312312", R.drawable.ic_user_c);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van D", "3012312312", R.drawable.ic_user_c);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van E", "4012312312", R.drawable.ic_user_c);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van F", "5012312312", R.drawable.ic_user_c);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van G", "6012312312", R.drawable.ic_user_c);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van H", "7012312312", R.drawable.ic_user_c);
        listContacts.add(contact);

    }
}