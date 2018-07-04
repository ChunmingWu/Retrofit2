package lotcom.zhpan.idea.net.common;


import java.lang.reflect.Proxy;

import lotcom.zhpan.idea.net.token.IGlobalManager;
import lotcom.zhpan.idea.net.token.ProxyHandler;
import lotcom.zhpan.idea.net.token.RefreshTokenResponse;
import lotcom.zhpan.idea.utils.Utils;

/**
 * Created by zhpan on 2017/4/1.
 */

public class IdeaApiProxy  {

    @SuppressWarnings("unchecked")
    public <T> T getApiService(Class<T> tClass,String baseUrl,IGlobalManager manager) {
        T t = RetrofitService.getRetrofitBuilder(baseUrl)
                .build().create(tClass);
        return (T) Proxy.newProxyInstance(tClass.getClassLoader(), new Class<?>[] { tClass }, new ProxyHandler(t, manager));
    }
}
