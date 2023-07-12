package com.youku.asyncview.core;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.youku.asyncview.AsyncViewSetting;
import com.youku.asyncview.IViewCreator;
import com.youku.asyncview.ViewContext;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class AsyncViewMemoryManager implements IMemoryManager {
    private boolean mIsDebug;
    private LayoutInflater mLayoutInflater;
    private MemoryMonitor mMemoryMonitor;
    private final SparseArray<AsyncViewPool> mAsyncViewPoolMap = new SparseArray<>();
    private IViewCreator mDefaultViewCreator = new IViewCreator() { // from class: com.youku.asyncview.core.AsyncViewMemoryManager.1
        @Override // com.youku.asyncview.IViewCreator
        public View createView(ViewContext viewContext, int i) {
            if (AsyncViewMemoryManager.this.mLayoutInflater == null) {
                AsyncViewMemoryManager.this.mLayoutInflater = LayoutInflater.from(viewContext).cloneInContext(viewContext);
            }
            try {
                return AsyncViewMemoryManager.this.mLayoutInflater.inflate(i, (ViewGroup) null, false);
            } catch (Throwable unused) {
                return null;
            }
        }
    };
    private MemoryStateListener mMemoryStateListener = new MemoryStateListener() { // from class: com.youku.asyncview.core.AsyncViewMemoryManager.2
        @Override // com.youku.asyncview.core.MemoryStateListener
        public void onLowMemory() {
            AsyncViewMemoryManager.this.innerOnLowMemory();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncViewMemoryManager(Context context) {
        MemoryMonitor memoryMonitor = new MemoryMonitor(context.getApplicationContext());
        this.mMemoryMonitor = memoryMonitor;
        memoryMonitor.setMemoryStateListener(this.mMemoryStateListener);
        this.mMemoryMonitor.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerOnLowMemory() {
        ArrayList arrayList = new ArrayList();
        SparseArray<AsyncViewPool> sparseArray = this.mAsyncViewPoolMap;
        synchronized (sparseArray) {
            if (sparseArray.size() == 0) {
                return;
            }
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                AsyncViewPool valueAt = sparseArray.valueAt(i);
                AsyncViewSetting.AsyncViewPriority priority = valueAt.getPriority();
                if (AsyncViewSetting.AsyncViewPriority.LOW == priority || AsyncViewSetting.AsyncViewPriority.NORMAL == priority) {
                    arrayList.add(valueAt);
                }
            }
            if (arrayList.size() == 0) {
                return;
            }
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((AsyncViewPool) arrayList.get(i2)).clear();
            }
        }
    }

    private boolean isAsyncView(View view) {
        return view != null && (view.getContext() instanceof ViewContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncViewPool buildAsyncViewPool(ViewContext viewContext, AsyncViewSetting asyncViewSetting) {
        return new AsyncViewPool(viewContext, asyncViewSetting, this.mDefaultViewCreator);
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void gcAllAsyncViews() {
        SparseArray<AsyncViewPool> sparseArray = this.mAsyncViewPoolMap;
        synchronized (sparseArray) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                sparseArray.valueAt(i).clear();
            }
        }
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void gcAsyncViews(int i) {
        synchronized (this.mAsyncViewPoolMap) {
            AsyncViewPool asyncViewPool = this.mAsyncViewPoolMap.get(i);
            if (asyncViewPool != null) {
                asyncViewPool.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getAsyncView(int i, String str) {
        AsyncViewPool asyncViewPool;
        synchronized (this.mAsyncViewPoolMap) {
            asyncViewPool = this.mAsyncViewPoolMap.get(i);
        }
        if (asyncViewPool == null) {
            return null;
        }
        return asyncViewPool.checkOut(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putAsyncViewPool(int i, AsyncViewPool asyncViewPool) {
        if (i <= 0 || asyncViewPool == null) {
            return;
        }
        synchronized (this.mAsyncViewPoolMap) {
            this.mAsyncViewPoolMap.put(i, asyncViewPool);
        }
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void recyclerAllAsyncViews() {
        SparseArray<AsyncViewPool> sparseArray = this.mAsyncViewPoolMap;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            sparseArray.valueAt(i).reset();
        }
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void recyclerAsyncView(int i, View view) {
        AsyncViewPool asyncViewPool;
        if (view == null || i <= 0 || !isAsyncView(view)) {
            return;
        }
        synchronized (this.mAsyncViewPoolMap) {
            asyncViewPool = this.mAsyncViewPoolMap.get(i);
        }
        if (asyncViewPool == null) {
            return;
        }
        asyncViewPool.checkIn(view);
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void recyclerGroupAsyncViews(String str) {
        SparseArray<AsyncViewPool> sparseArray = this.mAsyncViewPoolMap;
        synchronized (sparseArray) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                sparseArray.valueAt(i).resetGroup(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAsyncViewSetting(ViewContext viewContext, AsyncViewSetting asyncViewSetting) {
        if (asyncViewSetting == null || asyncViewSetting.getLayoutId() <= 0) {
            return;
        }
        int layoutId = asyncViewSetting.getLayoutId();
        SparseArray<AsyncViewPool> sparseArray = this.mAsyncViewPoolMap;
        AsyncViewPool asyncViewPool = sparseArray.get(layoutId);
        if (asyncViewPool == null) {
            AsyncViewPool asyncViewPool2 = new AsyncViewPool(viewContext, asyncViewSetting, this.mDefaultViewCreator);
            asyncViewPool2.setDebug(this.mIsDebug);
            sparseArray.put(layoutId, asyncViewPool2);
            return;
        }
        asyncViewPool.setMaxNum(asyncViewSetting.getCacheSize());
        asyncViewPool.setPriority(asyncViewSetting.getPriority());
        asyncViewPool.setViewCreator(asyncViewSetting.getViewCreater());
    }

    public void setDebug(boolean z) {
        this.mIsDebug = z;
        SparseArray<AsyncViewPool> sparseArray = this.mAsyncViewPoolMap;
        synchronized (sparseArray) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                sparseArray.valueAt(i).setDebug(z);
            }
        }
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void setDefaultViewCreator(IViewCreator iViewCreator) {
        if (iViewCreator == null) {
            return;
        }
        this.mDefaultViewCreator = iViewCreator;
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void recyclerAsyncView(int i, List<View> list) {
        AsyncViewPool asyncViewPool;
        if (list == null || list.size() == 0 || i <= 0) {
            return;
        }
        if (isAsyncView(list.get(0))) {
            synchronized (this.mAsyncViewPoolMap) {
                asyncViewPool = this.mAsyncViewPoolMap.get(i);
            }
            if (asyncViewPool == null) {
                return;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size && asyncViewPool.checkIn(list.get(i2)); i2++) {
            }
        }
    }
}
