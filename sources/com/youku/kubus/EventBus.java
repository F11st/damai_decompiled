package com.youku.kubus;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import tb.jn1;

/* compiled from: Taobao */
@NoProguard
/* loaded from: classes2.dex */
public class EventBus {
    private static final String TAG = "Kubus";
    static volatile EventBus defaultInstance;
    private final String EVENT_NO_SUBSCRIBER;
    private final AsyncPoster asyncPoster;
    private final BackgroundPoster backgroundPoster;
    private final String channelId;
    private final ThreadLocal<PostingThreadState> currentPostingThreadState;
    private final DataSource dataSource;
    private final boolean eventInheritance;
    private final IEventStatistic eventStatistic;
    private final Map<Object, List<String>> eventTypesBySubscriber;
    private final ExecutorService executorService;
    private final long id;
    private final boolean isLoggable;
    private final boolean logNoSubscriberMessages;
    private final boolean logSubscriberExceptions;
    private final HandlerPoster mainThreadPoster;
    private final String name;
    private final boolean sendNoSubscriberEvent;
    private final boolean sendSubscriberExceptionEvent;
    private final boolean statisticSwitchOn;
    private final Map<String, Event> stickyEvents;
    private final SubscriberMethodFinder subscriberMethodFinder;
    private final Map<String, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;
    private final boolean throwSubscriberException;
    private static final AtomicLong sBaseId = new AtomicLong(0);
    private static final EventBusBuilder DEFAULT_BUILDER = new EventBusBuilder();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.kubus.EventBus$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$kubus$ThreadMode;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            $SwitchMap$com$youku$kubus$ThreadMode = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$kubus$ThreadMode[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$kubus$ThreadMode[ThreadMode.BACKGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$kubus$ThreadMode[ThreadMode.ASYNC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    interface PostCallback {
        void onPostCompleted(List<SubscriberExceptionEvent> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class PostingThreadState {
        boolean canceled;
        Event event;
        final List<Event> eventQueue = new ArrayList();
        boolean isMainThread;
        boolean isPosting;
        Subscription subscription;

        PostingThreadState() {
        }
    }

    public EventBus() {
        this(DEFAULT_BUILDER);
    }

    public static EventBusBuilder builder() {
        return new EventBusBuilder();
    }

    private void checkPostStickyEventToSubscription(Subscription subscription, Event event) {
        if (event != null) {
            postToSubscriptionImmediately(subscription, event, Looper.getMainLooper() == Looper.myLooper());
            postToSubscription(subscription, event, Looper.getMainLooper() == Looper.myLooper());
        }
    }

    public static void clearCaches() {
        SubscriberMethodFinder.clearCaches();
    }

    public static EventBus getDefault() {
        if (defaultInstance == null) {
            synchronized (EventBus.class) {
                if (defaultInstance == null) {
                    defaultInstance = new EventBus();
                }
            }
        }
        return defaultInstance;
    }

    private void handleSubscriberException(Subscription subscription, Event event, Throwable th) {
        if (event instanceof SubscriberExceptionEvent) {
            if (this.logSubscriberExceptions) {
                Log.e(TAG, "SubscriberExceptionEvent subscriber " + subscription.subscriber.getClass() + " threw an exception", th);
                SubscriberExceptionEvent subscriberExceptionEvent = (SubscriberExceptionEvent) event;
                Log.e(TAG, "Initial event " + subscriberExceptionEvent.causingEvent + " caused exception in " + subscriberExceptionEvent.causingSubscriber, subscriberExceptionEvent.throwable);
            }
        } else if (this.throwSubscriberException && th != null) {
            if (!(th instanceof Error)) {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                throw new EventBusException("Invoking subscriber failed", th);
            }
            throw ((Error) th);
        } else {
            if (this.logSubscriberExceptions) {
                Log.e(TAG, "Could not dispatch event: " + event.getClass() + " to subscribing class " + subscription.subscriber.getClass(), th);
            }
            if (this.sendSubscriberExceptionEvent) {
                post(new SubscriberExceptionEvent(this, th, event, subscription.subscriber));
            }
        }
    }

    private boolean isValidEventType(String str) {
        return str != null && str.startsWith("kubus://");
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [com.youku.kubus.Event, com.youku.kubus.Subscription] */
    private void postImmediately(Event event, PostingThreadState postingThreadState, Object obj) {
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList;
        IEventStatistic iEventStatistic;
        IEventStatistic iEventStatistic2;
        synchronized (this) {
            copyOnWriteArrayList = this.subscriptionsByEventType.get(event.type);
        }
        postingThreadState.isPosting = true;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.statisticSwitchOn && (iEventStatistic2 = this.eventStatistic) != null) {
                iEventStatistic2.eventHandleBegin(event, elapsedRealtime);
            }
            Iterator<Subscription> it = copyOnWriteArrayList.iterator();
            boolean z = false;
            while (it.hasNext()) {
                Subscription next = it.next();
                postingThreadState.event = event;
                postingThreadState.subscription = next;
                boolean z2 = Looper.getMainLooper() == Looper.myLooper();
                postingThreadState.isMainThread = z2;
                try {
                    postToSubscriptionImmediately(next, event, z2);
                    if (obj != null && next.subscriber == obj) {
                        z = true;
                    }
                    if (z) {
                        break;
                    }
                } finally {
                    postingThreadState.event = null;
                    postingThreadState.subscription = null;
                    postingThreadState.canceled = false;
                }
            }
            if (this.statisticSwitchOn && (iEventStatistic = this.eventStatistic) != null) {
                iEventStatistic.eventHandleEnd(event, elapsedRealtime, SystemClock.elapsedRealtime());
            }
        }
        postingThreadState.isPosting = false;
    }

    private void postSingleEvent(Event event, PostingThreadState postingThreadState, Object obj) throws Error {
        if (this.eventInheritance ? postSingleEventForEventType(event, postingThreadState, obj) : false) {
            return;
        }
        if (this.logNoSubscriberMessages) {
            Log.d(TAG, "No subscribers registered for event " + event.type);
        }
        if (!this.sendNoSubscriberEvent || "kubus://internal/notification/send_no_subscriber_event".equals(event.type) || event.getClass() == SubscriberExceptionEvent.class) {
            return;
        }
        Event event2 = new Event("kubus://internal/notification/send_no_subscriber_event");
        event2.message = "No subscribers registered for event " + event.type;
        post(event2);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.youku.kubus.Event, com.youku.kubus.Subscription] */
    private boolean postSingleEventForEventType(Event event, PostingThreadState postingThreadState, Object obj) {
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.subscriptionsByEventType.get(event.type);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<Subscription> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            Subscription next = it.next();
            postingThreadState.event = event;
            postingThreadState.subscription = next;
            if (obj != null) {
                try {
                    if (next.subscriber == obj) {
                        postToSubscription(next, event, postingThreadState.isMainThread);
                    }
                } finally {
                    postingThreadState.event = null;
                    postingThreadState.subscription = null;
                    postingThreadState.canceled = false;
                }
            } else {
                postToSubscription(next, event, postingThreadState.isMainThread);
            }
            if (postingThreadState.canceled) {
                return true;
            }
        }
        return true;
    }

    private void postToSubscription(Subscription subscription, Event event, boolean z) {
        int i;
        if (event == null || event.isConsumed() || (i = AnonymousClass2.$SwitchMap$com$youku$kubus$ThreadMode[subscription.subscriberMethod.threadMode.ordinal()]) == 1) {
            return;
        }
        if (i == 2) {
            if (z) {
                return;
            }
            this.mainThreadPoster.enqueue(subscription, event);
        } else if (i == 3) {
            if (z) {
                this.backgroundPoster.enqueue(subscription, event);
            }
        } else if (i == 4) {
            this.asyncPoster.enqueue(subscription, event);
        } else {
            throw new IllegalStateException("Unknown thread mode: " + subscription.subscriberMethod.threadMode);
        }
    }

    private void postToSubscriptionImmediately(Subscription subscription, Event event, boolean z) {
        int i = AnonymousClass2.$SwitchMap$com$youku$kubus$ThreadMode[subscription.subscriberMethod.threadMode.ordinal()];
        if (i == 1) {
            invokeSubscriber(subscription, event);
        } else if (i == 2) {
            if (z) {
                invokeSubscriber(subscription, event);
            }
        } else if (i == 3 && !z) {
            invokeSubscriber(subscription, event);
        }
    }

    private void subscribe(Object obj, SubscriberMethod subscriberMethod) {
        String str = subscriberMethod.eventType;
        Subscription subscription = new Subscription(obj, subscriberMethod);
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList = this.subscriptionsByEventType.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.subscriptionsByEventType.put(str, copyOnWriteArrayList);
            if (!isValidEventType(str)) {
                Log.e(TAG, "wrong define of event type [" + str + ", must start with kubus://");
            }
        } else if (copyOnWriteArrayList.contains(subscription)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + str);
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || subscriberMethod.priority > copyOnWriteArrayList.get(i).subscriberMethod.priority) {
                copyOnWriteArrayList.add(i, subscription);
                break;
            }
        }
        List<String> list = this.eventTypesBySubscriber.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.eventTypesBySubscriber.put(obj, list);
        }
        list.add(str);
        if (subscriberMethod.sticky) {
            checkPostStickyEventToSubscription(subscription, this.stickyEvents.get(str));
        }
    }

    private void unsubscribeByEventType(Object obj, String str) {
        CopyOnWriteArrayList<Subscription> copyOnWriteArrayList = this.subscriptionsByEventType.get(str);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                Subscription subscription = copyOnWriteArrayList.get(i);
                if (subscription.subscriber == obj) {
                    subscription.active = false;
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    public void cancelEvent(Event event) {
        event.consume();
        this.dataSource.removeRequest(event.id);
        this.dataSource.removeResponse(event.id);
    }

    @Deprecated
    public void cancelEventDelivery(Event event) {
        PostingThreadState postingThreadState = this.currentPostingThreadState.get();
        if (!postingThreadState.isPosting) {
            throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        }
        if (event != null) {
            if (postingThreadState.event == event) {
                if (postingThreadState.subscription.subscriberMethod.threadMode == ThreadMode.POSTING) {
                    postingThreadState.canceled = true;
                    return;
                }
                throw new EventBusException(" event handlers may only abort the incoming event");
            }
            throw new EventBusException("Only the currently handled event may be aborted");
        }
        throw new EventBusException("Event may not be null");
    }

    public String getChannelId() {
        return this.channelId;
    }

    void getData(long j) {
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public String getName() {
        return this.name;
    }

    public Request getRequest(Event event) {
        return getRequest(event.id);
    }

    public Response getResponse(long j) {
        return this.dataSource.getResponse(j);
    }

    public Event getStickyEvent(String str) {
        Event event;
        synchronized (this.stickyEvents) {
            event = this.stickyEvents.get(str);
        }
        return event;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invokeSubscriber(PendingPost pendingPost) {
        Event event = pendingPost.event;
        Subscription subscription = pendingPost.subscription;
        PendingPost.releasePendingPost(pendingPost);
        if (!subscription.active || event.isConsumed()) {
            return;
        }
        invokeSubscriber(subscription, event);
    }

    public synchronized boolean isRegistered(Object obj) {
        return this.eventTypesBySubscriber.containsKey(obj);
    }

    public void post(Event event) {
        post(event, null);
    }

    public void postSticky(Event event) {
        synchronized (this.stickyEvents) {
            this.stickyEvents.put(event.type, event);
        }
        post(event);
    }

    void putData(long j, Object obj) {
    }

    public void register(Object obj) {
        List<SubscriberMethod> findSubscriberMethods = this.subscriberMethodFinder.findSubscriberMethods(obj.getClass());
        synchronized (this) {
            for (SubscriberMethod subscriberMethod : findSubscriberMethods) {
                subscribe(obj, subscriberMethod);
            }
        }
    }

    public void release(Event event) {
        event.consume();
        this.dataSource.removeRequest(event.id);
        this.dataSource.removeResponse(event.id);
    }

    public void removeAllStickyEvents() {
        synchronized (this.stickyEvents) {
            this.stickyEvents.clear();
        }
    }

    public Event removeStickyEvent(String str) {
        Event remove;
        synchronized (this.stickyEvents) {
            remove = this.stickyEvents.remove(str);
        }
        return remove;
    }

    public Response request(Event event) {
        return request(event, null);
    }

    public void response(Event event, Object obj) {
        Response response = this.dataSource.getResponse(event.id);
        response.code = 200;
        response.body = obj;
        response(event, response);
    }

    public String toString() {
        return "EventBus[eventInheritance=" + this.eventInheritance + jn1.ARRAY_END_STR;
    }

    public synchronized void unregister(Object obj) {
        List<String> list = this.eventTypesBySubscriber.get(obj);
        if (list != null) {
            for (String str : list) {
                unsubscribeByEventType(obj, str);
            }
            this.eventTypesBySubscriber.remove(obj);
        } else {
            Log.w(TAG, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventBus(EventBusBuilder eventBusBuilder) {
        this.EVENT_NO_SUBSCRIBER = "kubus://internal/notification/send_no_subscriber_event";
        this.currentPostingThreadState = new ThreadLocal<PostingThreadState>() { // from class: com.youku.kubus.EventBus.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public PostingThreadState initialValue() {
                return new PostingThreadState();
            }
        };
        this.subscriptionsByEventType = new HashMap();
        this.eventTypesBySubscriber = new HashMap();
        this.dataSource = new DataSource();
        this.stickyEvents = new ConcurrentHashMap();
        this.mainThreadPoster = new HandlerPoster(this, Looper.getMainLooper(), 10);
        this.backgroundPoster = new BackgroundPoster(this);
        this.asyncPoster = new AsyncPoster(this);
        this.subscriberMethodFinder = new SubscriberMethodFinder(eventBusBuilder.strictMethodVerification);
        this.isLoggable = eventBusBuilder.loggable;
        this.logSubscriberExceptions = eventBusBuilder.logSubscriberExceptions;
        this.logNoSubscriberMessages = eventBusBuilder.logNoSubscriberMessages;
        this.sendSubscriberExceptionEvent = eventBusBuilder.sendSubscriberExceptionEvent;
        this.sendNoSubscriberEvent = eventBusBuilder.sendNoSubscriberEvent;
        this.throwSubscriberException = eventBusBuilder.throwSubscriberException;
        this.eventInheritance = eventBusBuilder.eventInheritance;
        this.executorService = eventBusBuilder.executorService;
        this.statisticSwitchOn = eventBusBuilder.statisticSwitchOn;
        this.eventStatistic = eventBusBuilder.eventStatistic;
        long incrementAndGet = sBaseId.incrementAndGet();
        this.id = incrementAndGet;
        String valueOf = TextUtils.isEmpty(eventBusBuilder.name) ? String.valueOf(incrementAndGet) : eventBusBuilder.name;
        this.name = valueOf;
        this.channelId = valueOf + "-" + incrementAndGet;
    }

    public Request getRequest(long j) {
        return this.dataSource.getRequest(j);
    }

    public Response getResponse(Event event) {
        return this.dataSource.getResponse(event.id);
    }

    public void post(Event event, Object obj) {
        event.channel = this.channelId;
        event.target = obj;
        if (this.isLoggable) {
            Log.v(TAG, "channel [" + event.channel + "] post event [" + event.type + ":" + event.id + jn1.ARRAY_END_STR + " , message : " + event.message);
        }
        PostingThreadState postingThreadState = this.currentPostingThreadState.get();
        List<Event> list = postingThreadState.eventQueue;
        list.add(event);
        if (!postingThreadState.canceled) {
            postingThreadState.isPosting = true;
            postImmediately(event, postingThreadState, obj);
            boolean z = postingThreadState.isPosting;
            if (z) {
                return;
            }
            if (!z) {
                try {
                    postingThreadState.isMainThread = Looper.getMainLooper() == Looper.myLooper();
                    postingThreadState.isPosting = true;
                    while (!list.isEmpty()) {
                        postSingleEvent(list.remove(0), postingThreadState, obj);
                    }
                } finally {
                    postingThreadState.isPosting = false;
                    postingThreadState.isMainThread = false;
                }
            }
            return;
        }
        throw new EventBusException("Internal error. Abort state was not reset");
    }

    public Response request(Event event, Object obj) {
        Request request = new Request(event.id);
        request.params = obj;
        request.mode = "sync";
        this.dataSource.putRequest(event.id, request);
        Response response = new Response(event.id);
        response.code = 0;
        this.dataSource.putResponse(event.id, response);
        post(event);
        return response;
    }

    public boolean removeStickyEvent(Event event) {
        synchronized (this.stickyEvents) {
            for (Map.Entry<String, Event> entry : this.stickyEvents.entrySet()) {
                if (event.equals(entry.getValue())) {
                    this.stickyEvents.remove(entry.getKey());
                    return true;
                }
            }
            return false;
        }
    }

    public void response(Event event, Response response) {
        this.dataSource.putResponse(event.id, response);
    }

    void invokeSubscriber(Subscription subscription, Event event) {
        IEventStatistic iEventStatistic;
        IEventStatistic iEventStatistic2;
        IEventStatistic iEventStatistic3;
        IEventStatistic iEventStatistic4;
        try {
            if (event.isConsumed()) {
                return;
            }
            Object obj = event.target;
            if (obj == null || obj == subscription.subscriber) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.statisticSwitchOn && (iEventStatistic4 = this.eventStatistic) != null) {
                    SubscriberMethod subscriberMethod = subscription.subscriberMethod;
                    iEventStatistic4.methodInvokeBegin(event, subscriberMethod.method, subscriberMethod.threadMode, elapsedRealtime);
                }
                subscription.subscriberMethod.method.invoke(subscription.subscriber, event);
                if (this.isLoggable) {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                    if (elapsedRealtime2 > 10 && this.isLoggable) {
                        Log.v(TAG, " cost time " + elapsedRealtime2 + " \tms : " + subscription.subscriberMethod.dumpInfo());
                    }
                }
                if (!this.statisticSwitchOn || (iEventStatistic3 = this.eventStatistic) == null) {
                    return;
                }
                SubscriberMethod subscriberMethod2 = subscription.subscriberMethod;
                iEventStatistic3.methodInvokeEnd(event, subscriberMethod2.method, subscriberMethod2.threadMode, elapsedRealtime, SystemClock.elapsedRealtime());
            }
        } catch (IllegalAccessException e) {
            if (this.statisticSwitchOn && (iEventStatistic2 = this.eventStatistic) != null) {
                SubscriberMethod subscriberMethod3 = subscription.subscriberMethod;
                iEventStatistic2.methodInvokeFailed(event, subscriberMethod3.method, subscriberMethod3.threadMode, e.getCause());
            }
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            handleSubscriberException(subscription, event, e2.getCause());
            if (!this.statisticSwitchOn || (iEventStatistic = this.eventStatistic) == null) {
                return;
            }
            SubscriberMethod subscriberMethod4 = subscription.subscriberMethod;
            iEventStatistic.methodInvokeFailed(event, subscriberMethod4.method, subscriberMethod4.threadMode, e2.getCause());
        }
    }
}
