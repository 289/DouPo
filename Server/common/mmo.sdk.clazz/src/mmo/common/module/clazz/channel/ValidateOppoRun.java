package mmo.common.module.clazz.channel;

import java.net.SocketAddress;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import mmo.common.account.HttpCData;
import mmo.common.http.parameter.HttpParameter;
import mmo.common.module.clazz.thread.http.A20006ChannelLoginRun;
import mmo.common.module.sdk.http.HandRequestRun;
import mmo.common.module.sdk.server.ThreadManager;
import mmo.extension.application.ApplicationConfig;
import mmo.tools.log.LoggerError;
import net.sf.json.JSONObject;

import com.nearme.oauth.model.AccessToken;
import com.nearme.oauth.open.AccountAgent;

public class ValidateOppoRun extends HandRequestRun {

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
			String oauth_token = request.getParameter("oauth_token");
			oauth_token = URLDecoder.decode(oauth_token, "utf-8");
			String oauth_token_secret = request.getParameter("oauth_token_secret");
			oauth_token_secret = URLDecoder.decode(oauth_token_secret, "utf-8");
			
			String result = AccountAgent.getInstance().getGCUserInfo(new AccessToken(oauth_token, oauth_token_secret));

			if (result != null && !result.equals("")) {
				System.out.println("result==="+result);
				JSONObject briefUserJson = JSONObject.fromObject(result);
				if (briefUserJson.containsKey("BriefUser") && !"".equals(briefUserJson.getString("BriefUser"))) {
					JSONObject resultJson = JSONObject.fromObject(briefUserJson.getString("BriefUser"));
					String id = resultJson.getString("id");
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
					if(resultJson.containsKey("name")){
						message.put(HttpCData.A20001.username, resultJson.getString("name"));
					}else if(resultJson.containsKey("userName")){
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
			LoggerError.error("登录Oppo异常", e);
		}
		JSONObject jsonObj = new JSONObject();
		jsonObj.put(HttpCData.A20001.result, 1);
		jsonObj.put(HttpCData.A20001.message, "登录失败");
		sendToClient(jsonObj.toString());
	}
}
