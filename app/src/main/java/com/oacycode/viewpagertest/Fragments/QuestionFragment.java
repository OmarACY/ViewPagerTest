package com.oacycode.viewpagertest.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.oacycode.viewpagertest.Interfaces.FragmentChangeListener;
import com.oacycode.viewpagertest.R;

public class QuestionFragment extends Fragment {
    private int fragVal;

    public static QuestionFragment newInstance(int val) {
        QuestionFragment questionFragment = new QuestionFragment();
        // Supply val input as an argument.
        Bundle args = new Bundle();
        args.putInt("val", val);
        questionFragment.setArguments(args);
        return questionFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragVal = getArguments() != null ? getArguments().getInt("val") : 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layoutView = inflater.inflate(R.layout.fragment_question, container,
                false);
        TextView tv = layoutView.findViewById(R.id.tvQuestion);
        String question = "";

        switch (fragVal){
            case 0 :
                question = getString(R.string.question_for_waiter);
                break;
            case 1 :
                question = getString(R.string.question_for_food);
                break;
            case 2 :
                question = getString(R.string.question_for_restaurant);
                break;
        }

        tv.setText(question);


        RatingBar ratingBar = layoutView.findViewById(R.id.ratingBar);
//        txtRatingValue = (TextView) findViewById(R.id.txtRatingValue);

        //if rating value is changed,
        //display the current rating value in the result (textview) automatically

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {

                if(fromUser){
                    showNextFragment();
                }

            }
        });

        return layoutView;
    }

    public void showNextFragment() {
        FragmentChangeListener fc = (FragmentChangeListener)getActivity();
        fc.replaceFragment(fragVal + 1);
    }
}
