package com.taobao.orange.model;

import android.text.TextUtils;
import com.taobao.orange.GlobalOrange;
import com.taobao.orange.util.OLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class IndexDO implements CheckDO, Serializable {
    private static final String TAG = "IndexDO";
    private static final long serialVersionUID = -1896208418187285387L;
    public String appIndexVersion;
    public String appKey;
    public String appVersion;
    public String baseVersion;
    public String cdn;
    public String createTime;
    public String id;
    public String md5;
    public List<NameSpaceDO> mergedNamespaces = new ArrayList();
    public List<String> offlineNamespaces = new ArrayList();
    public String protocol;
    public String version;
    public String versionIndexVersion;

    public IndexDO() {
    }

    @Override // com.taobao.orange.model.CheckDO
    public boolean checkValid() {
        List<NameSpaceDO> list;
        if (!TextUtils.isEmpty(this.appKey) && !TextUtils.isEmpty(this.appVersion) && !TextUtils.isEmpty(this.appIndexVersion) && !TextUtils.isEmpty(this.versionIndexVersion) && !TextUtils.isEmpty(this.id) && !TextUtils.isEmpty(this.cdn) && !TextUtils.isEmpty(this.version) && (list = this.mergedNamespaces) != null && !list.isEmpty()) {
            boolean z = (this.appVersion.equals(jn1.MUL) || this.appVersion.equals(GlobalOrange.appVersion)) && this.appKey.equals(GlobalOrange.appKey);
            if (!z) {
                OLog.w(TAG, "invaild", new Object[0]);
            }
            return z;
        }
        OLog.w(TAG, "lack param", new Object[0]);
        return false;
    }

    public IndexDO(IndexDO indexDO) {
        this.appKey = indexDO.appKey;
        this.appVersion = indexDO.appVersion;
        this.appIndexVersion = indexDO.appIndexVersion;
        this.versionIndexVersion = indexDO.versionIndexVersion;
        this.createTime = indexDO.createTime;
        this.id = indexDO.id;
        this.cdn = indexDO.cdn;
        this.version = indexDO.version;
        this.mergedNamespaces.addAll(indexDO.mergedNamespaces);
        this.baseVersion = indexDO.baseVersion;
        this.offlineNamespaces.addAll(indexDO.offlineNamespaces);
    }
}
