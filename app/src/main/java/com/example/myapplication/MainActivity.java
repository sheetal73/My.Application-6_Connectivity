package com.example.myapplication;


        import android.os.Bundle;
        import androidx.appcompat.app.AppCompatActivity;
        import android.content.BroadcastReceiver;
        import android.content.IntentFilter;
        import android.net.ConnectivityManager;

        import android.view.View;
        import android.widget.Button;

        import androidx.annotation.Nullable;


public class MainActivity extends AppCompatActivity{
   Button button;
    private BroadcastReceiver MyReceiver = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MyReceiver = new NetworkChangeReceiver();
                broadcastIntent();
            }


             public void broadcastIntent() {
                    registerReceiver(MyReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
                }});
    }



    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(MyReceiver);
    }
}


