package com.example.keris_submission;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;



public class DetailSenjataActivity extends AppCompatActivity {

    public static String EXTRA_NAMA = "nama_senjata";
    public static String EXTRA_ASAL = "asal_senjata";
    public static String EXTRA_DETAIL = "detail_senjata";
    public static String EXTRA_GAMBAR = "gambar_senjata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_senjata);

       ImageView imgfoto = findViewById(R.id.pusaka);
        TextView tvnama =  findViewById(R.id.nama_senjata);
        TextView tvtempat = findViewById(R.id.asal_senjata);
        TextView tvdetail = findViewById(R.id.detail_senjata);


        Glide.with(this).load(getIntent().getStringExtra(EXTRA_GAMBAR)).into(imgfoto);
        tvnama.setText(getIntent().getStringExtra(EXTRA_NAMA));
        tvtempat.setText(getIntent().getStringExtra(EXTRA_ASAL));
        tvdetail.setText(getIntent().getStringExtra(EXTRA_DETAIL));

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Detail Senjata " + getIntent().getStringExtra(EXTRA_NAMA));
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
