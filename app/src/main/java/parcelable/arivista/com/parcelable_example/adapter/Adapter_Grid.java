package parcelable.arivista.com.parcelable_example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import parcelable.arivista.com.parcelable_example.R;
import parcelable.arivista.com.parcelable_example.holder.List_Holder;

public class Adapter_Grid extends BaseAdapter {

    private Context context;
    ArrayList<List_Holder> Items;
    LayoutInflater inflater;

    public Adapter_Grid(Context context, ArrayList<List_Holder> items) {
        this.context = context;
        this.Items = items;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_image, null);
        }
        ImageView imageview = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView textView = (TextView) convertView.findViewById(R.id.textView1);

        textView.setText(Items.get(position).getTitle());
        Picasso.with(convertView.getContext()).cancelRequest(imageview);
        Picasso.with(convertView.getContext()).load(Items.get(position).getUrl()).into(imageview);
        imageview.setTag(Items.get(position).getTitle());

        return convertView;
    }

    @Override
    public int getCount() {
        return Items.size();
    }

    @Override
    public Object getItem(int position) {
        return Items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}