package com.example.hf7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.VH> {

    private final Activity mContext;
    private final ArrayList<Animal> mAnimals;

    public AnimalsAdapter(Activity mContext, ArrayList<Animal> mAnimals) {
        this.mContext = mContext;
        this.mAnimals = mAnimals;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new VH(itemView, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Animal animal = mAnimals.get(position);
        holder.rootView.setTag(animal);
        holder.tvName.setText(animal.getName());
        holder.tvDescription.setText(animal.getDescription());
        Glide.with(mContext).load(animal.getImage()).centerCrop().into(holder.ivProfile);
    }

    @Override
    public int getItemCount() {
        return mAnimals.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        final View rootView;
        final ImageView ivProfile;
        final TextView tvName;
        final TextView tvDescription;

        public VH(@NonNull View itemView, final Context context) {
            super(itemView);
            this.rootView = itemView;
            this.ivProfile = itemView.findViewById(R.id.imageId);
            this.tvName = itemView.findViewById(R.id.nameId);
            this.tvDescription = itemView.findViewById(R.id.descriptionId);

            itemView.setOnClickListener(view -> Toast.makeText(mContext, tvName.getText(), Toast.LENGTH_SHORT).show());
        }
    }
}
