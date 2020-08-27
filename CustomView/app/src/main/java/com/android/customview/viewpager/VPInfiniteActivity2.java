package com.android.customview.viewpager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.customview.R;

import org.jetbrains.annotations.NotNull;


/*

第二种：
		实现原理:在适配器中将getcount的值设置为无限大。然后将3份图片加载其中。

		ViewPager无限循环两种方法比较：
流畅性：第一种方法 显然要比第二种方法要流畅很多。

应用场景： 如果只是让用户自行滑动跳转pager 的话，我比较推荐第一种。毕竟流畅性要好很多。如果是定时无限循环的话，
可以尝试用第二种方法。当然具体在pager转场动画里是直接跳转还是有个过渡动画来缓冲一下，看具体的项目中更适合哪种了。
		*/

public class VPInfiniteActivity2 extends Activity {

    private int[] pics = {R.drawable.xu1, R.drawable.xu2, R.drawable.xu3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp_inifinite);

        ViewPager viewPager = findViewById(R.id.viewpager);

        viewPager.setAdapter(new ViewPagerAdapter());
        viewPager.setCurrentItem(499);
    }

    class ViewPagerAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(VPInfiniteActivity2.this);
            ViewGroup.LayoutParams viewPagerImageViewParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(viewPagerImageViewParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            // 此处必须将position对imgIds.length取余数，不然基本上会出现数组越界的错误
            imageView.setImageResource(pics[position % pics.length]);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, @NotNull Object object) {
            container.removeView((View) object);
        }
    }
}