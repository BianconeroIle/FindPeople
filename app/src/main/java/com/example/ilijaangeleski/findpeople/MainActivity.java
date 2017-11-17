package com.example.ilijaangeleski.findpeople;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

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
        initTextListeners();
    }

    public void initVariables() {
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        city = (EditText) findViewById(R.id.city);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(presenter.getUsers());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public void initTextListeners() {
        firstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                userEnteredSmt();
            }
        });
        lastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                userEnteredSmt();
            }
        });
        city.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                userEnteredSmt();
            }
        });
    }

    public void userEnteredSmt() {
        presenter.onSearch(firstName.getText().toString(),
                lastName.getText().toString(),
                city.getText().toString());
    }


    @Override
    public void update(List<User> foundUsers) {
        recyclerViewAdapter.updateList(foundUsers);
    }
}
