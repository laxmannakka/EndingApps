package com.bridgelabz.fundohr;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

/**
 * Created by bridgeit007 on 9/12/16.
 */

public class Diologuebox {
    String mIntime, mOutTime;
    ImageView calender;
    TextView mDatextview, mTimetextview;
    int mIntimehours = 0, mIntimeminutes = 0, mOuttimehours = 0, mOUttimeminutes = 0;
    String spinnerarray[] = {"yes", "no", " offday"};


    public void showDialouge(final Context context) {

        ImageView calender;
        final TextView mTimetextview, mTimeTExtview2;
        final RelativeLayout mRealativelayout;
        final EditText edittext;
        final TextView mDateview;
        // Creatig the object of Dialog box
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //setting the tittle bar as none
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialoguebox); // Setting view
        // showing the dialogue
        dialog.show();

        calender = (ImageView) dialog.findViewById(R.id.calender);
        mTimetextview = (TextView) dialog.findViewById(R.id.text2);
        mTimeTExtview2 = (TextView) dialog.findViewById(R.id.outtext1);
        Spinner spinner = (Spinner) dialog.findViewById(R.id.spinner);
        mRealativelayout = (RelativeLayout) dialog.findViewById(R.id.relative3);
        edittext = (EditText) dialog.findViewById(R.id.edittext);
        mDateview = (TextView) dialog.findViewById(R.id.setdate);

        Calendar c = Calendar.getInstance();
        String Date = c.get(Calendar.DATE)+"-"+ c.get(Calendar.MONTH)+"-"+c.get(Calendar.YEAR) ;
        mDateview.setText(Date);


        ArrayAdapter aa = new ArrayAdapter(context, android.R.layout.simple_spinner_item, spinnerarray);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    mRealativelayout.setVisibility(View.INVISIBLE);
                    edittext.setVisibility(View.INVISIBLE);

                }
                if (position == 1) {
                    mRealativelayout.setVisibility(View.VISIBLE);
                    edittext.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //  TextView date = (TextView) dialog.findViewById(R.id.setdate);
                        mDateview.setText("" + dayOfMonth + " / " + monthOfYear + " / " + year);
                    }
                }, 2015, 10, 10).show();
            }
        });
        mTimeTExtview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        mOuttimehours = hourOfDay;
                        mOUttimeminutes = minute;

                        String AM_PM = " AM";
                        String mm_precede = "";
                        if (hourOfDay >= 12) {
                            AM_PM = " PM";
                            if (hourOfDay >= 13 && hourOfDay < 24) {
                                hourOfDay -= 12;
                            } else {
                                hourOfDay = 12;
                            }
                        } else if (hourOfDay == 0) {
                            hourOfDay = 12;
                        }
                        if (minute < 10) {
                            mm_precede = "0";
                        }
                        Toast.makeText(context, "" + hourOfDay + ":" + mm_precede + minute + AM_PM, Toast.LENGTH_SHORT).show();

                        mIntime = "" + hourOfDay + ":" + minute + AM_PM;

                        mTimeTExtview2.setText("" + hourOfDay + " : " + minute + AM_PM);
                        setTime(dialog);

                    }
                }, 11, 56, true).show();
            }
        });

        mTimetextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        mIntimehours = hourOfDay;
                        mIntimeminutes = minute;

                        String AM_PM = " AM";
                        String mm_precede = "";
                        if (hourOfDay >= 12) {
                            AM_PM = " PM";
                            if (hourOfDay >= 13 && hourOfDay < 24) {
                                hourOfDay -= 12;
                            } else {
                                hourOfDay = 12;
                            }
                        } else if (hourOfDay == 0) {
                            hourOfDay = 12;
                        }
                        if (minute < 10) {
                            mm_precede = "0";
                        }
                        mOutTime = "" + hourOfDay + ":" + minute + AM_PM;

                        mTimetextview.setText("" + hourOfDay + " : " + minute + AM_PM);
                        setTime(dialog);
                    }
                }, 11, 56, true).show();
            }
        });
    }

    public void setTime(Dialog dialog) {
        int hours = mOuttimehours - mIntimehours;
        int mintes = mOUttimeminutes - mIntimeminutes;
        TextView text = (TextView) dialog.findViewById(R.id.totaltime);
        if (mOuttimehours != 0) {
            text.setText(hours + "hr " + mintes + "mints");
        }
    }


}
