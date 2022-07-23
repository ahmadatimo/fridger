package com.example.fridger.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.fridger.R;

import java.util.List;


public class PageAdapter extends PagerAdapter {

    private List<ViewPager> contents;
    private Context context;

    public PageAdapter(List<ViewPager> contents, Context context) {
        this.contents = contents;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout)object; // so the photos go left to right or opposite
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater =  (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.activity_recipes,container,false);
        View view2 = inflater.inflate(R.layout.activity_how_to_cook,container,false);

        container.addView(view1);
        container.addView(view2);

        ImageView imageView = (ImageView) view1.findViewById(R.id.recipeImage);
        imageView.setImageResource(contents.get(position).getImage());

        TextView titleMain, titleSub, ingredientOne, quantityOne, ingredientTwo, quantityTwo, ingredientThree, quantityThree, howToCook;

        titleMain = view1.findViewById(R.id.recipeTitle);
        titleSub = view2.findViewById(R.id.foodTitle);

        ingredientOne = view1.findViewById(R.id.ingredientOne);
        ingredientTwo = view1.findViewById(R.id.ingredientTwo);
        ingredientThree = view1.findViewById(R.id.ingredientThree);

        quantityOne = view1.findViewById(R.id.quantityOne);
        quantityTwo = view1.findViewById(R.id.quantityTwo);
        quantityThree = view1.findViewById(R.id.quantityThree);

        howToCook = view2.findViewById(R.id.description);




        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}
