package com.vn.eventbus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.format.Time;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by vn on 21/2/16.
 */
public class ChargingReceiver extends BroadcastReceiver {

    private EventBus bus = EventBus.getDefault();

    @Override
    public void onReceive(Context context, Intent intent) {

        ChargingEvent event = null;

        Time now = new Time();
        now.setToNow();
        String timeOfEvent = now.format("%H:%M:%S");

        String eventData = "@" + timeOfEvent + "this device started";
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            event = new ChargingEvent(eventData+" charging.");
        }else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            event = new ChargingEvent(eventData+ " discharging.");
        }

        bus.post(event);
    }
}
