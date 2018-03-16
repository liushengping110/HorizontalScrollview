package wizrole.horizontalscrollview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import wizrole.horizontalscrollview.R;
import wizrole.horizontalscrollview.beam.Detail;

/**
 * Created by liushengping on 2017/11/3.
 * 何人执笔？
 */

public class TablayoutListAdapter extends BaseAdapter{

    public Context context;
    public List<String> contents;
    public LayoutInflater inflater;

    public TablayoutListAdapter(Context context, List<String>  contents){
        this.contents=contents;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public Object getItem(int position) {
        return contents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    class Holder{
        TextView textView;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Holder holder=null;
        if(view==null){
            holder=new Holder();
            view=inflater.inflate(R.layout.list_item,null);
            holder.textView=(TextView)view.findViewById(R.id.text_item);
            view.setTag(holder);
        }else{
            holder=(Holder)view.getTag();
        }
        String  detail=contents.get(position);
        holder.textView.setText(detail);
        return view;
    }
}
