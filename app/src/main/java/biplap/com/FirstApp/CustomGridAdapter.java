package biplap.com.FirstApp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGridAdapter  extends BaseAdapter {


    int[] imageItems;
    Context mContext;
    String[] languages;

    int[] laanguageItems;

    LayoutInflater layoutInflater;

    public CustomGridAdapter (Context context, String[] languages,int[] imageItems){
        this.mContext =context;
        this.languages= languages;
        this.imageItems= imageItems;
        layoutInflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return languages.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= layoutInflater.inflate(R.layout.layout_grid_item,null);
        TextView textView = convertView.findViewById(R.id.textItemGrid);
        ImageView imageView = convertView.findViewById(R.id.imageItemGrid);
        textView.setText(languages[position]);
        imageView.setImageResource(imageItems[position]);

        return convertView;
    }
}
