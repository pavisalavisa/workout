package com.hfad.workout;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {

    private long workoutID;

    public void setWorkoutID(long workoutID) {
        this.workoutID = workoutID;
    }

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        if(savedInstanceState!=null)
            workoutID=savedInstanceState.getLong("workoutID");
        else {
            FragmentTransaction ft=getChildFragmentManager().beginTransaction();
            StopwatchFragment stopwatchFragment=new StopwatchFragment();
            ft.replace(R.id.stopwatch_container,stopwatchFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }


        return inflater.inflate(R.layout.fragment_workout_detail,container,false);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putLong("workoutID",workoutID);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        View view=getView();
        if(view!=null)

        {
            TextView title=(TextView)view.findViewById(R.id.textTitle);
            Workout workout=Workout.workouts[(int)workoutID];
            title.setText(workout.getName());
            TextView description=(TextView)view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }

}
