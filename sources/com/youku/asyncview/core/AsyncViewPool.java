package com.youku.asyncview.core;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.util.Pools;
import com.youku.asyncview.AsyncViewSetting;
import com.youku.asyncview.IViewCreator;
import com.youku.asyncview.ViewContext;
import com.youku.asyncview.sdk.R;
import com.youku.asyncview.utils.ThreadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class AsyncViewPool {
    private static final String TAG = "AsyncViewPool";
    private IViewCreator mCustomViewCreator;
    private IViewCreator mDefaultViewCreator;
    private boolean mIsDebug;
    private int mLayoutId;
    private int mMaxNum;
    private AsyncViewSetting.AsyncViewPriority mPriority;
    private ViewContext mViewContext;
    private ArrayList<View> mPool = new ArrayList<>();
    private ArrayList<GroupInfo> mGroupList = new ArrayList<>();
    private Object mLock = new Object();
    private int mTagId = R.id.async_pool_view_tag;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class GroupInfo {
        private int mCount;
        private String mName;

        private GroupInfo() {
        }

        public int getCount() {
            return this.mCount;
        }

        public String getName() {
            return this.mName;
        }

        public void setCount(int i) {
            this.mCount = i;
        }

        public void setName(String str) {
            this.mName = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class InflateRequest {
        int count;
        AsyncViewPool pool;

        InflateRequest() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class InflateThread extends Thread {
        private static final InflateThread sInstance;
        private ArrayBlockingQueue<InflateRequest> mQueue = new ArrayBlockingQueue<>(100);
        private Pools.SynchronizedPool<InflateRequest> mRequestPool = new Pools.SynchronizedPool<>(100);

        static {
            InflateThread inflateThread = new InflateThread();
            sInstance = inflateThread;
            inflateThread.start();
        }

        private InflateThread() {
        }

        public static InflateThread getInstance() {
            return sInstance;
        }

        public void enqueue(InflateRequest inflateRequest) {
            try {
                this.mQueue.put(inflateRequest);
            } catch (InterruptedException e) {
                throw new RuntimeException("Failed to enqueue async inflate request", e);
            }
        }

        public InflateRequest obtainRequest() {
            InflateRequest acquire = this.mRequestPool.acquire();
            return acquire == null ? new InflateRequest() : acquire;
        }

        public void releaseRequest(InflateRequest inflateRequest) {
            inflateRequest.count = 0;
            inflateRequest.pool = null;
            this.mRequestPool.release(inflateRequest);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ThreadUtil.forceSetMainLoop();
            while (true) {
                runInner();
            }
        }

        public void runInner() {
            int i;
            try {
                InflateRequest take = this.mQueue.take();
                AsyncViewPool asyncViewPool = take.pool;
                if (asyncViewPool != null && (i = take.count) > 0) {
                    asyncViewPool.init(i);
                }
                releaseRequest(take);
            } catch (InterruptedException e) {
                Log.w(AsyncViewPool.TAG, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncViewPool(ViewContext viewContext, AsyncViewSetting asyncViewSetting, IViewCreator iViewCreator) {
        this.mMaxNum = asyncViewSetting.getCacheSize();
        this.mLayoutId = asyncViewSetting.getLayoutId();
        this.mPriority = asyncViewSetting.getPriority();
        this.mCustomViewCreator = asyncViewSetting.getViewCreater();
        this.mDefaultViewCreator = iViewCreator;
        this.mViewContext = viewContext;
    }

    private GroupInfo findGroupInfo(String str) {
        Iterator<GroupInfo> it = this.mGroupList.iterator();
        while (it.hasNext()) {
            GroupInfo next = it.next();
            if (next.getName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    private boolean innerGroupNameCountCut(String str) {
        int count;
        GroupInfo findGroupInfo = findGroupInfo(str);
        if (findGroupInfo == null || (count = findGroupInfo.getCount()) <= 1) {
            return false;
        }
        findGroupInfo.setCount(count - 1);
        return true;
    }

    private int innerGroupTotalCount() {
        Iterator<GroupInfo> it = this.mGroupList.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().getCount();
        }
        if (this.mIsDebug) {
            Log.w(TAG, "innerGroupTotalCount: count = " + i);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean checkIn(View view) {
        boolean innerGroupNameCountCut;
        if (view == null) {
            return true;
        }
        Object tag = view.getTag(this.mTagId);
        String str = tag instanceof String ? (String) tag : null;
        if (this.mIsDebug) {
            Log.w(TAG, "checkIn: groupName = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        synchronized (this.mLock) {
            innerGroupNameCountCut = innerGroupNameCountCut(str);
        }
        if (this.mIsDebug) {
            Log.w(TAG, "checkIn: isFillPool = " + innerGroupNameCountCut);
        }
        if (innerGroupNameCountCut) {
            fillPool(1);
            return true;
        }
        return false;
    }

    public View checkOut(String str) {
        View view;
        ArrayList<View> arrayList;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.mLock) {
            if (this.mPool.size() > 0) {
                view = this.mPool.remove(arrayList.size() - 1);
            } else {
                view = null;
            }
            if (this.mIsDebug) {
                Log.w(TAG, "checkOut: 1 groupName = " + str + ",view = " + view);
            }
            if (view != null) {
                view.setTag(this.mTagId, str);
                GroupInfo findGroupInfo = findGroupInfo(str);
                if (findGroupInfo == null) {
                    findGroupInfo = new GroupInfo();
                    findGroupInfo.setName(str);
                    this.mGroupList.add(findGroupInfo);
                }
                if (innerGroupTotalCount() < this.mMaxNum) {
                    findGroupInfo.setCount(findGroupInfo.getCount() + 1);
                }
                if (this.mIsDebug) {
                    Log.w(TAG, "checkOut: 1 group size = " + this.mGroupList.size());
                    innerGroupTotalCount();
                }
                return view;
            }
            View create = create();
            if (this.mIsDebug) {
                Log.w(TAG, "checkOut: 2 groupName = " + str + ",view = " + create);
            }
            if (create != null) {
                synchronized (this.mLock) {
                    GroupInfo findGroupInfo2 = findGroupInfo(str);
                    if (findGroupInfo2 == null) {
                        findGroupInfo2 = new GroupInfo();
                        findGroupInfo2.setName(str);
                        this.mGroupList.add(findGroupInfo2);
                    }
                    if (innerGroupTotalCount() < this.mMaxNum) {
                        findGroupInfo2.setCount(findGroupInfo2.getCount() + 1);
                        create.setTag(this.mTagId, str);
                    }
                    if (this.mIsDebug) {
                        Log.w(TAG, "checkOut: 2 group size = " + this.mGroupList.size());
                        innerGroupTotalCount();
                    }
                }
            }
            return create;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        synchronized (this.mLock) {
            this.mPool.clear();
            this.mGroupList.clear();
        }
    }

    View create() {
        synchronized (this.mLock) {
            if (this.mPool.size() > this.mMaxNum) {
                return null;
            }
            IViewCreator iViewCreator = this.mCustomViewCreator;
            if (iViewCreator != null) {
                try {
                    return iViewCreator.createView(this.mViewContext, this.mLayoutId);
                } catch (Throwable unused) {
                    return null;
                }
            }
            return this.mDefaultViewCreator.createView(this.mViewContext, this.mLayoutId);
        }
    }

    void fillPool(int i) {
        InflateRequest obtainRequest = InflateThread.getInstance().obtainRequest();
        obtainRequest.pool = this;
        obtainRequest.count = i;
        if (this.mIsDebug) {
            Log.w(TAG, "fillPool: count = " + obtainRequest.count + ",mMaxNum = " + this.mMaxNum);
        }
        InflateThread.getInstance().enqueue(obtainRequest);
    }

    public AsyncViewSetting.AsyncViewPriority getPriority() {
        return this.mPriority;
    }

    public void init(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        for (int i2 = 0; i2 < i; i2++) {
            View create = create();
            if (create != null) {
                synchronized (this.mLock) {
                    this.mPool.add(create);
                }
            }
        }
        if (this.mIsDebug) {
            Log.w(TAG, "init: time = " + (System.currentTimeMillis() - currentTimeMillis));
            synchronized (this.mLock) {
                Log.w(TAG, "init: pool size = " + this.mPool.size());
                ArrayList<GroupInfo> arrayList = this.mGroupList;
                if (arrayList.size() > 0) {
                    Iterator<GroupInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        GroupInfo next = it.next();
                        Log.w(TAG, "init: info name = " + next.getName() + ",count = " + next.getCount());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        int i;
        synchronized (this.mLock) {
            Iterator<GroupInfo> it = this.mGroupList.iterator();
            i = 0;
            while (it.hasNext()) {
                i += it.next().getCount();
            }
        }
        if (i > 0) {
            fillPool(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetGroup(String str) {
        int i;
        synchronized (this.mLock) {
            GroupInfo findGroupInfo = findGroupInfo(str);
            i = 0;
            if (findGroupInfo != null) {
                int count = findGroupInfo.getCount();
                findGroupInfo.setCount(0);
                i = count;
            }
        }
        if (i > 0) {
            fillPool(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDebug(boolean z) {
        this.mIsDebug = z;
        if (z) {
            Log.w(TAG, "setDebug: mTagId = " + this.mTagId);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxNum(int i) {
        synchronized (this.mLock) {
            ArrayList<View> arrayList = this.mPool;
            if (arrayList.size() > i) {
                int size = arrayList.size() - i;
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
            int innerGroupTotalCount = innerGroupTotalCount();
            if (innerGroupTotalCount > i) {
                int i3 = innerGroupTotalCount - i;
                Iterator<GroupInfo> it = this.mGroupList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    GroupInfo next = it.next();
                    if (i3 - next.getCount() > 0) {
                        i3 -= next.getCount();
                        next.setCount(0);
                    } else {
                        next.setCount(next.getCount() - i3);
                        break;
                    }
                }
            }
            if (this.mIsDebug) {
                Log.w(TAG, "init: pool size = " + this.mPool.size() + ",maxNum = " + i);
                ArrayList<GroupInfo> arrayList2 = this.mGroupList;
                if (arrayList2.size() > 0) {
                    Iterator<GroupInfo> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        GroupInfo next2 = it2.next();
                        Log.w(TAG, "init: info name = " + next2.getName() + ",count = " + next2.getCount());
                    }
                }
            }
        }
        this.mMaxNum = i;
    }

    public void setPriority(AsyncViewSetting.AsyncViewPriority asyncViewPriority) {
        this.mPriority = asyncViewPriority;
    }

    public void setViewCreator(IViewCreator iViewCreator) {
        this.mCustomViewCreator = iViewCreator;
    }
}
