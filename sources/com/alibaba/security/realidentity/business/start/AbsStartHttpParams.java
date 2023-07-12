package com.alibaba.security.realidentity.business.start;

import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.http.model.HttpResponse;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class AbsStartHttpParams extends HttpBucketParams {
    public String mBizConf;
    public ExtrasBean mExtrasBean;
    public String mLivenessConfig;
    public boolean mShowNav;
    public boolean mShowPrivacy;
    public boolean mShowResult;
    public Map<String, String> mVerifyDowngradConfig;
    public UploadToken mUploadToken = new UploadToken();
    public boolean mOnlyGaze = false;
    public int mActionCount = 0;
    public boolean mNeedActionImage = true;
    public boolean mNeedGaze = false;
    public boolean mNeedOriginalImage = false;

    @Override // com.alibaba.security.realidentity.business.bucket.HttpBucketParams
    public HttpBucketParams doTransform(HttpResponse httpResponse) {
        return null;
    }
}
