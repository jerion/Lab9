package com.example.user.lab9;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        new Thread() {
            boolean flag = true;
            int count = 0;

            @Override
            public void run() {
                while (flag) {
                    Intent intent = new Intent("MyMessage");
                    intent.putExtra("background_service", count);
                    sendBroadcast(intent);
                    count++;

                    try {
                        Thread.sleep(1000);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
