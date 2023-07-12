package mtopsdk.mtop.domain;

import androidx.annotation.NonNull;
import anetwork.network.cache.RpcCache;
import java.io.Serializable;
import mtopsdk.common.util.StringUtils;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.mtop.cache.CacheManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ResponseSource implements Serializable {
    private String cacheBlock;
    private String cacheKey;
    public CacheManager cacheManager;
    public MtopResponse cacheResponse;
    public MtopContext mtopContext;
    public String seqNo;
    public RpcCache rpcCache = null;
    public boolean requireConnection = true;

    public ResponseSource(@NonNull MtopContext mtopContext, @NonNull CacheManager cacheManager) {
        this.mtopContext = mtopContext;
        this.cacheManager = cacheManager;
        this.seqNo = mtopContext.seqNo;
    }

    public String getCacheBlock() {
        if (StringUtils.isNotBlank(this.cacheBlock)) {
            return this.cacheBlock;
        }
        String blockName = this.cacheManager.getBlockName(this.mtopContext.mtopRequest.getKey());
        this.cacheBlock = blockName;
        return blockName;
    }

    public String getCacheKey() {
        if (StringUtils.isNotBlank(this.cacheKey)) {
            return this.cacheKey;
        }
        String cacheKey = this.cacheManager.getCacheKey(this.mtopContext);
        this.cacheKey = cacheKey;
        return cacheKey;
    }
}
