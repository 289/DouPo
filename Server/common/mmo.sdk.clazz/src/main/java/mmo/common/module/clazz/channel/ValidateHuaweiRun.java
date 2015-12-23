package mmo.common.module.clazz.channel;

import java.net.SocketAddress;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import mmo.common.account.HttpCData;
import mmo.common.http.parameter.HttpParameter;
import mmo.common.module.clazz.thread.http.A20006ChannelLoginRun;
import mmo.common.module.sdk.http.HandRequestRun;
import mmo.common.module.sdk.server.ThreadManager;
import mmo.extension.application.ApplicationConfig;
import mmo.tools.config.ProjectCofigs;
import mmo.tools.log.LoggerError;
import mmo.tools.net.HttpsUtil;
import net.sf.json.JSONObject;

public class ValidateHuaweiRun extends HandRequestRun {

	@Override
	public void run() {
		try {
			int sw = 0;
			int sh = 0;
			try {
				sw = Integer.parseInt(request.getParameter(HttpCData.AccountDoupo.screen_width));
			} catch (Exception e) {

			}
			try {
				sh = Integer.parseInt(request.getParameter(HttpCData.AccountDoupo.screen_hight));
			} catch (Exception e) {

			}
			int platform = 2;
			try {
				platform = Integer.parseInt(request.getParameter(HttpCData.AccountDoupo.product_id));
			} catch (Exception e) {
				platform = 2;
			}
			String channel = request.getParameter("channel");
			String access_token = request.getParameter("access_token");

			String url = ProjectCofigs.getParameter("huawei_url");
			// 组织参数[从sdk拿下来的代码]
			String postBody = "nsp_svc=OpenUP.User.getInfo&nsp_ts=";
			postBody += String.valueOf(System.currentTimeMillis() / 1000);
			postBody += "&access_token=" + URLEncoder.encode(access_token, "utf-8").replace("+", "%2B");
			url = url + "?" + postBody;
			String result = HttpsUtil.request(url, "");
			if (result != null && !result.equals("")) {
				JSONObject resultJson = JSONObject.fromObject(result);
				if (resultJson.containsKey("userID") && !"".equals(resultJson.getString("userID"))) {
					String id = resultJson.getString("userID");

					Map<String, String> message = new HashMap<String, String>();
					message.put(HttpCData.A20001.channelId, channel);
					message.put(HttpCData.A20001.belongto, "0");
					message.put(HttpCData.A20001.channelSub, request.getParameter(HttpParameter.Account.channel_sub));
					message.put(HttpCData.A20001.clientVersion, "1");
					message.put(HttpCData.A20001.productId, platform+"");
					message.put(HttpCData.AccountDoupo.active_code, request.getParameter(HttpCData.AccountDoupo.active_code));
					message.put(HttpCData.A20001.imei, request.getParameter(HttpCData.AccountDoupo.serial_code));
					message.put(HttpCData.A20001.deviceOS, request.getParameter(HttpCData.AccountDoupo.device_os));
					message.put(HttpCData.A20001.osVersion, request.getParameter(HttpCData.AccountDoupo.os_version));
					message.put(HttpCData.A20001.deviceUdid, request.getParameter(HttpCData.AccountDoupo.udid));
					message.put(HttpCData.A20001.deviceMac, request.getParameter(HttpCData.AccountDoupo.mac));
					message.put(HttpCData.A20001.deviceUa, request.getParameter(HttpCData.AccountDoupo.ua));
					message.put(HttpCData.A20001.phone, request.getParameter(HttpCData.AccountDoupo.phone_code));
					message.put(HttpCData.A20001.screenWidth, sw + "");
					message.put(HttpCData.A20001.screenHeight, sh + "");
					message.put(HttpCData.A20001.phoneType, request.getParameter(HttpCData.AccountDoupo.phone_type));
					message.put(HttpCData.A20001.clientCode, request.getParameter(HttpParameter.Account.code_version));
					message.put(HttpCData.A20001.permit, channel);
					message.put(HttpCData.A20001.feature, "");
					message.put(HttpCData.A20001.registerFrom, "1");
					message.put(HttpCData.A20001.userid, id);
					if (resultJson.containsKey("userName")) {
						message.put(HttpCData.A20001.username, resultJson.getString("userName"));
					}else{
						message.put(HttpCData.A20001.username, id);
					}
					message.put(HttpCData.A20001.loginServer, ApplicationConfig.getInstance().getAppId() + "-"
					        + ApplicationConfig.getInstance().getAppName());
					message.put(HttpCData.A20001.serverVersion, ApplicationConfig.getInstance().getCodeVersion());
					String addIp = "";
					SocketAddress sa = session.getRemoteAddress();
					if (sa != null) {
						addIp = sa.toString();
					}
					message.put(HttpCData.A20001.remoteAddress, addIp);
					message.put(HttpCData.A20001.real_ip, request.getHeaderValue(HttpCData.A20001.real_ip));
					message.put(HttpCData.A20001.customData, "");

					ThreadManager.requestHttp("account", new A20006ChannelLoginRun(session, message));
					return;
				}
			}
		} catch (Exception e) {
			LoggerError.error("登录华为SDK异常", e);
		}
		JSONObject jsonObj = new JSONObject();
		jsonObj.put(HttpCData.A20001.result, 1);
		jsonObj.put(HttpCData.A20001.message, "登录失败");
		sendToClient(jsonObj.toString());
	}
}
