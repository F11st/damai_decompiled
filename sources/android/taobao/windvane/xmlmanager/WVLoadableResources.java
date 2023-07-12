package android.taobao.windvane.xmlmanager;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVLoadableResources {
    private static final Method AssetManager_addAssetPath;
    private static final String TAG = "DynRes";
    final AssetManager mAssets;
    final int mCookie;

    static {
        Method[] methods;
        Method method;
        try {
            method = AssetManager.class.getMethod("addAssetPath", String.class);
        } catch (NoSuchMethodException unused) {
            Log.w(TAG, "Incompatible ROM: No matched AssetManager.addAssetPath().");
            for (Method method2 : AssetManager.class.getMethods()) {
                if (method2.getName().startsWith("addAssetPath")) {
                    Log.w(TAG, "  Possible variant: " + method2);
                }
            }
            method = null;
        }
        AssetManager_addAssetPath = method;
    }

    public WVLoadableResources(String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            this.mAssets = assetManager;
            Method method = AssetManager_addAssetPath;
            if (method != null) {
                int intValue = ((Integer) method.invoke(assetManager, str)).intValue();
                this.mCookie = intValue;
                if (intValue != 0) {
                    return;
                }
                throw new IllegalArgumentException("Failed to set asset path: " + str);
            }
            throw new IllegalStateException();
        } catch (Throwable th) {
            throw new IllegalStateException(th);
        }
    }

    protected void finalize() throws Throwable {
        try {
            AssetManager assetManager = this.mAssets;
            if (assetManager != null) {
                assetManager.close();
            }
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
        super.finalize();
    }

    public View loadLayout(Context context, String str) {
        Resources resources = context.getResources();
        try {
            return LayoutInflater.from(context).inflate(new Resources(this.mAssets, resources.getDisplayMetrics(), resources.getConfiguration()).getAssets().openXmlResourceParser(str), (ViewGroup) null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public XmlResourceParser openXmlResourceParser(String str) throws IOException {
        return this.mAssets.openXmlResourceParser(this.mCookie, str);
    }
}
