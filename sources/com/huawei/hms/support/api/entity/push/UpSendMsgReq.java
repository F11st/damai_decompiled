package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class UpSendMsgReq implements IMessageEntity {
    @Packed
    public String collapseKey;
    @Packed
    public String data;
    @Packed
    public String msgId;
    @Packed
    public String msgType;
    @Packed
    public String packageName;
    @Packed
    public int receiptMode;
    @Packed
    public int sendMode;
    @Packed
    public String to;
    @Packed
    public String token;
    @Packed
    public int ttl;

    public String getCollapseKey() {
        return this.collapseKey;
    }

    public String getData() {
        return this.data;
    }

    public String getMessageId() {
        return this.msgId;
    }

    public String getMessageType() {
        return this.msgType;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getReceiptMode() {
        return this.receiptMode;
    }

    public int getSendMode() {
        return this.sendMode;
    }

    public String getTo() {
        return this.to;
    }

    public String getToken() {
        return this.token;
    }

    public int getTtl() {
        return this.ttl;
    }

    public void setCollapseKey(String str) {
        this.collapseKey = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setMessageId(String str) {
        this.msgId = str;
    }

    public void setMessageType(String str) {
        this.msgType = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setReceiptMode(int i) {
        this.receiptMode = i;
    }

    public void setSendMode(int i) {
        this.sendMode = i;
    }

    public void setTo(String str) {
        this.to = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTtl(int i) {
        this.ttl = i;
    }
}
