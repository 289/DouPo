package mmo.module.gm.net;

/***
 * �����ַ
 * 
 * @author fanren
 * 
 */
public class NetAddress {
	/** IP��ַ */
	private String ip;
	/** �˿ں� */
	private int    port;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "NetAddress [ip=" + ip + ", port=" + port + "]";
	}
}
