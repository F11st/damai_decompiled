package com.alibaba.pictures.accs;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\tR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\tR$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0005\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\tR$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010\u001b\u001a\u0004\b7\u0010\u001d\"\u0004\b8\u0010\u001fR$\u00109\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\u001b\u001a\u0004\b:\u0010\u001d\"\u0004\b;\u0010\u001fR$\u0010<\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0005\u001a\u0004\b=\u0010\u0007\"\u0004\b>\u0010\tR$\u0010?\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0005\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\tR\"\u0010B\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006J"}, d2 = {"Lcom/alibaba/pictures/accs/AgooMessage;", "Ljava/io/Serializable;", "", "toString", RemoteMessageConst.MSGID, "Ljava/lang/String;", "getMsgId", "()Ljava/lang/String;", "setMsgId", "(Ljava/lang/String;)V", "msgTaskId", "getMsgTaskId", "setMsgTaskId", "msgBody", "getMsgBody", "setMsgBody", "channel", "getChannel", "setChannel", "imgUrl", "getImgUrl", "setImgUrl", "bigPicUrl", "getBigPicUrl", "setBigPicUrl", "", RemoteMessageConst.Notification.SOUND, "Ljava/lang/Integer;", "getSound", "()Ljava/lang/Integer;", "setSound", "(Ljava/lang/Integer;)V", "title", "getTitle", "setTitle", "text", "getText", "setText", "url", "getUrl", "setUrl", RemoteMessageConst.Notification.TICKER, "getTicker", "setTicker", "tag", "getTag", "setTag", "", "extObj", "Ljava/lang/Object;", "getExtObj", "()Ljava/lang/Object;", "setExtObj", "(Ljava/lang/Object;)V", RemoteMessageConst.Notification.NOTIFY_ID, "getNotifyId", "setNotifyId", "notifyImportance", "getNotifyImportance", "setNotifyImportance", "notifyChannelId", "getNotifyChannelId", "setNotifyChannelId", "notifyChannelName", "getNotifyChannelName", "setNotifyChannelName", "pendingIntentId", "I", "getPendingIntentId", "()I", "setPendingIntentId", "(I)V", "<init>", "()V", "accs_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class AgooMessage implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String bigPicUrl;
    @Nullable
    private String channel;
    @Nullable
    private Object extObj;
    @Nullable
    private String imgUrl;
    @Nullable
    private String msgBody;
    @Nullable
    private String msgId;
    @Nullable
    private String msgTaskId;
    @Nullable
    private String notifyChannelId;
    @Nullable
    private String notifyChannelName;
    @Nullable
    private Integer notifyId;
    @Nullable
    private Integer notifyImportance;
    private int pendingIntentId;
    @Nullable
    private Integer sound;
    @Nullable
    private String tag;
    @Nullable
    private String text;
    @Nullable
    private String ticker;
    @Nullable
    private String title;
    @Nullable
    private String url;

    @Nullable
    public final String getBigPicUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "761297141") ? (String) ipChange.ipc$dispatch("761297141", new Object[]{this}) : this.bigPicUrl;
    }

    @Nullable
    public final String getChannel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1146599315") ? (String) ipChange.ipc$dispatch("1146599315", new Object[]{this}) : this.channel;
    }

    @Nullable
    public final Object getExtObj() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1958269838") ? ipChange.ipc$dispatch("1958269838", new Object[]{this}) : this.extObj;
    }

    @Nullable
    public final String getImgUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "863017362") ? (String) ipChange.ipc$dispatch("863017362", new Object[]{this}) : this.imgUrl;
    }

    @Nullable
    public final String getMsgBody() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-970553517") ? (String) ipChange.ipc$dispatch("-970553517", new Object[]{this}) : this.msgBody;
    }

    @Nullable
    public final String getMsgId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-311695924") ? (String) ipChange.ipc$dispatch("-311695924", new Object[]{this}) : this.msgId;
    }

    @Nullable
    public final String getMsgTaskId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1912996529") ? (String) ipChange.ipc$dispatch("1912996529", new Object[]{this}) : this.msgTaskId;
    }

    @Nullable
    public final String getNotifyChannelId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-516516667") ? (String) ipChange.ipc$dispatch("-516516667", new Object[]{this}) : this.notifyChannelId;
    }

    @Nullable
    public final String getNotifyChannelName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1914572405") ? (String) ipChange.ipc$dispatch("1914572405", new Object[]{this}) : this.notifyChannelName;
    }

    @Nullable
    public final Integer getNotifyId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "402903709") ? (Integer) ipChange.ipc$dispatch("402903709", new Object[]{this}) : this.notifyId;
    }

    @Nullable
    public final Integer getNotifyImportance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-743585052") ? (Integer) ipChange.ipc$dispatch("-743585052", new Object[]{this}) : this.notifyImportance;
    }

    public final int getPendingIntentId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "863518517") ? ((Integer) ipChange.ipc$dispatch("863518517", new Object[]{this})).intValue() : this.pendingIntentId;
    }

    @Nullable
    public final Integer getSound() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-224032568") ? (Integer) ipChange.ipc$dispatch("-224032568", new Object[]{this}) : this.sound;
    }

    @Nullable
    public final String getTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1859996886") ? (String) ipChange.ipc$dispatch("-1859996886", new Object[]{this}) : this.tag;
    }

    @Nullable
    public final String getText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-840522669") ? (String) ipChange.ipc$dispatch("-840522669", new Object[]{this}) : this.text;
    }

    @Nullable
    public final String getTicker() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "504246000") ? (String) ipChange.ipc$dispatch("504246000", new Object[]{this}) : this.ticker;
    }

    @Nullable
    public final String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-401298008") ? (String) ipChange.ipc$dispatch("-401298008", new Object[]{this}) : this.title;
    }

    @Nullable
    public final String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "154303615") ? (String) ipChange.ipc$dispatch("154303615", new Object[]{this}) : this.url;
    }

    public final void setBigPicUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "160170017")) {
            ipChange.ipc$dispatch("160170017", new Object[]{this, str});
        } else {
            this.bigPicUrl = str;
        }
    }

    public final void setChannel(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-431413181")) {
            ipChange.ipc$dispatch("-431413181", new Object[]{this, str});
        } else {
            this.channel = str;
        }
    }

    public final void setExtObj(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-414070156")) {
            ipChange.ipc$dispatch("-414070156", new Object[]{this, obj});
        } else {
            this.extObj = obj;
        }
    }

    public final void setImgUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-411357556")) {
            ipChange.ipc$dispatch("-411357556", new Object[]{this, str});
        } else {
            this.imgUrl = str;
        }
    }

    public final void setMsgBody(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1638641533")) {
            ipChange.ipc$dispatch("-1638641533", new Object[]{this, str});
        } else {
            this.msgBody = str;
        }
    }

    public final void setMsgId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1418728490")) {
            ipChange.ipc$dispatch("1418728490", new Object[]{this, str});
        } else {
            this.msgId = str;
        }
    }

    public final void setMsgTaskId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1503112677")) {
            ipChange.ipc$dispatch("1503112677", new Object[]{this, str});
        } else {
            this.msgTaskId = str;
        }
    }

    public final void setNotifyChannelId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1449665873")) {
            ipChange.ipc$dispatch("1449665873", new Object[]{this, str});
        } else {
            this.notifyChannelId = str;
        }
    }

    public final void setNotifyChannelName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "233197217")) {
            ipChange.ipc$dispatch("233197217", new Object[]{this, str});
        } else {
            this.notifyChannelName = str;
        }
    }

    public final void setNotifyId(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2063817267")) {
            ipChange.ipc$dispatch("-2063817267", new Object[]{this, num});
        } else {
            this.notifyId = num;
        }
    }

    public final void setNotifyImportance(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-269030810")) {
            ipChange.ipc$dispatch("-269030810", new Object[]{this, num});
        } else {
            this.notifyImportance = num;
        }
    }

    public final void setPendingIntentId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1982538891")) {
            ipChange.ipc$dispatch("-1982538891", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.pendingIntentId = i;
        }
    }

    public final void setSound(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "546107498")) {
            ipChange.ipc$dispatch("546107498", new Object[]{this, num});
        } else {
            this.sound = num;
        }
    }

    public final void setTag(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-406780532")) {
            ipChange.ipc$dispatch("-406780532", new Object[]{this, str});
        } else {
            this.tag = str;
        }
    }

    public final void setText(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-579155733")) {
            ipChange.ipc$dispatch("-579155733", new Object[]{this, str});
        } else {
            this.text = str;
        }
    }

    public final void setTicker(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1351632110")) {
            ipChange.ipc$dispatch("1351632110", new Object[]{this, str});
        } else {
            this.ticker = str;
        }
    }

    public final void setTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1358936114")) {
            ipChange.ipc$dispatch("-1358936114", new Object[]{this, str});
        } else {
            this.title = str;
        }
    }

    public final void setUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906992855")) {
            ipChange.ipc$dispatch("1906992855", new Object[]{this, str});
        } else {
            this.url = str;
        }
    }

    @NotNull
    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2064412274")) {
            return (String) ipChange.ipc$dispatch("2064412274", new Object[]{this});
        }
        return "msgId:" + this.msgId + ",msgBody:" + this.msgBody + ",msgTaskId:" + this.msgTaskId;
    }
}
