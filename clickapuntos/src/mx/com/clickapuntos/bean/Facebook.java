package mx.com.clickapuntos.bean;

import com.visural.common.StringUtil;

public class Facebook {
    private static final String[] perms = new String[] {"email","publish_stream", "offline_access","read_stream"};

    public static String getLoginRedirectURL(String apiKey,String apiSecret,String callbackURL) {
        return "https://graph.facebook.com/oauth/authorize?client_id=" + apiKey + "&display=page&redirect_uri=" + callbackURL +"&scope="+StringUtil.delimitObjectsToString(",", perms);
    }

    public static String getAuthURL(String authCode,String apiKey,String apiSecret,String callbackURL) {
        return "https://graph.facebook.com/oauth/access_token?client_id=" +
            apiKey+"&redirect_uri=" +
            callbackURL+"&client_secret="+apiSecret+"&code="+authCode;
    }
}
