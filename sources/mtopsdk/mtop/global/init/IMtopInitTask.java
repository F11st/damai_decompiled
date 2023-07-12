package mtopsdk.mtop.global.init;

import mtopsdk.mtop.global.MtopConfig;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IMtopInitTask {
    void executeCoreTask(MtopConfig mtopConfig);

    void executeExtraTask(MtopConfig mtopConfig);
}
