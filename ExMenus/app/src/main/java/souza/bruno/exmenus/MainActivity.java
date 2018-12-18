package souza.bruno.exmenus;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {

    //Drawer
    private Drawer result = null;

    //Toolbar
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getText(R.string.toolbar_title));
        toolbar.inflateMenu(R.menu.toolbar_menu);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.toolbar_sobre:
                        Toast.makeText(getBaseContext(), getResources().getText(R.string.toast_menu_sobre), Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Inicio MaterialDrawer

        //Inicio AccountHeader
        //####################### SÓ O CABEÇALHO #######################
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                //download nav
                //https://www.google.com/search?q=nav+header+drawer&rlz=1C1RLNS_pt-BRBR804BR804&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjKwMmUoKnfAhUHDZAKHaJZCksQ_AUIDigB&biw=1366&bih=608#imgrc=zrNwDVP9fD2QfM:
                .withHeaderBackground(R.drawable.drawer_header)
                .addProfiles(
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener(){
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        //Inicio Menu
        result = new DrawerBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(false)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .withSavedInstance(savedInstanceState)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Home").withIdentifier(0).withIcon(GoogleMaterial.Icon.gmd_home),
                        new DividerDrawerItem(),
                        new SectionDrawerItem().withName("Ações"),                        new SecondaryDrawerItem().withName("Tela1").withIdentifier(1).withIcon(FontAwesome.Icon.faw_facebook),
                        new SecondaryDrawerItem().withName("Tela2").withIdentifier(2).withIcon(FontAwesome.Icon.faw_twitter),
                        new SecondaryDrawerItem()
                                .withName("Coisas")
                                .withIcon(GoogleMaterial.Icon.gmd_list)
                                .withSubItems(
                                        new SecondaryDrawerItem().withName("Coisa1").withIdentifier(3),
                                        new SecondaryDrawerItem().withName("Coisa2").withIdentifier(4)
                                )
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        switch ((int)drawerItem.getIdentifier()){
                            case 0:
                                Toast.makeText(getBaseContext(),"Você clicou no menu Home",Toast.LENGTH_LONG).show();
                                break;

                            case 1:
                                Toast.makeText(getBaseContext(),"Você clicou no menu Tela1",Toast.LENGTH_LONG).show();
                                //startActivity(new Intent(MainActivity.this,Tela1.class));
                                break;

                            case 2:
                                Toast.makeText(getBaseContext(),"Você clicou no menu Tela2",Toast.LENGTH_LONG).show();
                                break;
                        }
                        return false;
                    }
                }).build();


    }//fecha oncreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}