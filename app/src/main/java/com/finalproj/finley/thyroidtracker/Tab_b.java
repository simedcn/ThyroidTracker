package com.finalproj.finley.thyroidtracker;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import trios.trio_a;
import trios.trio_b;
import trios.trio_c;
import trios.trio_d;
import trios.trio_e;
import trios.trio_f;

/**
 * Created by Finley on 04/01/2018.
 */



public class Tab_b extends Fragment {

    ViewPager inputPager;
    FragmentPagerAdapter adapterViewPager;
    FragmentPagerAdapter adapterViewPager2;

    public void SetPage(int Pos){
        inputPager.setCurrentItem(Pos, true);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View Fragment = inflater.inflate(R.layout.tab_b, container, false);

        final ViewPager viewPager = (ViewPager) Fragment.findViewById(R.id.TypeSelector);
        adapterViewPager = new PageAdapterSelector(getChildFragmentManager());
        viewPager.setAdapter(adapterViewPager);

        final ViewPager viewPager2 = (ViewPager) Fragment.findViewById(R.id.InputSelector);
        adapterViewPager2 = new PagerAdapterInput(getChildFragmentManager());
        viewPager2.setAdapter(adapterViewPager2);
        inputPager = viewPager2; //Links the "inputPager" with the ViewPager2 allowing the SetPage function to be called by the child fragment in viewPager.

        viewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position)
            {
                viewPager.setCurrentItem((int) Math.floor(position/3)); //Keeps the upper viewpager in sync with the current shown lower fragment
            }

