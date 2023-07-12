package com.youku.alixplugin.layer;

import com.tencent.open.SocialConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class LMListSort<E> {
    public void Sort(List<E> list, final String str, final String str2) {
        Collections.sort(list, new Comparator<E>() { // from class: com.youku.alixplugin.layer.LMListSort.1
            @Override // java.util.Comparator
            public int compare(E e, E e2) {
                int compareTo;
                try {
                    Method method = e.getClass().getMethod(str, null);
                    Method method2 = e2.getClass().getMethod(str, null);
                    String str3 = str2;
                    if (str3 != null && SocialConstants.PARAM_APP_DESC.equals(str3)) {
                        compareTo = method2.invoke(e2, null).toString().compareTo(method.invoke(e, null).toString());
                    } else {
                        compareTo = method.invoke(e, null).toString().compareTo(method2.invoke(e2, null).toString());
                    }
                    return compareTo;
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                    return 0;
                } catch (IllegalArgumentException e4) {
                    e4.printStackTrace();
                    return 0;
                } catch (NoSuchMethodException e5) {
                    LMUtilLog.debugLog(LMListSort.class, "NoSuchMethodException " + e5);
                    return 0;
                } catch (InvocationTargetException e6) {
                    e6.printStackTrace();
                    return 0;
                }
            }
        });
    }
}
