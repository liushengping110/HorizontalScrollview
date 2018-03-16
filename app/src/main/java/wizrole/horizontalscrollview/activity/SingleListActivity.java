package wizrole.horizontalscrollview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wizrole.horizontalscrollview.R;
import wizrole.horizontalscrollview.adapter.ListAdapter;
import wizrole.horizontalscrollview.beam.Content;
import wizrole.horizontalscrollview.beam.Data;
import wizrole.horizontalscrollview.view.CenterShowHorizontalScrollView;

/**
 * Created by liushengping on 2018/3/16.
 * 何人执笔？
 */

public class SingleListActivity extends AppCompatActivity {

    public CenterShowHorizontalScrollView horizontalScrollView;
    public Button yule ,redian;
    public List<Content> contents;
    public ListView list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlelist);
        initUI();
        setView(0);
        setListView(0);
        setListener();
    }
    public void  initUI(){
        horizontalScrollView=(CenterShowHorizontalScrollView)findViewById(R.id.horizontalScrollView);
        yule=(Button)findViewById(R.id.yule);
        redian=(Button)findViewById(R.id.redian);
        list_view=(ListView)findViewById(R.id.list_view);
    }

    public void setView(int type){
        contents=new ArrayList<>();
        Data data=new Data();
        contents=data.ten();
        //设置线条的宽高
        WindowManager wm = this.getWindowManager();
        int width = wm.getDefaultDisplay().getWidth();
        LinearLayout.LayoutParams line_params=new LinearLayout.LayoutParams(width/contents.size(),5);
        LinearLayout.LayoutParams text_params=new LinearLayout.LayoutParams(width/contents.size(),100);
        text_params.setMargins(30,5,30,5);
        line_params.setMargins(30,5,30,5);
        horizontalScrollView.getLinear().removeAllViews();
        for (int i = 0; i < contents.size(); i++) {
            final View titleItem = View.inflate(SingleListActivity.this, R.layout.header_view, null);
            horizontalScrollView.addItemView(titleItem, i);
            //文本
            TextView textView = (TextView) titleItem.findViewById(R.id.text_header_item);
            textView.setText(contents.get(i).getCate());
            textView.setLayoutParams(text_params);
            //线条
            View view_header = (View) titleItem.findViewById(R.id.view_header);
            view_header.setLayoutParams(line_params);
            if(type==i){
                view_header.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                textView.setTextColor(getResources().getColor(R.color.colorAccent));
            }else{
                view_header.setBackgroundColor(getResources().getColor(R.color.white));
                textView.setTextColor(getResources().getColor(R.color.black));
            }
            titleItem.setOnClickListener(headerViewListener);
        }
    }

    /**
     * 头部点击
     */
    public View.OnClickListener headerViewListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            horizontalScrollView.onClicked(v);
            int position = (Integer) v.getTag(R.id.item_position);//根据头部点击的v，获取到点击头部的下表position
            setView(position);
            setListView(position);
        }
    };

    public void setListener(){
        yule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //看你的界面，你应该是通过下表去和顶部横向滑动的item建立联系吧
                //假如你点击了抽屉布局里面的position==2
                horizontalScrollView.onClicked(5);
                setView(5);
                setListView(5);
            }
        });

        redian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //看你的界面，你应该是通过下表去和顶部横向滑动的item建立联系吧
                //假如你点击了抽屉布局里面的position==2
                horizontalScrollView.onClicked(2);
                setView(2);
                setListView(2);
            }
        });
    }
    public void setListView(int num){
        ListAdapter adapter=new ListAdapter(SingleListActivity.this,contents.get(num).getDetails());
        list_view.setAdapter(adapter);
    }
}
