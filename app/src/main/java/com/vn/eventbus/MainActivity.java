package com.vn.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private EventBus bus = EventBus.getDefault();
    private TextView view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        view = new TextView(this);
        view.setTextSize(20f);
        view.setPadding(20,20,20,20);
        view.setText("Waiting for events...");

        setContentView(view);

        //register as a subscriber
        bus.register(this);
    }

    @Override
    protected void onDestroy() {
        bus.unregister(this);
        super.onDestroy();
    }

    @Subscribe
    public void onEvent(ChargingEvent event){
        view.setText(view.getText()+ "\n" +event.getData());
    }

}
