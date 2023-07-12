package me.ele.altriax.launcher.biz.strategy;

import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface Strategy {
    public static final String DAG_ALTRIAXB_LINK_DAMAI_NOMAL_APP = "dag_altriaxb_link_damai_app";

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface DagStrategy {
    }

    boolean identify(@NonNull String str);
}
