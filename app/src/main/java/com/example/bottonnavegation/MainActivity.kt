package com.example.bottonnavegation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    //butoes
    lateinit var btnHome: Button
    lateinit var btnCliente: Button
    lateinit var btnBusca: Button

    //Fragmentos
    lateinit var homeFragment: HomeFragment
    lateinit var clienteFragment: ClienteFragment
    lateinit var buscaFragment: BuscaFragment

    lateinit var bottonNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBusca = findViewById(R.id.btn_busca)
        btnCliente = findViewById(R.id.btn_cliente)
        btnHome = findViewById(R.id.btn_home)

        buscaFragment = BuscaFragment();
        clienteFragment = ClienteFragment();
        homeFragment = HomeFragment();

        bottonNavigation = findViewById(R.id.botton_navegation)

        setFragment(homeFragment)

        btnHome.setOnClickListener{
            setFragment(homeFragment)
        }

        btnCliente.setOnClickListener {
            setFragment(clienteFragment)
        }

        btnBusca.setOnClickListener {
            setFragment(buscaFragment)
        }

        bottonNavigation.setOnItemSelectedListener()
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.menu_home -> {
                setFragment(homeFragment)
            }
            R.id.menu_cliente -> {
                setFragment(clienteFragment)
            } else -> {
                setFragment(buscaFragment)
            }
        }

        return true

    }

}