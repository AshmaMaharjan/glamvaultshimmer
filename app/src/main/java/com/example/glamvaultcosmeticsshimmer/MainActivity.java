//package com.example.glamvaultcosmeticsshimmer;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.MenuItem;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.android.material.navigation.NavigationBarView;
//
//public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
//
//    //Declaring necessary fragments for navigation
//    BottomNavigationView bottomNavigationView;
//    HomeFragment homeFragment = new HomeFragment();
//    ProfileFragment profileFragment = new ProfileFragment();
//    SkillFragment skillFragment = new SkillFragment();
//    HobbiesFragment hobbiesFragment = new HobbiesFragment();
//    ContactFragment contactFragment =new ContactFragment();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Initialize BottomNavigationView and set up the listener
//        bottomNavigationView = findViewById(R.id.bottomNavigationView);
//        bottomNavigationView.setOnItemSelectedListener(this);
//
//        // Set the default selected item in the BottomNavigationView to "home"
//        bottomNavigationView.setSelectedItemId(R.id.home);
//
//    }
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        // Handle item selection in the BottomNavigationView
//        if (item.getItemId() == R.id.home){
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
//            return true;
//        }else if(item.getItemId() == R.id.profile){
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
//            return true;
//        }else if(item.getItemId() == R.id.skill){
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, skillFragment).commit();
//            return true;
//        }else if(item.getItemId() == R.id.hobbies){
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, hobbiesFragment).commit();
//            return true;
//        }else if(item.getItemId() == R.id.contacts){
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, contactFragment).commit();
//            return true;
//        }else {
//            return false;
//        }
//    }
//}