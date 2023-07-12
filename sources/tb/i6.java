package tb;

import com.alibaba.emas.publish.EmasPublishService;
import com.alibaba.emas.publish.channel.ut.PublishUtRequest;
import com.taobao.update.apk.ApkUpdateContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class i6 {
    private Boolean a;

    public void commitNotify(ApkUpdateContext apkUpdateContext, String str, Boolean bool, String str2) {
        try {
            if (hasEmasPublish()) {
                PublishUtRequest publishUtRequest = new PublishUtRequest();
                publishUtRequest.dimProductIdValue = String.valueOf(apkUpdateContext.mainUpdate.productId);
                publishUtRequest.dimApplicationIdValue = String.valueOf(apkUpdateContext.mainUpdate.applicationId);
                publishUtRequest.dimBatchIdValue = String.valueOf(apkUpdateContext.mainUpdate.batchId);
                publishUtRequest.dimBizValue = lu2.MAIN;
                publishUtRequest.dimNoticeTypeValue = "POPUP";
                publishUtRequest.dimActionValue = str;
                publishUtRequest.dimSuccessValue = String.valueOf(bool);
                publishUtRequest.dimErrorMsgValue = str2;
                EmasPublishService.getInstance().commitAppmonitor(publishUtRequest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hasEmasPublish() {
        if (this.a == null) {
            try {
                Class.forName(EmasPublishService.class.getName());
                this.a = Boolean.TRUE;
            } catch (Throwable unused) {
                this.a = Boolean.FALSE;
            }
        }
        return this.a.booleanValue();
    }
}
