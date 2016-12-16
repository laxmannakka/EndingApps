package com.bridgelabz.fundohr;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class EmployeeDetailsActivity extends AppCompatActivity {

    Button mAdd, mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        mAdd = (Button) findViewById(R.id.add);
        mEdit = (Button) findViewById(R.id.Edit);
        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "add", Toast.LENGTH_LONG).show();
                Diologuebox obj = new Diologuebox();
                obj.showDialouge(EmployeeDetailsActivity.this);

               /* FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                DialoguboxFragment obj = new DialoguboxFragment();
                fragmentTransaction.add(R.id.container,obj);
                fragmentTransaction.commit();
*/
            }
        });

        mEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Edit", Toast.LENGTH_LONG).show();

                new TimePickerDialog(EmployeeDetailsActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        TextView time = (TextView) findViewById(R.id.working);
                        time.setText("" + hourOfDay + " : " + minute);
                    }
                }, 11, 56, true).show();
            }
        });
    }
}
