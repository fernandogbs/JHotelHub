package com.fernandogbs.application;

import com.fernandogbs.conn.Connect;
import com.fernandogbs.entities.Hotel;

public class Main {
    public static void main(String[] args) {
        Connect connect = new Connect();
        connect.verifyConnection();
    }
}
