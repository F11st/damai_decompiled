package com.taobao.android.launcher.biz.task;

import android.app.Application;
import android.text.TextUtils;
import com.taobao.android.launcher.common.LauncherRuntime;
import java.util.HashMap;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes12.dex */
public class TaskManager {
    public static boolean defferTask(String str, final TaggedRunnable taggedRunnable) throws IllegalArgumentException {
        if (!TextUtils.isEmpty(str) && taggedRunnable != null) {
            return LauncherRuntime.defferTask(new DeferrableTask(str) { // from class: com.taobao.android.launcher.biz.task.TaskManager.1
                @Override // com.taobao.android.launcher.biz.task.TaggedRunnable
                public void run(Application application, HashMap<String, Object> hashMap) {
                    taggedRunnable.run(application, hashMap);
                }
            });
        }
        throw new IllegalArgumentException("name should not be empty, task should not be null");
    }
}
