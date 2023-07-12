package com.alibaba.security.realidentity.business.upload;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.d.j;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.business.start.UploadToken;
import com.alibaba.security.realidentity.upload.UploadFileModel;
import com.taobao.android.abilitykit.AKBaseAbility;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class b extends e {
    public static final String l = "wU^s&Mx75NCr$BPmZngO^WRNgDmnVGX@";
    private final String m;
    private final boolean n;
    private final String o;
    private final ALBiometricsResult p;

    public b(Context context, String str, String str2, String str3, ALBiometricsResult aLBiometricsResult) {
        super(context, str, null, null, null);
        this.o = str2;
        this.m = str3;
        this.n = true;
        this.p = aLBiometricsResult;
    }

    @Override // com.alibaba.security.realidentity.business.upload.a, android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(String str) {
        super.onPostExecute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.security.realidentity.business.upload.a, android.os.AsyncTask
    /* renamed from: a */
    public final String doInBackground(UploadToken... uploadTokenArr) {
        if (TextUtils.isEmpty(this.o)) {
            return null;
        }
        UploadFileModel uploadFileModel = new UploadFileModel();
        String format = new SimpleDateFormat("yyyyMMdd").format(Long.valueOf(System.currentTimeMillis()));
        String str = this.n ? "success" : AKBaseAbility.CALLBACK_FAILURE;
        uploadFileModel.setDestDir("biometric/video/" + format + "/" + this.k + "/" + str);
        uploadFileModel.setFileType("h264");
        uploadFileModel.setLocalFilePath(this.o);
        uploadFileModel.setRemoteFileName(new File(this.o).getName());
        g.a.a.a(TrackLog.dazzleFailedTrack("on success start delete video", null, System.currentTimeMillis()));
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Object a = this.i.a(uploadFileModel, new com.alibaba.security.realidentity.upload.b.b() { // from class: com.alibaba.security.realidentity.business.upload.b.1
            @Override // com.alibaba.security.realidentity.upload.b.b
            public final void a(long j, long j2) {
            }

            @Override // com.alibaba.security.realidentity.upload.b.b
            public final void a(String str2) {
                b bVar = b.this;
                bVar.j = str2;
                if ("10".equals(bVar.m)) {
                    b.this.p.setDazzleVideoOssUrl(str2);
                    String a2 = j.a(new File(b.this.o));
                    b.this.p.setVideoHash(j.b(b.this.k + a2 + b.l));
                }
                g.a.a.a(TrackLog.dazzleFailedTrack("on success start delete video", null, System.currentTimeMillis()));
                com.alibaba.security.common.d.e.b(b.this.o);
                countDownLatch.countDown();
            }

            @Override // com.alibaba.security.realidentity.upload.b.b
            public final void b(String str2) {
                g.a.a.a(TrackLog.dazzleFailedTrack("on Error start delete video", null, System.currentTimeMillis()));
                com.alibaba.security.common.d.e.b(b.this.o);
                countDownLatch.countDown();
            }

            @Override // com.alibaba.security.realidentity.upload.b.b
            public final void a() {
                g.a.a.a(TrackLog.dazzleFailedTrack("on cancel start delete video", null, System.currentTimeMillis()));
                com.alibaba.security.common.d.e.b(b.this.o);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(GetCacheDataManager.getInstance().getUploadTimeOut(), TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            this.i.a(a);
        }
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.security.realidentity.business.upload.a
    public final void a(String str) {
        super.onPostExecute(str);
    }
}
