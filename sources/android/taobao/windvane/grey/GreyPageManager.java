package android.taobao.windvane.grey;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class GreyPageManager {
    private static volatile GreyPageManager instance;
    private static final Map<String, GreyPageInfo> mGreyPages = new ConcurrentHashMap();

    private GreyPageManager() {
    }

    public static GreyPageManager getInstance() {
        if (instance == null) {
            synchronized (GreyPageManager.class) {
                if (instance == null) {
                    instance = new GreyPageManager();
                }
            }
        }
        return instance;
    }

    public void add(GreyPageInfo greyPageInfo) {
        mGreyPages.put(greyPageInfo.getURL(), greyPageInfo);
    }

    public GreyPageInfo getGreyPageInfo(String str) {
        return mGreyPages.get(str);
    }

    public boolean isGreyPage(String str) {
        return mGreyPages.containsKey(str);
    }

    public void remove(GreyPageInfo greyPageInfo) {
        mGreyPages.remove(greyPageInfo.getURL());
    }

    public void remove(String str) {
        mGreyPages.remove(str);
    }
}
