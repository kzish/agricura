package net.centricdata.agricura;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AlertDialog;
import android.util.Log;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.analytics.FirebaseAnalytics;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import net.centricdata.agricura.Fragments.AddEventFragment;
import net.centricdata.agricura.Fragments.BranchesFragment;
import net.centricdata.agricura.Fragments.CalendarFragment;
import net.centricdata.agricura.Fragments.ContactUsFragment;
import net.centricdata.agricura.Fragments.FacebookFragment;
import net.centricdata.agricura.Fragments.HomeFragment;
import net.centricdata.agricura.Fragments.IncomeStatementFragment;
import net.centricdata.agricura.Fragments.MyAccountFragment;
import net.centricdata.agricura.Fragments.NewsFragment;
import net.centricdata.agricura.Fragments.ProductCategoriesFragment;
import net.centricdata.agricura.Fragments.ProductDiseaseFragment;
import net.centricdata.agricura.Fragments.ProductionGuidelinesFragment;
import net.centricdata.agricura.Fragments.SingleProductFragment;
import net.centricdata.agricura.Fragments.TwitterFragment;
import net.centricdata.agricura.Fragments.WeatherFragment;
import net.centricdata.agricura.Models.Branches;

import org.greenrobot.greendao.query.Query;

import daoModels.BranchesDao;
import daoModels.DaoSession;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SingleProductFragment.PassData, AddEventFragment.OnFragmentInteractionListener {

    BranchesDao branchesDao;
    Query<Branches> branchesQuery;
    private FirebaseAnalytics mFirebaseAnalytics;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
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
            /*case  R.id.nav_sales_team:
                fragment =new SalesTeamFragment();
                break;*/
            case  R.id.nav_productive:
                fragment =new ProductionGuidelinesFragment();
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
                fragment =new ProductCategoriesFragment();
                break;
           /* case R.id.nav_my_acc:
                fragment =new MyAccountFragment();
                break;*/
            case  R.id.nav_social_media:
                dataWarning();

                fragment =new TwitterFragment();
                break;
            case  R.id.nav_facebook:
                facebookDataWarning();

                fragment =new FacebookFragment();
                break;
            case  R.id.nav_whatsapp:
                whatsappUs();
                break;
            case R.id.nav_contact_us:
                fragment = new ContactUsFragment();
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

    private void facebookDataWarning() {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_twitter_warning, null);
        CheckBox mCheckBox = mView.findViewById(R.id.checkBoxTwit);
        mBuilder.setTitle("Data Warning!");
        mBuilder.setMessage("Opening Facebook may consume your data");
        mBuilder.setView(mView);
        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    storeDialogStatus(true);
                }else{
                    storeDialogStatus(false);
                }
            }
        });

        if(getDialogStatus()){
            mDialog.hide();
        }else{
            mDialog.show();
        }

    }

    private void dataWarning() {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_twitter_warning, null);
        CheckBox mCheckBox = mView.findViewById(R.id.checkBoxTwit);
        mBuilder.setTitle("Data Warning!");
        mBuilder.setMessage("Opening Twitter may consume your data");
        mBuilder.setView(mView);
        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    storeDialogStatus(true);
                }else{
                    storeDialogStatus(false);
                }
            }
        });

        if(getDialogStatus()){
            mDialog.hide();
        }else{
            mDialog.show();
        }

    }

    private void storeDialogStatus(boolean isChecked){
        SharedPreferences mSharedPreferences = getSharedPreferences("CheckItem", MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putBoolean("item", isChecked);
        mEditor.apply();
    }

    private boolean getDialogStatus(){
        SharedPreferences mSharedPreferences = getSharedPreferences("CheckItem", MODE_PRIVATE);
        return mSharedPreferences.getBoolean("item", false);
    }

    private void whatsappUs() {

        String contact = "+263 7713384616"; // use country code with your phone number
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

    @Override
    public void passData(String productName) {
        /*
        String tag = "android:switcher:" + R.id.viewPager + ":" + 1;
        FragmentTwo f = (FragmentTwo) getSupportFragmentManager().findFragmentByTag(tag);
        f.displayReceivedData(message);
    }
         */


        ProductDiseaseFragment fragment= (ProductDiseaseFragment) getSupportFragmentManager().findFragmentById(R.id.productDisease);
        fragment.passDiseaseInfo(productName);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /*
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    */
}
