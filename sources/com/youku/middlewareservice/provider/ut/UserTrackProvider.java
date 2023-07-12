package com.youku.middlewareservice.provider.ut;

import com.taobao.statistic.CT;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface UserTrackProvider {
    void commitEvent(String str, int i, Object obj, Object obj2, Object obj3, String... strArr);

    void ctrlClicked(String str, CT ct, String str2, String str3);

    String getUtdid();

    void pageAppear(Object obj);

    void pageDisappear(Object obj);

    void registTrackPage(String str, String str2, String str3);

    void updateNextPageProperties(String str, String str2);

    void updateNextPageProperties(Map<String, String> map);

    void updatePageInfo(Object obj);

    void updatePageName(Object obj, String str);

    void updatePageProperties(Object obj, Map<String, String> map);
}
