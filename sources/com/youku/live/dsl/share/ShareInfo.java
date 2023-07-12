package com.youku.live.dsl.share;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ShareInfo implements IShareInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    private String mDescription;
    private Map<String, String> mExtra;
    private String mImage;
    private String mLinkUrl;
    private ShareMode mMode;
    private ShareTarget mTarget;
    private String mTitle;

    private Map<String, String> getExtra() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1226124844")) {
            return (Map) ipChange.ipc$dispatch("1226124844", new Object[]{this});
        }
        if (this.mExtra == null) {
            synchronized (this) {
                if (this.mExtra == null) {
                    this.mExtra = new HashMap();
                }
            }
        }
        return this.mExtra;
    }

    @Override // com.youku.live.dsl.share.IShareInfo
    public String getDescription() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1853831349")) {
            return (String) ipChange.ipc$dispatch("1853831349", new Object[]{this});
        }
        String str = this.mDescription;
        return str != null ? str : "";
    }

    @Override // com.youku.live.dsl.share.IShareInfo
    public String getImage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-917257452")) {
            return (String) ipChange.ipc$dispatch("-917257452", new Object[]{this});
        }
        String str = this.mImage;
        return str != null ? str : "";
    }

    @Override // com.youku.live.dsl.share.IShareInfo
    public String getLinkUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1525659726")) {
            return (String) ipChange.ipc$dispatch("1525659726", new Object[]{this});
        }
        String str = this.mLinkUrl;
        return str != null ? str : "";
    }

    @Override // com.youku.live.dsl.share.IShareInfo
    public String getTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1448354927")) {
            return (String) ipChange.ipc$dispatch("-1448354927", new Object[]{this});
        }
        String str = this.mTitle;
        return str != null ? str : "";
    }

    @Override // com.youku.live.dsl.share.IShareInfo
    public ShareMode mode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "31236070") ? (ShareMode) ipChange.ipc$dispatch("31236070", new Object[]{this}) : this.mMode;
    }

    public ShareInfo setDescription(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-382966200")) {
            return (ShareInfo) ipChange.ipc$dispatch("-382966200", new Object[]{this, str});
        }
        this.mDescription = str;
        return this;
    }

    public ShareInfo setImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1867715623")) {
            return (ShareInfo) ipChange.ipc$dispatch("1867715623", new Object[]{this, str});
        }
        this.mImage = str;
        return this;
    }

    public ShareInfo setLinkUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1366513823")) {
            return (ShareInfo) ipChange.ipc$dispatch("-1366513823", new Object[]{this, str});
        }
        this.mLinkUrl = str;
        return this;
    }

    public ShareInfo setMode(ShareMode shareMode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2035804969")) {
            return (ShareInfo) ipChange.ipc$dispatch("-2035804969", new Object[]{this, shareMode});
        }
        this.mMode = shareMode;
        return this;
    }

    public ShareInfo setTarget(ShareTarget shareTarget) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-129987341")) {
            return (ShareInfo) ipChange.ipc$dispatch("-129987341", new Object[]{this, shareTarget});
        }
        this.mTarget = shareTarget;
        return this;
    }

    public ShareInfo setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1483829796")) {
            return (ShareInfo) ipChange.ipc$dispatch("1483829796", new Object[]{this, str});
        }
        this.mTitle = str;
        return this;
    }

    @Override // com.youku.live.dsl.share.IShareInfo
    public ShareTarget target() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-208397530") ? (ShareTarget) ipChange.ipc$dispatch("-208397530", new Object[]{this}) : this.mTarget;
    }

    public String getExtra(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1617220481")) {
            return (String) ipChange.ipc$dispatch("-1617220481", new Object[]{this, str});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getExtra().get(str);
    }
}
