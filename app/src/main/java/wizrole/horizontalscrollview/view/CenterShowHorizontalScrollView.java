package wizrole.horizontalscrollview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import wizrole.horizontalscrollview.R;

/**
 * Created by liushengping on 2017/11/3.
 * 何人执笔？
 */

public class CenterShowHorizontalScrollView extends HorizontalScrollView {
    private LinearLayout mShowLinear;

    public CenterShowHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mShowLinear = new LinearLayout(context);
        mShowLinear.setOrientation(LinearLayout.HORIZONTAL);
        LayoutParams params = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mShowLinear.setGravity(Gravity.CENTER_VERTICAL);
        this.addView(mShowLinear, params);
    }

    /**
     * headerView顶部的点击
     * @param v
     */
    public void onClicked(View v) {
        if (v.getTag(R.id.item_position) != null) {
            int position = (Integer) v.getTag(R.id.item_position);
            View itemView = mShowLinear.getChildAt(position);
            int itemWidth = itemView.getWidth();
            int scrollViewWidth = this.getWidth();
            smoothScrollTo(itemView.getLeft() - (scrollViewWidth / 2 - itemWidth / 2), 0);
        }
    }

    /**
     * 点击抽屉布局的列表，滑动顶部列表
     * @param position
     */
    public void onClicked(int  position) {
            View itemView = mShowLinear.getChildAt(position);
            int itemWidth = itemView.getWidth();
            int scrollViewWidth = this.getWidth();
            smoothScrollTo(itemView.getLeft() - (scrollViewWidth / 2 - itemWidth / 2), 0);
    }

    public LinearLayout getLinear() {
        return mShowLinear;
    }

    public void addItemView(View itemView, int position) {
        itemView.setTag(R.id.item_position, position);
        mShowLinear.addView(itemView);
    }
}
