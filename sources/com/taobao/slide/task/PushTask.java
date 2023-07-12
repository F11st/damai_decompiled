package com.taobao.slide.task;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.taobao.slide.core.C6889b;
import com.taobao.slide.core.SlideException;
import com.taobao.slide.model.PodDO;
import com.taobao.slide.model.PushDO;
import com.taobao.slide.model.TraceDO;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tb.m42;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PushTask implements Runnable {
    public static final int PUSH_TYPE_POD = 1;
    public static final int PUSH_TYPE_TRACE = 2;
    private static final String TAG = "PushTask";
    public static Set<PodDO> waitingPods;
    public static Set<String> waitingTracePod;
    private C6889b engine;
    private String podInfo;

    public PushTask(String str, C6889b c6889b) {
        this.podInfo = str;
        this.engine = c6889b;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<String> list;
        try {
            m42.g(TAG, TAG, "pushinfo", this.podInfo);
            if (!TextUtils.isEmpty(this.podInfo)) {
                PushDO pushDO = (PushDO) JSON.parseObject(this.podInfo, PushDO.class);
                if (pushDO != null && pushDO.isValid()) {
                    int i = pushDO.type;
                    if (i != 2) {
                        if (i == 1) {
                            PodDO podDO = (PodDO) JSON.parseObject(pushDO.payload, PodDO.class);
                            podDO.pushType = pushDO.type;
                            C6889b c6889b = this.engine;
                            if (c6889b != null && c6889b.d() != null) {
                                this.engine.m(podDO);
                                return;
                            }
                            if (waitingPods == null) {
                                waitingPods = new HashSet();
                            }
                            m42.g(TAG, "PushTask add waiting push pod", "pod", podDO);
                            waitingPods.add(podDO);
                            return;
                        }
                        return;
                    }
                    TraceDO.PodNames podNames = (TraceDO.PodNames) JSON.parseObject(pushDO.payload, TraceDO.PodNames.class);
                    if (podNames != null && (list = podNames.pods) != null && list.size() != 0) {
                        if (waitingTracePod == null) {
                            waitingTracePod = new HashSet(podNames.pods);
                        }
                        C6889b c6889b2 = this.engine;
                        if (c6889b2 != null && c6889b2.d() != null) {
                            this.engine.n(podNames.pods);
                            return;
                        }
                        m42.g(TAG, "PushTask trace add waiting  pod", "pod", podNames.pods.toString());
                        waitingTracePod.addAll(podNames.pods);
                        return;
                    }
                    m42.e(TAG, "PushTask trace no pods", new Object[0]);
                    return;
                }
                throw new SlideException(1030, "pod null or invalid");
            }
            throw new SlideException(1030, "pod null");
        } catch (Throwable th) {
            m42.d(TAG, "push task handle error!", th, new Object[0]);
        }
    }
}
