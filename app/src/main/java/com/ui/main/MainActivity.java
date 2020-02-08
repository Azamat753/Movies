package com.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lawlett.movies.R;
import com.lawlett.movies.data.internet.RetrofitBuilder;
import com.lawlett.movies.data.internet.model.Example;

import java.util.ArrayList;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    InfoAdapter adapter;
    ArrayList<String> list = new ArrayList<>();
    EditText editText;
    Button search;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
        search = findViewById(R.id.search);
         initRecycler();
        getInfo("joker");
    }

    public void initRecycler() {
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new InfoAdapter();
        recyclerView.setAdapter(adapter);
    }

    public void getInfo(String name) {
        RetrofitBuilder.getSerivce().getInfo(name, "5dffe331").enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful() && response.body() != null) {
                    fillViews(response.body());
                    Log.e("TAG", "onResponse: " + response.body().getTitle());
                    Toast.makeText(MainActivity.this, "Succesfull", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void fillViews(final Example title) {

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInfo(editText.getText().toString());
                showInfo(title);
            }
        });
    }
    public void showInfo(Example title) {
        adapter.addText("Название фильма:");
        adapter.addText(title.getTitle());
        adapter.addText("Жанр:");
        adapter.addText(title.getGenre());
        adapter.addText("Режисер:");
        adapter.addText(title.getDirector());
        adapter.addText("Актеры:");
        adapter.addText(title.getActors());
        adapter.addText("Награждения:");
        adapter.addText(title.getAwards());
        adapter.addText("Страна:");
        adapter.addText(title.getCountry());
        adapter.addText("Язык:");
        adapter.addText(title.getLanguage());
        adapter.addText("Рейтинг:");
        adapter.addText(title.getRated());
        adapter.addText("Год выпуска:");
        adapter.addText(title.getYear());
    }


    public void deleteInfo(View view) {
        adapter.deleteLastInfo();
    }
}
