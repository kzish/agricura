package net.centricdata.agricura;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import net.centricdata.agricura.Fragments.BranchesFragment;
import net.centricdata.agricura.Fragments.CalendarFragment;
import net.centricdata.agricura.Fragments.HomeFragment;
import net.centricdata.agricura.Fragments.IncomeStatementFragment;
import net.centricdata.agricura.Fragments.NewsFragment;
import net.centricdata.agricura.Fragments.ProductiveGuidelinesFragment;
import net.centricdata.agricura.Fragments.ProductsFragment;
import net.centricdata.agricura.Fragments.SalesTeamFragment;
import net.centricdata.agricura.Fragments.SocialMediaFragment;
import net.centricdata.agricura.Fragments.TwitterFragment;
import net.centricdata.agricura.Fragments.WeatherFragment;
import net.centricdata.agricura.Models.Branches;

import org.greenrobot.greendao.query.Query;

import daoModels.BranchesDao;
import daoModels.DaoSession;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    BranchesDao branchesDao;
    Query<Branches> branchesQuery;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        displayMainDashboard(R.id.nav_home);

        DaoSession daoSession = App.getInstance().getDaoSession();
        branchesDao = daoSession.getBranchesDao();

        //addBranches();

        branchesQuery = branchesDao.queryBuilder().build();






    }

    /*private void addBranches() {

        Branches myBranches = new Branches();
        myBranches.setBranchName("Harare (Southerton)");
        myBranches.setBranchAddress("62 Birmingham Road, Southerton, Harare, Zimbabwe");
        branchesDao.insert(myBranches);
        Log.d("dataDB","Inserted new note, ID: " + myBranches.getBranchID() + myBranches.getBranchName() );

        myBranches = new Branches();
        myBranches.setBranchName("Norton");
        myBranches.setBranchAddress("Norton, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Glendale");
        myBranches.setBranchAddress("Shop No. 2 Glendale Main Square, Glendale, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Bindura");
        myBranches.setBranchAddress("No. 758 TM Area, Bindura, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Marondera");
        myBranches.setBranchAddress("No. 45 Chicago Drive, Marondera, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Shamva");
        myBranches.setBranchAddress("Shamva, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Mvurwi");
        myBranches.setBranchAddress("No. 23 Hands worth township, Mvurwi, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Chegutu");
        myBranches.setBranchAddress("No. 26 Abercon Street, Chegutu, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Chinhoyi");
        myBranches.setBranchAddress("No. 14 Park Street, Chinhoyi, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Kadoma");
        myBranches.setBranchAddress("No. 2580 J. Tongogara Road, Kadoma, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Mt Darwin");
        myBranches.setBranchAddress("No. 109 Hospital Road, Mt Darwin, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Guruve");
        myBranches.setBranchAddress("No. 82 Guruve Growth Point,Guruve, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Mhangura");
        myBranches.setBranchAddress("No. 26 Abercon Street, Mhangura, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Karoi");
        myBranches.setBranchAddress("No. 316 Industrial Site, Karoi, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Magunje");
        myBranches.setBranchAddress("Magunje, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Mutare");
        myBranches.setBranchAddress("No. 13 Chipanda Street, Murare, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Masvingo");
        myBranches.setBranchAddress("No. 46 Greenfields Road, Masvingo, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Chipinge");
        myBranches.setBranchAddress("No. 326 Gaza Eastern Road, Chipinge, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Bulawayo");
        myBranches.setBranchAddress("No. 60 George Silundika Avenue, Bulawayo, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Chiredzi");
        myBranches.setBranchAddress("No. 355 Chilonga Drive, Chiredzi, Zimbabwe");
        branchesDao.insert(myBranches);

    }*/

    private void displayMainDashboard(int id) {

        Fragment fragment = null;
        fragment = new HomeFragment();

        if (fragment != null){

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        // Handle navigation view item clicks here.

        for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++){
            getSupportFragmentManager().popBackStack();
        }
        int id = item.getItemId();



        displaySelectedScreen(id);




        return true;
    }

    private void displaySelectedScreen(int id) {

        Fragment fragment = null;

        switch (id){
            case R.id.nav_home:
                fragment = new HomeFragment();
                break;
            case  R.id.nav_weather:
                fragment =new WeatherFragment();
                break;
            case  R.id.nav_sales_team:
                fragment =new SalesTeamFragment();
                break;
            case  R.id.nav_productive:
                fragment =new ProductiveGuidelinesFragment();
                break;
            case  R.id.nav_calender:
                fragment =new CalendarFragment();
                break;
            case  R.id.nav_new:
                fragment =new NewsFragment();
                break;
            case  R.id.nav_income_statment:
                fragment =new IncomeStatementFragment();
                break;
            case  R.id.nav_branches:
                fragment =new BranchesFragment();
                break;
            case  R.id.nav_products:
                fragment =new ProductsFragment();
                break;
            case  R.id.nav_social_media:
                fragment =new TwitterFragment();
                break;
            case  R.id.nav_whatsapp:
                whatsappUs();
                break;

        }

        if (fragment != null){

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    private void whatsappUs() {

        String contact = "+263 773406575"; // use country code with your phone number
        String url = "https://api.whatsapp.com/send?phone=" + contact;
        try {
            PackageManager pm = getApplicationContext().getPackageManager();
            pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(MainActivity.this, "Whatsapp app not installed in your phone", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            Log.e("whatsapp", String.valueOf(e));
        }
    }
}
