package biplap.com.FirstApp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends BaseAdapter {
    TextView textView;
    ImageView imageView;
    Context mcontext;
    String[] languages;
    int[] images;

    LayoutInflater layoutinflater;

    public CustomListAdapter(Context context, String[]textItems, int[]imageItems) {
        this.mcontext = context;
        this.languages = textItems;
        this.images = imageItems;
        layoutinflater = (LayoutInflater.from(context));
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

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = layoutinflater.inflate(R.layout.layout_list_item, null);
        textView = view.findViewById(R.id.tvListItem);
        imageView = view.findViewById(R.id.imageListItem);
        textView.setText(languages[position]);
        imageView.setImageResource(images[position]);

        return view;
    }
}
