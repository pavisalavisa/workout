package com.hfad.workout;

/**
 * Created by krist on 3.12.2017..
 */

public class Workout {

    private String name;
    private String description;

    public static final Workout[]workouts={
            new Workout("The limb loosener","5 Handstand puhs-ups\n10 1-legged squats\n" +
                    "15 pull-ups"),
            new Workout("Core agony","100 pull-ups\n100 push-ups\n100 sit-ups\n" +
                    "100 squats"),
            new Workout("Strenght and length","500 metetr run\n21 x 1.5 pood kettleball swing\n" +
                    "21 x pull-ups"),
            new Workout("The wimp special","5 x 1 minute plank\n5x 100m dash\nDeadlift 3 x 5 220lbs")
    };

    public Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
