package android.taobao.windvane.xmlmanager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.taobao.windvane.util.TaoLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVXmlResUtils {
    public static Bitmap obtainBitmapFromAssets(Context context, String str) {
        try {
            return BitmapFactory.decodeStream(context.getAssets().open(str));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static View obtainViewFromAssets(Context context, String str, String str2) {
        return new WVLoadableResources(str).loadLayout(context, str2);
    }

    public static View obtainViewFromFile(Context context, String str, ViewGroup viewGroup) {
        try {
            return LayoutInflater.from(context).inflate(new WVFileParser().openXmlResourceParser(str), viewGroup);
        } catch (Throwable th) {
            TaoLog.e("Puti Inflater XmlBlock Error", th.toString());
            return null;
        }
    }
}
