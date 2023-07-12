package android.taobao.windvane.connect.api;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVApiWrapper {
    public static String formatBody(ApiRequest apiRequest, Class<? extends IApiAdapter> cls) {
        if (apiRequest == null || cls == null) {
            return "";
        }
        try {
            return cls.newInstance().formatBody(apiRequest);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "";
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String formatUrl(ApiRequest apiRequest, Class<? extends IApiAdapter> cls) {
        if (apiRequest == null || cls == null) {
            return "";
        }
        try {
            return cls.newInstance().formatUrl(apiRequest);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "";
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
