package com.hfad.workout;

import android.app.Fragment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StopwatchFragment extends Fragment implements View.OnClickListener {

    private int hundredth=0;
    private int seconds;
    private boolean running;
    private boolean wasRunning;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null){
            hundredth=savedInstanceState.getInt("seconds");
            running=savedInstanceState.getBoolean("running");
            wasRunning=savedInstanceState.getBoolean("wasRunning");
            if(wasRunning){
                running=true;
            }
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View layout=inflater.inflate(R.layout.fragment_stopwatch,container,false);
        runTimer(layout);

        Button startButton=(Button)layout.findViewById(R.id.start_button);
        startButton.setOnClickListener(this);
        Button stopButton=(Button)layout.findViewById(R.id.stop_button);
        stopButton.setOnClickListener(this);
        Button resetButton=(Button)layout.findViewById(R.id.reset_button);
        resetButton.setOnClickListener(this);
        return layout;
    }

    public void onClickStart(View view)
    {
       Toast toast=Toast.makeText(this.getView().getContext(),"You've started the stopwatch",Toast.LENGTH_LONG);
       toast.show();
        running=true;
    }
    public void onClickStop(View view)
    {
        Toast toast=Toast.makeText(this.getView().getContext(),"You've stopped the stopwatch",Toast.LENGTH_SHORT);
        toast.show();
        running=false;
    }
    public void onClickReset(View view)
    {
       Toast toast=Toast.makeText(this.getView().getContext(),"Stopwatch resetted",Toast.LENGTH_SHORT);
       toast.show();


        running=false;
        hundredth=0;
    }

    private void runTimer(View view)
    {
        final TextView tw=(TextView)view.findViewById(R.id.time_view);
        final Handler handler=new Handler();
        handler.post(new Runnable(){

            @Override
            public void run()
            {
                int hours=seconds/3600;
                int minutes=(seconds%3600)/60;
                int secs=hundredth/100;
                int hun=hundredth%100;

                String timeHours=String.format("%d:%02d:%02d",hours,minutes,secs);
                String timeMinutes=String.format("%d:%02d:%02d",minutes,secs,hun);

                if(hours>1)tw.setText(timeHours);
                else tw.setText(timeMinutes);
                if(running)
                {
                    hundredth++;
                }
                handler.postDelayed(this,9);
            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("hundredths",hundredth);
        savedInstanceState.putBoolean("running",running);
        savedInstanceState.putBoolean("wasRunning",wasRunning);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        wasRunning=running;
        running=false;
    }
    @Override
    public void onResume()
    {
        super.onResume();
        if(wasRunning)running=true;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.start_button:
                onClickStart(v);
                break;
            case R.id.stop_button:
                onClickStop(v);
                break;
            case R.id.reset_button:
                onClickReset(v);
                break;
        }
    }
}
