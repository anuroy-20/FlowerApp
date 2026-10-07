package com.example.flowerapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FlowerDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_detail);

        // Get data from intent
        String emoji = getIntent().getStringExtra("emoji");
        String name = getIntent().getStringExtra("name");
        String desc = getIntent().getStringExtra("desc");
        String fact1 = getIntent().getStringExtra("fact1");
        String fact2 = getIntent().getStringExtra("fact2");
        String fact3 = getIntent().getStringExtra("fact3");
        int themeColor = getIntent().getIntExtra("themeColor", Color.parseColor("#E8304A"));
        String colorName = getIntent().getStringExtra("colorName");
        String colorHex = getIntent().getStringExtra("colorHex");

        // Setup ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(name != null ? name : "Flower");
            getSupportActionBar().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(themeColor));
        }

        // Set status bar color
        getWindow().setStatusBarColor(themeColor);

        // Bind views
        LinearLayout hero = findViewById(R.id.detailHero);
        TextView tvEmoji = findViewById(R.id.tvDetailEmoji);
        TextView tvName = findViewById(R.id.tvDetailName);
        TextView tvDesc = findViewById(R.id.tvDetailDesc);
        TextView tvFact1 = findViewById(R.id.tvDetailFact1);
        TextView tvFact2 = findViewById(R.id.tvDetailFact2);
        TextView tvFact3 = findViewById(R.id.tvDetailFact3);
        TextView tvColorName = findViewById(R.id.tvDetailColorName);
        TextView tvColorHex = findViewById(R.id.tvDetailColorHex);
        View viewSwatch = findViewById(R.id.viewDetailColorSwatch);
        Button btnAbout = findViewById(R.id.btnAboutFlower);

        // Set content
        hero.setBackgroundColor(themeColor);
        tvEmoji.setText(emoji);
        tvName.setText(name);
        tvDesc.setText(desc);
        tvFact1.setText(fact1);
        tvFact2.setText(fact2);
        tvFact3.setText(fact3);
        tvColorName.setText(colorName);
        tvColorHex.setText(colorHex);
        tvColorName.setTextColor(themeColor);

        // About button — tint to match theme color
        btnAbout.setBackgroundTintList(android.content.res.ColorStateList.valueOf(themeColor));
        final String finalName = name;
        final String finalEmoji = emoji;
        final String finalFact1 = fact1;
        final String finalFact2 = fact2;
        final String finalFact3 = fact3;
        final int finalThemeColor = themeColor;
        btnAbout.setOnClickListener(v -> {
            Intent intent = new Intent(this, FlowerAboutActivity.class);
            intent.putExtra("emoji", finalEmoji);
            intent.putExtra("name", finalName);
            intent.putExtra("fact1", finalFact1);
            intent.putExtra("fact2", finalFact2);
            intent.putExtra("fact3", finalFact3);
            intent.putExtra("themeColor", finalThemeColor);
            startActivity(intent);
        });

        // Color swatch
        GradientDrawable swatchBg = new GradientDrawable();
        swatchBg.setShape(GradientDrawable.RECTANGLE);
        swatchBg.setCornerRadius(20f);
        swatchBg.setColor(themeColor);
        viewSwatch.setBackground(swatchBg);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
