package tb;

import com.alibaba.emas.publish.EmasPublishCallback;
import com.alibaba.emas.publish.channel.mtop.PublishMtopUpdateInfo;
import com.alibaba.emas.publish.channel.slide.PublishSlideUpdateInfo;
import com.alibaba.fastjson.JSON;
import com.taobao.update.datasource.IUpdater;
import com.taobao.update.datasource.data.UpdateDataListener;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class be0 implements IUpdater {
    private List<UpdateDataListener> a = new ArrayList();

    /* compiled from: Taobao */
    /* renamed from: tb.be0$a */
    /* loaded from: classes11.dex */
    class C8958a implements EmasPublishCallback {
        C8958a() {
        }

        @Override // com.alibaba.emas.publish.EmasPublishCallback
        public void fullAmountNotify(PublishSlideUpdateInfo publishSlideUpdateInfo) {
        }

        @Override // com.alibaba.emas.publish.EmasPublishCallback
        public void updateCallback(PublishMtopUpdateInfo publishMtopUpdateInfo) {
            if (publishMtopUpdateInfo == null || publishMtopUpdateInfo.payload == null) {
                return;
            }
            be0 be0Var = be0.this;
            be0Var.dispatchUpdate(be0Var.from(), true, JSON.toJSONString(publishMtopUpdateInfo), new String[0]);
        }
    }

    public abstract String apiName();

    public abstract String biz();

    public EmasPublishCallback callback() {
        return new C8958a();
    }

    @Override // com.taobao.update.datasource.IUpdater
    public void dispatchUpdate(String str, boolean z, String str2, String... strArr) {
        for (UpdateDataListener updateDataListener : new ArrayList(this.a)) {
            updateDataListener.onUpdate(str, null, z, str2, strArr);
        }
    }

    @Override // com.taobao.update.datasource.IUpdater
    public String from() {
        return lu2.EMAS_PUBLISH;
    }

    @Override // com.taobao.update.datasource.IUpdater
    public void registerDataListener(UpdateDataListener updateDataListener) {
        synchronized (this.a) {
            this.a.add(updateDataListener);
        }
    }

    public abstract String requestVersion();

    @Override // com.taobao.update.datasource.IUpdater
    public void unRegisterDataListener(UpdateDataListener updateDataListener) {
        synchronized (this.a) {
            this.a.remove(updateDataListener);
        }
    }
}
