package com.example.testkalender;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.*;
        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import android.widget.*;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Define the variable of CalendarView type
    // and TextView type;
    CalendarView calendar;
    TextView date_view;
    String[] tider = {" ","8:00-8:30", "8:30-9:00", "9:00-9:30"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // By ID we can use each component
        // which id is assign in xml file
        // use findViewById() to get the
        // CalendarView and TextView
        calendar = (CalendarView)
                findViewById(R.id.calendar);
        date_view = (TextView)
                findViewById(R.id.date_view);



        Spinner spin = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tider);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
     //   spin.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        spin.setOnItemSelectedListener(this);

        // Add Listener in calendar
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override

            // In this Listener have one method
            // and in this method we will
            // get the value of DAYS, MONTH, YEARS
            public void onSelectedDayChange(
                    @NonNull CalendarView view,
                    int year,
                    int month,
                    int dayOfMonth) {

                // Store the value of date with
                // format in String type Variable
                // Add 1 in month because month
                // index is start with 0
                String Date
                        = dayOfMonth + "-"
                        + (month + 1) + "-" + year;

                // set this date in TextView for Display
                date_view.setText(Date);


            }
        });


    }



    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        TextView t = findViewById(R.id.date_view1);
        t.setText(tider[position]);
        Toast.makeText(getApplicationContext(), "Selected User: " + tider[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
