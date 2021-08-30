package me.whiteship.java8to11;

import java.util.Optional;

public class OnlineClass {
    private Integer id;

    private String title;

    private boolean closed;

    //Optional<Progress> 보다
    //validate , 상하위 클래스를 쪼개야함
    public Progress progress;


    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Optional<Progress> getProgress() {
        return null;
    }

    public void setProgress(Optional<Progress> progress) {
        //이것도 위험, 호출하는 쪽에서 얼마든지 null을 줄 수 있다.
        //null check를 하면 optional을 쓰는 이유가 없다.
        progress.ifPresent(p -> {
            this.progress = p;
        });
    }

}

