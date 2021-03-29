package com.geektech.a1homework31;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private List<String> list;
    private Button btn;
    private EditText editTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        addList();
    }

    private void addList() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editTxt.getText().toString();
                list.add(str);
                adapter.notifyDataSetChanged();
                editTxt.setText("");
            }
        });
    }

    private void init() {
        list = new ArrayList<>();
       // list.add("Добавьте в список данные!!!");

        btn = findViewById(R.id.add_btn);
        editTxt=findViewById(R.id.editTxt);
        recyclerView = findViewById(R.id.recyclerVw);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(list,this);
        recyclerView.setAdapter(adapter);
    }


}