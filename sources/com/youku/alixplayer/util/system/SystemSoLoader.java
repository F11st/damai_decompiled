package com.youku.alixplayer.util.system;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class SystemSoLoader {
    private static final PrioritySoLoader sSoLoader = new PrioritySoLoader();

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static class DefaultSystemSoLoader implements ISoLoader {
        private DefaultSystemSoLoader() {
        }

        @Override // com.youku.alixplayer.util.system.SystemSoLoader.ISoLoader
        public boolean loadLibrary(String str) {
            try {
                Log.e("Android", "DefaultSystemSoLoader: " + System.class.getClassLoader().toString());
                System.loadLibrary(str);
                return true;
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public interface ISoLoader {
        boolean loadLibrary(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static class PrioritySoLoader implements ISoLoader {
        private List<ISoLoader> mSoLoader;

        public PrioritySoLoader() {
            ArrayList arrayList = new ArrayList();
            this.mSoLoader = arrayList;
            arrayList.add(new DefaultSystemSoLoader());
        }

        public int getLoaderSize() {
            return this.mSoLoader.size();
        }

        @Override // com.youku.alixplayer.util.system.SystemSoLoader.ISoLoader
        public boolean loadLibrary(String str) {
            return loadLibrary(str, -1);
        }

        public boolean loadLibrary(String str, int i) {
            if (i < 0 || i >= this.mSoLoader.size()) {
                for (ISoLoader iSoLoader : this.mSoLoader) {
                    boolean loadLibrary = iSoLoader.loadLibrary(str);
                    if (loadLibrary) {
                        return loadLibrary;
                    }
                }
                return false;
            }
            return this.mSoLoader.get(i).loadLibrary(str);
        }
    }

    public static void addSoLoader(ISoLoader iSoLoader) {
        sSoLoader.mSoLoader.add(0, iSoLoader);
    }

    public static void batchLoad(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < sSoLoader.getLoaderSize(); i2++) {
            while (sSoLoader.loadLibrary(strArr[i], i2)) {
                i++;
                if (i >= strArr.length) {
                    return;
                }
            }
        }
    }

    public static void load(String str) {
        Log.e("Android", "SystemSoLoader: " + SystemSoLoader.class.getClassLoader().toString());
        sSoLoader.loadLibrary(str);
    }
}
