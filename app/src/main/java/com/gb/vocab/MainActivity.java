package com.gb.vocab;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.gb.recyclerview.DividerItemDecoration;
import com.gb.recyclerview.WordsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements Callback<Vocabb> {
    //Root URL of our web service
    public static final String ROOT_URL = "http://appsculture.com";


    private List<Word> wordList = new ArrayList<>();
    private RecyclerView recyclerView;
    private WordsAdapter mAdapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Initializing the Recycler
        View view = findViewById(R.id.view);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        wordList = Word.find(Word.class, null, null);
        if (wordList.size() == 0)
            callmed();
        else {
            mAdapter = new WordsAdapter(wordList, MainActivity.this);
            recyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        }


    }


    public void callmed() {
        shwoDialof();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // prepare call in Retrofit 2.0
        VocabAPI api = retrofit.create(VocabAPI.class);

        Call<Vocabb> call = api.loadwords();
        //asynchronous call
        call.enqueue(this);
    }

    public void shwoDialof() {
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setTitle("Loading....");
        dialog.setMessage("Please Wait....");
        dialog.show();
    }


    @Override
    public void onResponse(Response<Vocabb> response, Retrofit retrofit) {
        wordList = response.body().getWords();
        for (int i = 0; i < response.body().getWords().size(); i++) {
            Word word = wordList.get(i);
            word = new Word(word.getId1(), word.getWord(), word.getVariant(), word.getMeaning(), word.getRatio());
            word.save();
        }

        mAdapter = new WordsAdapter(wordList, MainActivity.this);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        dialog.dismiss();


    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
}