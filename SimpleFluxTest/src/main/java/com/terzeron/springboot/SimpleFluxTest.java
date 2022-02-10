package com.terzeron.springboot;

public class SimpleFluxTest {
    public static void main(String[] args) {
        PoliteServer server = new PoliteServer(new KitchenService());
        server.doingMyJob().subscribe();
    }
}
