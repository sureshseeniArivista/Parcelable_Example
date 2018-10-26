package parcelable.arivista.com.parcelable_example.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import parcelable.arivista.com.parcelable_example.R;
import parcelable.arivista.com.parcelable_example.holder.List_Holder;

public class Adapter_List extends RecyclerView.Adapter<Adapter_List.ViewHolder> {

    private ArrayList<List_Holder> items;
    private int itemLayout;

    public Adapter_List(ArrayList<List_Holder> items, int itemLayout) {
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        List_Holder item = items.get(position);
        holder.text.setText(item.getTitle());
        holder.image.setImageBitmap(null);
        Picasso.with(holder.image.getContext()).cancelRequest(holder.image);
        Picasso.with(holder.image.getContext()).load(item.getUrl()).into(holder.image);
        holder.itemView.setTag(item);
    }

    @Override public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.imageView1);
            text = (TextView) itemView.findViewById(R.id.textView1);
        }
    }
}
