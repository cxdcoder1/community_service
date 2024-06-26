package com.example.community.log.utils;

import javax.servlet.http.HttpServletRequest;

/**
	 * 获取用户真实的ip地址
	 * @param
	 * @return
	 */
public class IpAdrressUtil {
	
	public static String getIpAdrress(HttpServletRequest request) {
		 	String ip = null;

		    //X-Forwarded-For：Squid 服务代理
		    String ipAddresses = request.getHeader("X-Forwarded-For");
		    String unknown = "unknown";
		    if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
		        //Proxy-Client-IP：apache 服务代理
		        ipAddresses = request.getHeader("Proxy-Client-IP");
		    }

		    if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
		        //WL-Proxy-Client-IP：weblogic 服务代理
		        ipAddresses = request.getHeader("WL-Proxy-Client-IP");
		    }

		    if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
		        //HTTP_CLIENT_IP：有些代理服务器
		        ipAddresses = request.getHeader("HTTP_CLIENT_IP");
		    }

		    if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
		        //X-Real-IP：nginx服务代理
		        ipAddresses = request.getHeader("X-Real-IP");
		    }

		    //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
		    if (ipAddresses != null && ipAddresses.length() != 0) {
		        ip = ipAddresses.split(",")[0];
		    }

		    //还是不能获取到，最后再通过request.getRemoteAddr();获取
		    if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
		        ip = request.getRemoteAddr();
		    }
		    return ip;
	  }
	public static boolean isInternalIp(String ip) {
		if (ip.startsWith("10.") || ip.startsWith("192.168.") || ip.equals("127.0.0.1")) {
			return true;
		}

		if (ip.startsWith("172.")) {
			String[] segments = ip.split("\\.");
			int secondSegment = Integer.parseInt(segments[1]);
			if (secondSegment >= 16 && secondSegment <= 31) {
				return true;
			}
		}

		return false;
	}
	
	
}
