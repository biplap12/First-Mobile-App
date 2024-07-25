package biplap.com.FirstApp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    RecyclerDTO [] recyclerDTOS;
    public RecyclerViewAdapter(RecyclerDTO[] recyclerDTOS) {
        this.recyclerDTOS = recyclerDTOS;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.layout_recycler_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
    holder.textView.setText(recyclerDTOS[position].getLanguages());
    holder.imageView.setImageResource(recyclerDTOS[position].getImages());

    }

    @Override
    public int getItemCount() {
        return recyclerDTOS.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.recyclerTvItem);
            imageView=itemView.findViewById(R.id.recyclerImageView);
        }
    }
}
