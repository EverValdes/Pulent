package models;

import rx.Scheduler;

public interface PostExecutionThread {
    Scheduler getScheduler();
}
