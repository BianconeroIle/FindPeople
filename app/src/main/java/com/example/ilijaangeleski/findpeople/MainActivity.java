package com.example.ilijaangeleski.findpeople;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    EditText firstName;
    EditText lastName;
    EditText city;
    RecyclerView recyclerView;
    MainPresenter presenter;
    RecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        initVariables();
        findUser();
    }

    public void findUser(){
        presenter.onSearch(firstName.getText().toString(),lastName.getText().toString(),city.getText().toString());
    }


    public void initVariables(){
        firstName=(EditText)findViewById(R.id.firstName);
        lastName=(EditText)findViewById(R.id.lastName);
        city=(EditText)findViewById(R.id.city);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(presenter.getPeople());
        recyclerView.setAdapter(recyclerViewAdapter);
    }


    @Override
    public void update(List<User> users) {
        recyclerViewAdapter.notifyDataSetChanged();
    }
}
