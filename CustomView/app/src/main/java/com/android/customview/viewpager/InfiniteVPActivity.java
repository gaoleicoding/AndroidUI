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
第一种：

		实现原理 ：

		有三张图片，实现无限循环。在viewpager中设置5个view，第一个为三张图片的最后一张，第五张为三张图片的第一张。图片顺序如下数字：
		2-0-1-2-0

		0-1-2为正常的三个图片。2，0  为添加的两个图片view

		滑动的顺序：进入页面显示0图片，向右滑动到0时,将0页设置为0，则可以继续向右滑动。同理当向左滑动到  2 时，将2页设置为2
*/

public class InfiniteVPActivity extends Activity implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
//    private List<ImageView> imageViewList;
    private int[] pics = { R.drawable.xu1, R.drawable.xu2, R.drawable.xu3 };
    private int totalLength;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        viewPager = findViewById(R.id.viewpager);
//        imageViewList = new ArrayList<>();
//        // 添加viewpager多出的两个view
        totalLength = pics.length + 2;
//        for (int i = 0; i < length; i++) {
//            ImageView imageView = new ImageView(CalculatorActivity.this);
//            ViewGroup.LayoutParams viewPagerImageViewParams = new ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.MATCH_PARENT);
//            imageView.setLayoutParams(viewPagerImageViewParams);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            imageViewList.add(imageView);
//        }

        viewPager.setAdapter(new ViewPagerAdapter());
        viewPager.addOnPageChangeListener(InfiniteVPActivity.this);
        // 设置viewpager在第二个视图显示
        viewPager.setCurrentItem(1);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    @Override
    public void onPageSelected(int i) {

        int pageIndex = i;

        if (i == 0) {
            // 当视图在第一个时，将页面号设置为图片的最后一张。
            pageIndex = pics.length;
        } else if (i == pics.length + 1) {
            // 当视图在最后一个是,将页面号设置为图片的第一张。
            pageIndex = 1;
        }
        if (i != pageIndex) {
            viewPager.setCurrentItem(pageIndex, false);
        }
    }

    class ViewPagerAdapter extends PagerAdapter {

        @Override
        public void destroyItem(ViewGroup container, int position, @NotNull Object object) {
            container.removeView((View) object);
        }

        @NotNull
        @Override
        public Object instantiateItem(@NotNull ViewGroup container, int i) {

            ImageView imageView = new ImageView(InfiniteVPActivity.this);
            ViewGroup.LayoutParams viewPagerImageViewParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(viewPagerImageViewParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (i == 0) {
                imageView.setImageResource(pics[pics.length-1]);
            } else if (i == (totalLength - 1)) {
                imageView.setImageResource(pics[0]);
            } else {
                imageView.setImageResource(pics[i - 1]);
            }
            container.addView(imageView);
            return imageView;
        }

        @Override
        public int getCount() {
            return totalLength;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }
    }

}