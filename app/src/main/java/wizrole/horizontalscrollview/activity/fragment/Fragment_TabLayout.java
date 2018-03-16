package wizrole.horizontalscrollview.activity.fragment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wizrole.horizontalscrollview.R;
import wizrole.horizontalscrollview.adapter.TablayoutListAdapter;

/**
 * Created by liushengping on 2018/3/16.
 * 何人执笔？
 */

public class Fragment_TabLayout extends LazyFragment {

    public static final String INTENT_INT_INDEX="index";
    private int tabIndex;
    public String id;
    public static Fragment_TabLayout newInstance(int tabIndex, boolean isLazyLoad) {
        Bundle args = new Bundle();
        args.putInt(INTENT_INT_INDEX, tabIndex);
        args.putBoolean(INTENT_BOOLEAN_LAZYLOAD, isLazyLoad);
        Fragment_TabLayout fragment = new Fragment_TabLayout();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_tablayout);
        tabIndex = getArguments().getInt(INTENT_INT_INDEX);
        Bundle bundle = getArguments();
        id= bundle.getString("two_type_id");
        initUI();
        getData(id);
    }

    public ListView list_view;
    public void initUI(){
        list_view=(ListView)findViewById(R.id.list_view);
    }

    public List<String> stringList=new ArrayList<>();
    public void getData(String type){
        for(int i=0;i<40;i++){
            stringList.add(type+i);
        }
        TablayoutListAdapter adapter=new TablayoutListAdapter(getActivity(),stringList);
        list_view.setAdapter(adapter);

    }
}