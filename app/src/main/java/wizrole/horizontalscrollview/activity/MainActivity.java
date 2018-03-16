package wizrole.horizontalscrollview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import wizrole.horizontalscrollview.R;

/**
 * Created by liushengping on 2018/3/16.
 * 何人执笔？
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //单个列表的横向滑动导航
        findViewById(R.id.btn_singlelist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SingleListActivity.class);
                startActivity(intent);
            }
        });
        //TabLayout的横向滑动导航
        findViewById(R.id.btn_tabLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TabLayoutActivity.class);
                startActivity(intent);
            }
        });
    }
}
