package com.youku.asyncview.core;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.youku.asyncview.AsyncViewSetting;
import com.youku.asyncview.IAsyncViewManager;
import com.youku.asyncview.IViewCreator;
import com.youku.asyncview.ViewContext;
import com.youku.asyncview.utils.AssertUtil;
import com.youku.asyncview.utils.CallbackUtil;
import com.youku.asyncview.utils.ThreadUtil;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AsyncViewManager implements IAsyncViewManager {
    private static final String TAG = "AsyncViewManager";
    private boolean mIsDebug;
    private AsyncViewMemoryManager mMemoryManager;
    private ViewContext mViewContext;

    public AsyncViewManager(Context context) {
        this.mViewContext = new ViewContext(context);
        AsyncViewMemoryManager asyncViewMemoryManager = new AsyncViewMemoryManager(context);
        this.mMemoryManager = asyncViewMemoryManager;
        asyncViewMemoryManager.setDebug(this.mIsDebug);
        if (this.mIsDebug) {
            AssertUtil.throwIf(!CallbackUtil.isRunOnUiThread());
        }
    }

    private void asyncPreLoad(final List<AsyncViewSetting> list) {
        new Thread(new Runnable() { // from class: com.youku.asyncview.core.AsyncViewManager.1
            @Override // java.lang.Runnable
            public void run() {
                AsyncViewManager.this.runAsyncPreLoad(list);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runAsyncPreLoad(List<AsyncViewSetting> list) {
        ThreadUtil.forceSetMainLoop();
        AsyncViewMemoryManager asyncViewMemoryManager = this.mMemoryManager;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AsyncViewSetting asyncViewSetting = list.get(i);
            AsyncViewPool buildAsyncViewPool = asyncViewMemoryManager.buildAsyncViewPool(this.mViewContext, asyncViewSetting);
            buildAsyncViewPool.setDebug(this.mIsDebug);
            buildAsyncViewPool.init(asyncViewSetting.getInitNum());
            asyncViewMemoryManager.putAsyncViewPool(asyncViewSetting.getLayoutId(), buildAsyncViewPool);
        }
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void gcAllAsyncViews() {
        if (this.mIsDebug) {
            AssertUtil.throwIf(!CallbackUtil.isRunOnUiThread());
        }
        this.mMemoryManager.gcAllAsyncViews();
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void gcAsyncViews(int i) {
        if (this.mIsDebug) {
            AssertUtil.throwIf(!CallbackUtil.isRunOnUiThread());
        }
        this.mMemoryManager.gcAsyncViews(i);
    }

    @Override // com.youku.asyncview.IAsyncViewManager
    public View getAsyncView(int i, String str) {
        if (this.mIsDebug) {
            AssertUtil.throwIf(!CallbackUtil.isRunOnUiThread());
        }
        return this.mMemoryManager.getAsyncView(i, str);
    }

    @Override // com.youku.asyncview.IAsyncViewManager
    public ViewContext getViewContext() {
        if (this.mIsDebug) {
            AssertUtil.throwIf(!CallbackUtil.isRunOnUiThread());
        }
        return this.mViewContext;
    }

    @Override // com.youku.asyncview.IAsyncViewManager
    public void preLoadAsyncView(List<AsyncViewSetting> list) {
        if (this.mIsDebug) {
            AssertUtil.throwIf(!CallbackUtil.isRunOnUiThread());
        }
        if (list == null || list.size() == 0) {
            return;
        }
        asyncPreLoad(list);
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void recyclerAllAsyncViews() {
        if (this.mIsDebug) {
            AssertUtil.throwIf(!CallbackUtil.isRunOnUiThread());
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mMemoryManager.recyclerAllAsyncViews();
        if (this.mIsDebug) {
            Log.w(TAG, "recyclerAllAsyncViews: time = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void recyclerAsyncView(int i, View view) {
        if (this.mIsDebug) {
            AssertUtil.throwIf(!(view.getContext() instanceof ViewContext));
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mMemoryManager.recyclerAsyncView(i, view);
        if (this.mIsDebug) {
            Log.w(TAG, "recyclerAsyncView view : time = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void recyclerGroupAsyncViews(String str) {
        if (this.mIsDebug) {
            AssertUtil.throwIf(!CallbackUtil.isRunOnUiThread());
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mMemoryManager.recyclerGroupAsyncViews(str);
        if (this.mIsDebug) {
            Log.w(TAG, "recyclerGroupAsyncViews: time = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    @Override // com.youku.asyncview.IAsyncViewManager
    public void refreshCurrentActivity(Activity activity) {
        this.mViewContext.setCurrentContext(activity);
    }

    @Override // com.youku.asyncview.IAsyncViewManager
    public void setAsyncViewSetting(AsyncViewSetting asyncViewSetting) {
        if (this.mIsDebug) {
            AssertUtil.throwIf(!CallbackUtil.isRunOnUiThread());
        }
        this.mMemoryManager.setAsyncViewSetting(this.mViewContext, asyncViewSetting);
    }

    @Override // com.youku.asyncview.IAsyncViewManager
    public void setDebug(boolean z) {
        this.mIsDebug = z;
        this.mMemoryManager.setDebug(z);
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void setDefaultViewCreator(IViewCreator iViewCreator) {
        if (this.mIsDebug) {
            AssertUtil.throwIf(!CallbackUtil.isRunOnUiThread());
        }
        this.mMemoryManager.setDefaultViewCreator(iViewCreator);
    }

    @Override // com.youku.asyncview.core.IMemoryManager
    public void recyclerAsyncView(int i, List<View> list) {
        if (this.mIsDebug) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                AssertUtil.throwIf(!(list.get(i2).getContext() instanceof ViewContext));
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mMemoryManager.recyclerAsyncView(i, list);
        if (this.mIsDebug) {
            Log.w(TAG, "recyclerAsyncView list : time = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }
}
