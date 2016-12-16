package com.bridgelabz.fundohr;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by bridgeit007 on 9/12/16.
 */

public class DialoguboxFragment extends Fragment {

    View mView;
    TextView mDatextview,mTimetextview;
    DatePicker mDatepicker;
    TimePicker mTimepicker;
    ImageView calender;
    RelativeLayout mRealative1,mRealative2,mRealative3,mRealative4;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView= inflater.inflate(R.layout.dialoguebox,container,false);
        mTimetextview= (TextView) mView.findViewById(R.id.text2);
        calender = (ImageView) mView.findViewById(R.id.calender);
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        TextView date = (TextView) mView.findViewById(R.id.setdate);
                        date.setText("" + dayOfMonth + " / " + monthOfYear + " / " + year);
                    }
                }, 2015, 10, 10).show();
            }
        });

        mTimetextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        TextView time = (TextView) mView.findViewById(R.id.working);
                        time.setText("" + hourOfDay + " : " + minute);
                    }
                }, 11, 56, true).show();
            }
        });
        return mView;

    }
}
