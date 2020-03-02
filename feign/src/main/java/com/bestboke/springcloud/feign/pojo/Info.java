package com.bestboke.springcloud.feign.pojo;

public class Info {

    private String ip;

    private String port;

    public Info() {
    }

    public Info(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Info{" +
                "ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
