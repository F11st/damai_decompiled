package com.youku.arch.beast.threading;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.beast.BeastZygote;
import com.youku.arch.beast.EventType;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WorkerThread implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long DEFAULT_WORK_INTERVAL = 60000;
    private BeastZygote mCorrespondingZygote;
    private final Notifier mThreadNotifier = new Notifier(null);
    private long mWorkInterval = 60000;
    private BeastZygote.Type type = null;
    private volatile boolean mRunning = true;

    /* compiled from: Taobao */
    /* renamed from: com.youku.arch.beast.threading.WorkerThread$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$arch$beast$EventType;

        static {
            int[] iArr = new int[EventType.values().length];
            $SwitchMap$com$youku$arch$beast$EventType = iArr;
            try {
                iArr[EventType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$arch$beast$EventType[EventType.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$arch$beast$EventType[EventType.START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$arch$beast$EventType[EventType.RESUME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$youku$arch$beast$EventType[EventType.REG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$youku$arch$beast$EventType[EventType.UNREG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$youku$arch$beast$EventType[EventType.LOOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$youku$arch$beast$EventType[EventType.END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public WorkerThread() {
    }

    public void end() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1250534690")) {
            ipChange.ipc$dispatch("-1250534690", new Object[]{this});
            return;
        }
        synchronized (this.mThreadNotifier) {
            Notifier notifier = this.mThreadNotifier;
            notifier.message = EventType.END;
            notifier.notify();
        }
    }

    public void pause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "428141283")) {
            ipChange.ipc$dispatch("428141283", new Object[]{this});
            return;
        }
        synchronized (this.mThreadNotifier) {
            Notifier notifier = this.mThreadNotifier;
            notifier.message = EventType.PAUSE;
            notifier.notify();
        }
    }

    public void register() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-322321842")) {
            ipChange.ipc$dispatch("-322321842", new Object[]{this});
            return;
        }
        synchronized (this.mThreadNotifier) {
            Notifier notifier = this.mThreadNotifier;
            notifier.message = EventType.REG;
            notifier.notify();
        }
    }

    public void resume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2035264388")) {
            ipChange.ipc$dispatch("2035264388", new Object[]{this});
            return;
        }
        synchronized (this.mThreadNotifier) {
            Notifier notifier = this.mThreadNotifier;
            if (notifier.message != EventType.PAUSE) {
                return;
            }
            notifier.message = EventType.RESUME;
            notifier.notify();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-871593170")) {
            ipChange.ipc$dispatch("-871593170", new Object[]{this});
            return;
        }
        while (this.mRunning) {
            try {
                EventType eventType = this.mThreadNotifier.message;
                if (eventType != EventType.PAUSE && eventType != EventType.RESUME) {
                    this.mCorrespondingZygote.getMessenger().sendForEvent(this.mThreadNotifier.message);
                }
                switch (AnonymousClass1.$SwitchMap$com$youku$arch$beast$EventType[this.mThreadNotifier.message.ordinal()]) {
                    case 1:
                        synchronized (this.mThreadNotifier) {
                            this.mThreadNotifier.wait();
                        }
                        continue;
                    case 2:
                        synchronized (this.mThreadNotifier) {
                            this.mThreadNotifier.wait();
                        }
                        continue;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        synchronized (this.mThreadNotifier) {
                            this.mThreadNotifier.message = EventType.LOOP;
                            break;
                        }
                    case 7:
                        break;
                    case 8:
                        this.mRunning = false;
                        continue;
                    default:
                        continue;
                }
                synchronized (this.mThreadNotifier) {
                    this.mThreadNotifier.wait(this.mWorkInterval);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public void setCorrespondingZygote(BeastZygote beastZygote) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "430046101")) {
            ipChange.ipc$dispatch("430046101", new Object[]{this, beastZygote});
        } else {
            this.mCorrespondingZygote = beastZygote;
        }
    }

    public void setInterval(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "691617810")) {
            ipChange.ipc$dispatch("691617810", new Object[]{this, Long.valueOf(j)});
        } else {
            this.mWorkInterval = j;
        }
    }

    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "471246071")) {
            ipChange.ipc$dispatch("471246071", new Object[]{this});
            return;
        }
        synchronized (this.mThreadNotifier) {
            Notifier notifier = this.mThreadNotifier;
            notifier.message = EventType.START;
            notifier.notify();
        }
    }

    public void unregister() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "141763349")) {
            ipChange.ipc$dispatch("141763349", new Object[]{this});
            return;
        }
        synchronized (this.mThreadNotifier) {
            Notifier notifier = this.mThreadNotifier;
            notifier.message = EventType.UNREG;
            notifier.notify();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class Notifier {
        EventType message;

        private Notifier() {
            this.message = EventType.NONE;
        }

        /* synthetic */ Notifier(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public WorkerThread(BeastZygote beastZygote) {
        this.mCorrespondingZygote = beastZygote;
    }
}
