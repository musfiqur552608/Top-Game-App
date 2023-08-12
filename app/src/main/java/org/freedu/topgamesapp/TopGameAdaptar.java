package org.freedu.topgamesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TopGameAdaptar extends RecyclerView.Adapter<TopGameAdaptar.MyViewHolder> {
    private TopGameModel[] gameList;

    public TopGameAdaptar(TopGameModel[] gameList) {
        this.gameList = gameList;
    }

    public static ItemClickListener clickListener;

    public void setClickListener(ItemClickListener clickListener){
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.topgames_list, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final TopGameModel gameListData = gameList[position];
        holder.game.setText(gameListData.getGameName());
        holder.company.setText(gameListData.getCompanyName());
        holder.gameImage.setImageResource(gameListData.getGameImg());
    }

    @Override
    public int getItemCount() {
        return gameList.length;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView gameImage;
        public TextView game, company;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.gameImage = itemView.findViewById(R.id.gameImg);
            this.game = itemView.findViewById(R.id.gameName);
            this.company = itemView.findViewById(R.id.companyName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(clickListener!=null){
                clickListener.onClick(view, getAdapterPosition());
            }
        }
    }
}
