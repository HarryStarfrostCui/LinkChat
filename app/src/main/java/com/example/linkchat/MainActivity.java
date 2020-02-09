package com.example.linkchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.linkchat.fragments.MenuFragment;
import com.example.linkchat.fragments.OpeningFragment;

public class MainActivity extends AppCompatActivity {

    private ImageView mAddChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAddChat = findViewById(R.id.main_add_chat);
        getSupportFragmentManager().beginTransaction().replace(
                R.id.main_container, new OpeningFragment()).commit();
        mAddChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open intent to add-class activity
            }
        });
        getSupportFragmentManager().beginTransaction().replace(
                R.id.main_menu_container, new MenuFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }
}
