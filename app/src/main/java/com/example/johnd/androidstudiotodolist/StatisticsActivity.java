package com.example.johnd.androidstudiotodolist;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.widget.TextView;

import com.example.johnd.androidstudiotodolist.models.DatabaseHelper;
import com.example.johnd.androidstudiotodolist.models.ListItem;
import com.example.johnd.androidstudiotodolist.models.Statistics;

import java.util.ArrayList;

import az.plainpie.PieView;
import az.plainpie.animation.PieAngleAnimation;

public class StatisticsActivity extends BaseActivity {

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);



        DatabaseHelper databaseHelper = new DatabaseHelper(StatisticsActivity.this);
        ArrayList<ListItem> itemsArray = databaseHelper.getAllItems();
        Statistics stats = new Statistics();

        Integer statistics = stats.getPercentage(itemsArray);
        String stringStat = statistics.toString();
//        TextView title = (TextView)findViewById(R.id.pieView);
//        title.setText(stringStat);

//        ArrayList<ListItem> item = list.getList();

        ArrayList<ListItem> item = databaseHelper.getAllItems();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        PieView pieView = (PieView) findViewById(R.id.pieView);

        pieView.setPercentageBackgroundColor(getResources().getColor(R.color.colorPrimary));
        pieView.setInnerText(stringStat + "%");
        pieView.setPercentage(statistics);

        PieView animatedPie = (PieView) findViewById(R.id.pieView);

        PieAngleAnimation animation = new PieAngleAnimation(animatedPie);
        animation.setDuration(2000); //This is the duration of the animation in millis
        animatedPie.startAnimation(animation);

        pieView.setPercentageBackgroundColor(getResources().getColor(R.color.colorAccent));



    }


//
//    ListItem currentListItem = getItem(position);
//
//    TextView title = listItemView.findViewById(R.id.to_do_title);
//        title.setText(currentListItem.getTitle().toString());
}
