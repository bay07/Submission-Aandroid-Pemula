package com.example.keris_submission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.keris_submission.model.Senjata;
import com.example.keris_submission.model.SenjataData;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView keris;
    private ArrayList<Senjata> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Senjata Tradisional");
        }

        keris = findViewById(R.id.keris);
        keris.setHasFixedSize(true);

        list.addAll(SenjataData.getListData());
        showRecyclerList();
    }


    private void showRecyclerList() {
        keris.setLayoutManager(new LinearLayoutManager(this));
        ListSenjataAdapter listSenjataAdapterBayu = new ListSenjataAdapter(list);
        keris.setAdapter(listSenjataAdapterBayu);

        listSenjataAdapterBayu.setOnItemClickCallback(new ListSenjataAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Senjata data) {
                showSelectedSenjata(data);
            }
        });
    }

    private void showSelectedSenjata(Senjata senjata) {
        Toast.makeText(this, "Kamu memilih " + senjata.getNama(), Toast.LENGTH_SHORT).show();
        Intent moveIntent = new Intent(MainActivity.this, DetailSenjataActivity.class);

        moveIntent.putExtra(DetailSenjataActivity.EXTRA_NAMA, senjata.getNama());
        moveIntent.putExtra(DetailSenjataActivity.EXTRA_ASAL, senjata.getAsal());
        moveIntent.putExtra(DetailSenjataActivity.EXTRA_DETAIL, senjata.getDetail());
        moveIntent.putExtra(DetailSenjataActivity.EXTRA_GAMBAR, senjata.getFoto());
        startActivity(moveIntent);


    }

    @Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.about_menu, menu);
    return super.onCreateOptionsMenu(menu);
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.about:
                Intent aboutintent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(aboutintent);
                break;

        }

    }
}