package com.example.flowerapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder> {

    private List<FlowerModel> flowerList;
    private Context context;
    private int accentColor;

    public FlowerAdapter(Context context, List<FlowerModel> flowerList, int accentColor) {
        this.context = context;
        this.flowerList = flowerList;
        this.accentColor = accentColor;
    }

    @NonNull
    @Override
    public FlowerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_flower, parent, false);
        return new FlowerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlowerViewHolder holder, int position) {
        FlowerModel flower = flowerList.get(position);

        holder.tvEmoji.setText(flower.getEmoji());
        holder.tvName.setText(flower.getName());
        holder.tvDesc.setText(flower.getDescription());
        holder.tvTap.setText("Tap to learn more →");
        holder.tvTap.setTextColor(accentColor);

        // Color the emoji background
        GradientDrawable bgDrawable = new GradientDrawable();
        bgDrawable.setShape(GradientDrawable.RECTANGLE);
        bgDrawable.setCornerRadius(28f);
        int alphaColor = Color.argb(30, Color.red(accentColor), Color.green(accentColor), Color.blue(accentColor));
        bgDrawable.setColor(alphaColor);
        holder.tvEmoji.setBackground(bgDrawable);

        // Color the dot
        GradientDrawable dotDrawable = new GradientDrawable();
        dotDrawable.setShape(GradientDrawable.OVAL);
        dotDrawable.setColor(accentColor);
        holder.viewDot.setBackground(dotDrawable);

        // Animate in
        holder.itemView.setAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_in));

        // Click to open detail
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FlowerDetailActivity.class);
            intent.putExtra("emoji", flower.getEmoji());
            intent.putExtra("name", flower.getName());
            intent.putExtra("desc", flower.getDescription());
            intent.putExtra("fact1", flower.getFact1());
            intent.putExtra("fact2", flower.getFact2());
            intent.putExtra("fact3", flower.getFact3());
            intent.putExtra("themeColor", flower.getThemeColor());
            intent.putExtra("colorName", flower.getColorName());
            intent.putExtra("colorHex", flower.getColorHex());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return flowerList.size();
    }

    public void updateData(List<FlowerModel> newList, int newAccentColor) {
        this.flowerList = newList;
        this.accentColor = newAccentColor;
        notifyDataSetChanged();
    }

    static class FlowerViewHolder extends RecyclerView.ViewHolder {
        TextView tvEmoji, tvName, tvDesc, tvTap;
        View viewDot;

        FlowerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEmoji = itemView.findViewById(R.id.tvFlowerEmoji);
            tvName = itemView.findViewById(R.id.tvFlowerName);
            tvDesc = itemView.findViewById(R.id.tvFlowerDesc);
            tvTap = itemView.findViewById(R.id.tvFlowerFact);
            viewDot = itemView.findViewById(R.id.viewColorDot);
        }
    }
}