            @Override
            public void onPageScrollStateChanged(int state) { }
        });


        Date date = new Date(); //Gets current date and time
        Calendar c = Calendar.getInstance(); //Creates an instance of calendar
        c.setTime(date);//Sets the calendars time to be now
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK); //Gets the current day of the week as a number

        Calendar now = Calendar.getInstance(); //creates another instance of calendar

        SimpleDateFormat format = new SimpleDateFormat("dd"); //date format for the output

        String[] days = new String[7]; //Seven size array
        int Day = -now.get(GregorianCalendar.DAY_OF_WEEK) + 2; //add 2 if your week start on monday
        now.add(Calendar.DAY_OF_MONTH, Day); //Adds a day to the calendar.
        for (int i = 0; i < 7; i++) //Iterates seven times to fill the current week
        {
            days[i] = format.format(now.getTime()); //Gets the time from the current calendar day in the pre determined format
            now.add(Calendar.DAY_OF_MONTH, 1); //This iterates the calendar day
        }

        final TextView Sunday = (TextView) Fragment.findViewById(R.id.Sunday); //Links the textview to the XML textview
        Sunday.setText(days[6]); //sets the text of the textview
        Sunday.setBackgroundColor(getResources().getColor(R.color.LightGreen)); //Sets the colour of the text view

        final TextView Monday = (TextView) Fragment.findViewById(R.id.Monday);
        Monday.setText(days[0]);
        Monday.setBackgroundColor(getResources().getColor(R.color.LightGreen));

        final TextView Tuesday = (TextView) Fragment.findViewById(R.id.Tuesday);
        Tuesday.setText(days[1]);
        Tuesday.setBackgroundColor(getResources().getColor(R.color.LightGreen));

        final TextView Wednesday = (TextView) Fragment.findViewById(R.id.Wednesday);
        Wednesday.setText(days[2]);
        Wednesday.setBackgroundColor(getResources().getColor(R.color.LightGreen));

        final TextView Thursday = (TextView) Fragment.findViewById(R.id.Thursday);
        Thursday.setText(days[3]);
        Thursday.setBackgroundColor(getResources().getColor(R.color.LightGreen));

        final TextView Friday = (TextView) Fragment.findViewById(R.id.Friday);
        Friday.setText(days[4]);
        Friday.setBackgroundColor(getResources().getColor(R.color.LightGreen));

        final TextView Saturday = (TextView) Fragment.findViewById(R.id.Saturday);
        Saturday.setText(days[5]);
        Saturday.setBackgroundColor(getResources().getColor(R.color.LightGreen));

        switch (dayOfWeek) {
            case 1:
                Sunday.setBackgroundColor(getResources().getColor(R.color.HighlightGreen));
                break;
            case 2:
                Monday.setBackgroundColor(getResources().getColor(R.color.HighlightGreen));
                break;
            case 3:
                Tuesday.setBackgroundColor(getResources().getColor(R.color.HighlightGreen));
                break;
            case 4:
                Wednesday.setBackgroundColor(getResources().getColor(R.color.HighlightGreen));
                break;
            case 5:
                Thursday.setBackgroundColor(getResources().getColor(R.color.HighlightGreen));
                break;
            case 6:
                Friday.setBackgroundColor(getResources().getColor(R.color.HighlightGreen));
                break;
            case 7:
                Saturday.setBackgroundColor(getResources().getColor(R.color.HighlightGreen));
                break;
        }
        return Fragment;
    }

    public static class PageAdapterSelector extends FragmentPagerAdapter {

        private static int Num_Items = 6;

        public PageAdapterSelector(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
//                    return trio_a.newInstance(0, "Page # 1");
                    return trio_a.newInstance();
                case 1: // Fragment # 0 - This will show FirstFragment different title
//                    return trio_b.newInstance(1, "Page # 2");
                    return trio_b.newInstance();
                case 2: // Fragment # 0 - This will show FirstFragment different title
//                    return trio_b.newInstance(1, "Page # 2");
                    return trio_c.newInstance();
                case 3: // Fragment # 0 - This will show FirstFragment different title
//                    return trio_b.newInstance(1, "Page # 2");
                    return trio_d.newInstance();
                case 4: // Fragment # 0 - This will show FirstFragment different title
//                    return trio_b.newInstance(1, "Page # 2");
                    return trio_e.newInstance();
                case 5: // Fragment # 0 - This will show FirstFragment different title
//                    return trio_b.newInstance(1, "Page # 2");
                    return trio_f.newInstance();
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

        @Override
        public int getCount() {
            return Num_Items;
        }
    }


    //BottomHalfViewPager --------------------------------------



    public static class PagerAdapterInput extends FragmentPagerAdapter {

        private static int Num_Items = 18;

        public PagerAdapterInput(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment different title
                    return input_activity.newInstance();
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return input_brainfog.newInstance();
                case 2: // Fragment # 0 - This will show FirstFragment different title
                    return input_brittlenails.newInstance();
                case 3: // Fragment # 0 - This will show FirstFragment different title
                    return input_cold.newInstance();
                case 4: // Fragment # 0 - This will show FirstFragment different title
                    return input_constipation.newInstance();
                case 5: // Fragment # 0 - This will show FirstFragment different title
                    return input_cramps.newInstance();
                case 6: // Fragment # 0 - This will show FirstFragment different title
                    return input_cruciferous.newInstance();
                case 7: // Fragment # 0 - This will show FirstFragment different title
                    return input_depression.newInstance();
                case 8: // Fragment # 0 - This will show FirstFragment
                    return input_energy.newInstance();
                case 9: // Fragment # 0 - This will show FirstFragment different title
                    return input_iodine.newInstance();
                case 10: // Fragment # 0 - This will show FirstFragment different title
                    return input_lossoflibido.newInstance();
                case 11: // Fragment # 0 - This will show FirstFragment different title
                    return input_pinsandneedles.newInstance();
                case 12: // Fragment # 0 - This will show FirstFragment different title
                    return input_sleep.newInstance();
                case 13: // Fragment # 0 - This will show FirstFragment different title
                    return input_soya.newInstance();
                case 14: // Fragment # 0 - This will show FirstFragment different title
                    return input_thirst.newInstance();
                case 15: // Fragment # 0 - This will show FirstFragment different title
                    return input_tiredness.newInstance();
                case 16: // Fragment # 0 - This will show FirstFragment different title
                    return input_weakness.newInstance();
                case 17: // Fragment # 0 - This will show FirstFragment different title
                    return input_weight.newInstance();
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

        @Override
        public int getCount() {
            return Num_Items;
        }

        }
    }
