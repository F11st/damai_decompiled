package com.taobao.ma.qr.parser;

import com.taobao.ma.analyze.helper.MaAnalyzeHelper;
import com.taobao.ma.common.result.MaResult;
import com.taobao.ma.common.result.MaWapperResult;
import com.taobao.ma.parser.MaParSer;
import com.taobao.ma.qr.common.result.MaTBAntiFakeResult;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MaTBAntiFakeParSer extends MaParSer {
    @Override // com.taobao.ma.parser.MaParSer
    public MaResult decode(MaWapperResult maWapperResult) {
        if (MaAnalyzeHelper.isTBAntiFakeCode(maWapperResult.type, maWapperResult.maType)) {
            return new MaTBAntiFakeResult(maWapperResult.maType, maWapperResult.strCode, maWapperResult.hiddenData);
        }
        return null;
    }
}
