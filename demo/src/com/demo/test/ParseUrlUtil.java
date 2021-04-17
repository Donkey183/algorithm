package com.demo.test;

import com.sun.deploy.util.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ParseUrlUtil implements java.io.Serializable {


  private static final long serialVersionUID = -2419331782437199701L;
  //	保存URL参数的容器
  public HashMap<String, String> strUrlParas;
  //private ArrayList<String> needDecode;


  public ParseUrlUtil() {
    super();
    this.strUrlParas = new HashMap<String, String>();
//		this.needDecode = new ArrayList<String>();

  }

  /**
   * @param url 需要解析的单条日志内容
   * @description 解析日志url
   */
  public void parser(String url) {
    strUrlParas.clear();
//		传递的URL参数
    String strUrl = "";
    String strUrlParams = "";

//		解析访问地址
    if (url.contains("?")) {
      String[] strUrlPatten = url.split("\\?");
      strUrl = strUrlPatten[0];
      strUrlParams = strUrlPatten[1];

    } else {
      strUrl = url;
      strUrlParams = url;
    }

    strUrlParas.put("URL", strUrl);
//		解析参数
    String[] params = null;

    if (strUrlParams.contains("&")) {
      params = strUrlParams.split("&");
    } else {
      params = new String[]{strUrlParams};
    }

//		保存参数到参数容器
    for (String p : params) {
      if (p.contains("=")) {
        String[] param = p.split("=");
        if (param.length == 1) {
          strUrlParas.put(param[0], "");
        } else {

          String key = param[0];
          String value = param[1];

          strUrlParas.put(key, value);
        }
      } else {
        strUrlParas.put("errorParam", p);
      }
    }

  }

  public static String appendParams(String url, Map<String, String> params) {

    StringBuffer sb = new StringBuffer("");
    Set<String> keys = params.keySet();
    for (String key : keys) {
      sb.append(key).append("=").append(params.get(key)).append("&");
    }
    sb.deleteCharAt(sb.length() - 1);

    url = url.trim();
    int length = url.length();
    int index = url.indexOf("?");
    if (index > -1) {//url说明有问号
      if ((length - 1) == index) {//url最后一个符号为？，如：http://wwww.baidu.com?
        url += sb.toString();
      } else {//情况为：http://wwww.baidu.com?aa=11
        url += "&" + sb.toString();
      }
    } else {//url后面没有问号，如：http://wwww.baidu.com
      url += "?" + sb.toString();
    }
    return url;
  }


  public static void main(String[] args) {
    Map map = new HashMap();

    Map map1 = new HashMap();
    map.put("mer", "111");
    map.putAll(map1);

//    System.out.println("====url===" + appendParams("https://ddpay.xiaojukeji.com:443/finpay/index.html#/agreementPay?name=aaa&age=25", map));
//    System.out.println("====url===" + appendParams("https://ddpay.xiaojukeji.com/finpay/index.html#/addBankCard?", map));
//    System.out.println("====url===" + appendParams("https://ddpay.xiaojukeji.com/finpay/index.html#/addBankCard", map));
//    System.out.println("====url===" + appendParams("https://ddpay.xiaojukeji.com/finpay/index.html?/#addBankCard", map));
//    System.out.println("====url===" + appendParams("", map));
//    System.out.println("====url===" + appendParams("", map));
  }

}