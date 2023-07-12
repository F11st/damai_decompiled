package com.youku.asyncview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.youku.asyncview.AsyncPlusLayoutInflater;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AsyncViewPreLoader {
    private static HashMap<Context, AsyncViewPreLoader> sAsyncViewPreLoaderServiceList = new HashMap<>();
    private Context mContext;
    private InflateInterceptor mInflateInterceptor;
    private HashMap<Integer, ArrayList<View>> mViewPool = new HashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static class AsyncViewPreLoaderLayoutInflater extends LayoutInflater {
        private LayoutInflater mOriginalLayoutInflater;

        protected AsyncViewPreLoaderLayoutInflater(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new AsyncViewPreLoaderLayoutInflater(context);
        }

        @Override // android.view.LayoutInflater
        public View inflate(int i, @Nullable ViewGroup viewGroup, boolean z) {
            AsyncViewPreLoader asyncViewPreLoader = AsyncViewPreLoader.getAsyncViewPreLoader(getContext());
            View inflate = (asyncViewPreLoader == null || asyncViewPreLoader.getInflateInterceptor() == null) ? null : asyncViewPreLoader.getInflateInterceptor().inflate(asyncViewPreLoader, i, viewGroup, z);
            if (inflate != null) {
                return inflate;
            }
            LayoutInflater layoutInflater = this.mOriginalLayoutInflater;
            if (layoutInflater != null) {
                return layoutInflater.inflate(i, viewGroup, z);
            }
            return super.inflate(i, viewGroup, z);
        }

        public AsyncViewPreLoaderLayoutInflater(LayoutInflater layoutInflater, Context context) {
            super(layoutInflater, context);
            this.mOriginalLayoutInflater = layoutInflater;
        }

        @Override // android.view.LayoutInflater
        public View inflate(XmlPullParser xmlPullParser, @Nullable ViewGroup viewGroup) {
            LayoutInflater layoutInflater = this.mOriginalLayoutInflater;
            if (layoutInflater != null) {
                return layoutInflater.inflate(xmlPullParser, viewGroup);
            }
            return super.inflate(xmlPullParser, viewGroup);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface InflateInterceptor {
        View inflate(AsyncViewPreLoader asyncViewPreLoader, int i, @Nullable ViewGroup viewGroup, boolean z);
    }

    private AsyncViewPreLoader(Context context) {
        this.mContext = context;
    }

    public static LayoutInflater getAsyncViewLayoutInflater(Context context, LayoutInflater layoutInflater) {
        return getAsyncViewPreLoader(context) == null ? layoutInflater : new AsyncViewPreLoaderLayoutInflater(layoutInflater, context);
    }

    public static AsyncViewPreLoader getAsyncViewPreLoader(Context context) {
        AsyncViewPreLoader asyncViewPreLoader;
        synchronized (sAsyncViewPreLoaderServiceList) {
            asyncViewPreLoader = sAsyncViewPreLoaderServiceList.get(context);
        }
        return asyncViewPreLoader;
    }

    public static AsyncViewPreLoader registerAsyncViewPreLoaderService(Context context) {
        AsyncViewPreLoader asyncViewPreLoader;
        synchronized (sAsyncViewPreLoaderServiceList) {
            if (!sAsyncViewPreLoaderServiceList.containsKey(context)) {
                asyncViewPreLoader = new AsyncViewPreLoader(context);
                sAsyncViewPreLoaderServiceList.put(context, asyncViewPreLoader);
            } else {
                asyncViewPreLoader = sAsyncViewPreLoaderServiceList.get(context);
            }
        }
        return asyncViewPreLoader;
    }

    public static void unregisterAsyncViewPreLoaderService(Context context) {
        synchronized (sAsyncViewPreLoaderServiceList) {
            sAsyncViewPreLoaderServiceList.remove(context);
        }
    }

    public void asyncPreLoaderView(int i) {
        asyncPreLoaderView(i, 1);
    }

    public void clean() {
        synchronized (this.mViewPool) {
            this.mViewPool.clear();
        }
    }

    public View getAsyncCacheView(int i) {
        View remove;
        synchronized (this.mViewPool) {
            ArrayList<View> arrayList = this.mViewPool.get(Integer.valueOf(i));
            remove = (arrayList == null || arrayList.size() <= 0) ? null : arrayList.remove(0);
        }
        return remove;
    }

    public Context getContext() {
        return this.mContext;
    }

    public InflateInterceptor getInflateInterceptor() {
        return this.mInflateInterceptor;
    }

    public void setInflateInterceptor(InflateInterceptor inflateInterceptor) {
        this.mInflateInterceptor = inflateInterceptor;
    }

    public void asyncPreLoaderView(int i, int i2) {
        asyncPreLoaderView(i, null, i2);
    }

    public void asyncPreLoaderView(int i, ViewGroup viewGroup) {
        asyncPreLoaderView(i, viewGroup, 1);
    }

    public void asyncPreLoaderView(final int i, ViewGroup viewGroup, int i2) {
        synchronized (this.mViewPool) {
            if (this.mViewPool.get(Integer.valueOf(i)) == null) {
                this.mViewPool.put(Integer.valueOf(i), new ArrayList<>());
            }
        }
        AsyncPlusLayoutInflater asyncPlusLayoutInflater = new AsyncPlusLayoutInflater(getContext());
        asyncPlusLayoutInflater.setErrorAndMainCreate(false);
        asyncPlusLayoutInflater.setEnableMainHandlerCallback(false);
        asyncPlusLayoutInflater.setOnFastFinishedListener(new AsyncPlusLayoutInflater.OnFastFinishedListener() { // from class: com.youku.asyncview.AsyncViewPreLoader.1
            @Override // com.youku.asyncview.AsyncPlusLayoutInflater.OnFastFinishedListener
            public void onInflateFastFinished(View view, int i3, ViewGroup viewGroup2) {
                HashMap hashMap = AsyncViewPreLoader.this.mViewPool;
                if (hashMap == null || view == null) {
                    return;
                }
                synchronized (hashMap) {
                    ArrayList arrayList = (ArrayList) hashMap.get(Integer.valueOf(i));
                    if (arrayList != null && !arrayList.contains(view)) {
                        arrayList.add(view);
                    }
                }
            }
        });
        for (int i3 = 0; i3 < i2; i3++) {
            asyncPlusLayoutInflater.inflate(i, viewGroup, null);
        }
    }
}
