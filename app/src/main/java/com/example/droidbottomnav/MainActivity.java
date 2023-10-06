package com.example.droidbottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity  {
    NavigationBarView navigationBarView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());
//        6 10 2023 : Improve menggunakan navbarview suggest dari android studio
        navigationBarView = findViewById(R.id.bottomNavigationView);
        navigationBarView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                loadFragment(new HomeFragment());
                item.setChecked(true);
            } else if (item.getItemId() == R.id.profile) {
                loadFragment(new ProfileFragment());
                item.setChecked(true);
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
            }else if (item.getItemId() == R.id.settings) {
                loadFragment(new SettingsFragment());
                item.setChecked(true);
            }
            return false;
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.frame_layout,fragment);
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.addToBackStack(null); // Add to back stack for navigation
        fragmentTransaction.commit();
        // Set the selected menu item based on the loaded fragment
//        if (fragment instanceof HomeFragment) {
//            navigationBarView.setSelectedItemId(R.id.home);
//        } else if (fragment instanceof ProfileFragment) {
//            navigationBarView.setSelectedItemId(R.id.profile);
//        } else if (fragment instanceof SettingsFragment) {
//            navigationBarView.setSelectedItemId(R.id.settings);
//        }
    }
//    private void loadFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        // Set custom animations for fragment transitions
//        fragmentTransaction.setCustomAnimations(
//                R.anim.fragment_enter, // enter animation
//                R.anim.fragment_exit,  // exit animation
//                R.anim.fragment_exit, // pop enter animation (used when popping the back stack)
//                R.anim.fragment_enter   // pop exit animation (used when popping the back stack)
//        );
//
//        // Replace the current fragment with the new one
//        fragmentTransaction.replace(R.id.frame_layout, fragment);
//
//        // Add the transaction to the back stack (optional)
//        fragmentTransaction.addToBackStack(null);
//
//        fragmentTransaction.commit();
//    }
}
