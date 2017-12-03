package com.hfad.workout;


import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link ListFragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {

    static interface WorkoutListListener{
        void itemClicked(long id);
    }

    private WorkoutListListener listener;

    public WorkoutListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);//when fragment gets attached to an activity it registers the activity as listener
        this.listener=(WorkoutListListener)activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        if(listener!=null)//Tell the listener when an item in the listview is clicked!
            listener.itemClicked(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String [] names=new String[Workout.workouts.length];
        for(int i=0;i<names.length;i++)
        {
            names[i]=Workout.workouts[i].getName();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(inflater.getContext(),android.R.layout.simple_list_item_1,names);
        setListAdapter(adapter);

        return super.onCreateView(inflater,container,savedInstanceState);
    }

}
