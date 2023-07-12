package com.alibaba.appmonitor.delegate;

import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.event.EventRepo;
import com.alibaba.appmonitor.event.EventType;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import tb.hl2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class CommitTask implements Runnable {
    private static final String TAG = "CommitTask";
    private static boolean init;
    private static HashMap<Integer, ScheduledFuture> mFutureMap = new HashMap<>();
    private static Map<Integer, CommitTask> uploadTasks;
    private int eventId;
    private int interval;
    private long startTime = System.currentTimeMillis();

    private CommitTask(int i, int i2) {
        this.interval = com.alipay.sdk.m.e0.a.a;
        this.eventId = i;
        this.interval = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void destroy() {
        for (Integer num : mFutureMap.keySet()) {
            ScheduledFuture scheduledFuture = mFutureMap.get(num);
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                scheduledFuture.cancel(true);
            }
        }
        init = false;
        uploadTasks = null;
        mFutureMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init() {
        EventType[] values;
        if (init) {
            return;
        }
        Logger.f(TAG, "init StatisticsAlarmEvent");
        uploadTasks = new ConcurrentHashMap();
        for (EventType eventType : EventType.values()) {
            if (eventType.isOpen()) {
                int eventId = eventType.getEventId();
                CommitTask commitTask = new CommitTask(eventId, eventType.getForegroundStatisticsInterval() * 1000);
                uploadTasks.put(Integer.valueOf(eventId), commitTask);
                mFutureMap.put(Integer.valueOf(eventId), hl2.c().d(mFutureMap.get(Integer.valueOf(eventId)), commitTask, commitTask.interval));
            }
        }
        init = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setStatisticsInterval(int i, int i2) {
        synchronized (uploadTasks) {
            CommitTask commitTask = uploadTasks.get(Integer.valueOf(i));
            if (commitTask == null) {
                if (i2 > 0) {
                    CommitTask commitTask2 = new CommitTask(i, i2 * 1000);
                    uploadTasks.put(Integer.valueOf(i), commitTask2);
                    mFutureMap.put(Integer.valueOf(i), hl2.c().d(mFutureMap.get(Integer.valueOf(i)), commitTask2, commitTask2.interval));
                }
            } else if (i2 > 0) {
                int i3 = i2 * 1000;
                if (commitTask.interval != i3) {
                    commitTask.interval = i3;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = commitTask.interval - (currentTimeMillis - commitTask.startTime);
                    if (j < 0) {
                        j = 0;
                    }
                    ScheduledFuture scheduledFuture = mFutureMap.get(Integer.valueOf(i));
                    hl2.c().d(scheduledFuture, commitTask, j);
                    mFutureMap.put(Integer.valueOf(i), scheduledFuture);
                    commitTask.startTime = currentTimeMillis;
                }
            } else {
                uploadTasks.remove(Integer.valueOf(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void uploadAllEvent() {
        for (EventType eventType : EventType.values()) {
            EventRepo.s().w(eventType.getEventId());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Logger.f(TAG, "check&commit event", Integer.valueOf(this.eventId));
        EventRepo.s().w(this.eventId);
        if (uploadTasks.containsValue(this)) {
            this.startTime = System.currentTimeMillis();
            mFutureMap.put(Integer.valueOf(this.eventId), hl2.c().d(mFutureMap.get(Integer.valueOf(this.eventId)), this, this.interval));
        }
    }
}
