package ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebookvv2.R;

import java.util.ArrayList;
import java.util.List;

import pojo.Moviemodel;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private ArrayList<Moviemodel> MovieModels = new ArrayList<>();

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
       // holder.text_user.setText(MovieModels.get(position).getUserId());
        holder.text_title.setText(MovieModels.get(position).getTitle());
        holder.text_body.setText(MovieModels.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return MovieModels.size();
    }

    public void setList(List<Moviemodel> moviemodels) {
        this.MovieModels= (ArrayList<Moviemodel>) moviemodels;
        notifyDataSetChanged();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {
   TextView text_user,text_title,text_body;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
          //  text_user=itemView.findViewById(R.id.text_id);
            text_title=itemView.findViewById(R.id.text_title);
            text_body=itemView.findViewById(R.id.text_body);
        }
    }
}
