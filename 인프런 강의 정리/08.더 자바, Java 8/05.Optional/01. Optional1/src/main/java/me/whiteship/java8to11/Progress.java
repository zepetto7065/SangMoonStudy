package me.whiteship.java8to11;

import java.time.Duration;

public class Progress {

    private Duration studyDuration; //수업을 얼마나 했는지

    private boolean finished; //수업을 마쳤는지

    public Duration getStudyDuration() {
        return studyDuration;
    }

    public void setStudyDuration(Duration studyDuration) {
        this.studyDuration = studyDuration;
    }
}
