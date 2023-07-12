package com.alipay.share.sdk.openapi;

import android.os.Bundle;
import com.alipay.share.sdk.Constant;
import com.alipay.share.sdk.openapi.APMediaMessage;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class APStockObject implements APMediaMessage.IMediaObject {
    public int status;
    public String stockCode;
    public String stockName;
    public String stockPrice;
    public String stockPriceChange;
    public String stockPriceChangeRatio;
    public long time = System.currentTimeMillis();
    public String webUrl;

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString(Constant.EXTRA_STOCK_OBJECT_NAME, this.stockName);
        bundle.putString(Constant.EXTRA_STOCK_OBJECT_CODE, this.stockCode);
        bundle.putString(Constant.EXTRA_STOCK_OBJECT_PRICE, this.stockPrice);
        bundle.putString(Constant.EXTRA_STOCK_OBJECT_PRICE_CHANGE, this.stockPriceChange);
        bundle.putString(Constant.EXTRA_STOCK_OBJECT_PRICE_CHANGE_RATIO, this.stockPriceChangeRatio);
        bundle.putLong(Constant.EXTRA_STOCK_OBJECT_TIME, this.time);
        bundle.putInt(Constant.EXTRA_STOCK_OBJECT_STATUS, this.status);
        bundle.putString(Constant.EXTRA_STOCK_OBJECT_URL, this.webUrl);
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public int type() {
        return 120;
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.stockName = bundle.getString(Constant.EXTRA_STOCK_OBJECT_NAME);
        this.stockCode = bundle.getString(Constant.EXTRA_STOCK_OBJECT_CODE);
        this.stockPrice = bundle.getString(Constant.EXTRA_STOCK_OBJECT_PRICE);
        this.stockPriceChange = bundle.getString(Constant.EXTRA_STOCK_OBJECT_PRICE_CHANGE);
        this.stockPriceChangeRatio = bundle.getString(Constant.EXTRA_STOCK_OBJECT_PRICE_CHANGE_RATIO);
        this.webUrl = bundle.getString(Constant.EXTRA_STOCK_OBJECT_URL);
        this.time = bundle.getLong(Constant.EXTRA_STOCK_OBJECT_TIME);
        this.status = bundle.getInt(Constant.EXTRA_STOCK_OBJECT_STATUS);
    }
}
