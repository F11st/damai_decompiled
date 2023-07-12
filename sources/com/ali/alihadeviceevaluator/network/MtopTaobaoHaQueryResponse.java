package com.ali.alihadeviceevaluator.network;

import mtopsdk.mtop.domain.BaseOutDo;

/* loaded from: classes9.dex */
class MtopTaobaoHaQueryResponse extends BaseOutDo {
    private MtopTaobaoHaQueryResponseData data;

    MtopTaobaoHaQueryResponse() {
    }

    public void setData(MtopTaobaoHaQueryResponseData mtopTaobaoHaQueryResponseData) {
        this.data = mtopTaobaoHaQueryResponseData;
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public MtopTaobaoHaQueryResponseData getData() {
        return this.data;
    }
}
