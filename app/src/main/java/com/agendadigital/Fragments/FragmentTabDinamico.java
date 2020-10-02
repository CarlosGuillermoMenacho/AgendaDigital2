package com.agendadigital.Fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.agendadigital.R;
import com.agendadigital.clases.AdaptadorViewPager;
import com.agendadigital.clases.AdminSQLite;
import com.agendadigital.clases.Constants;
import com.agendadigital.clases.Estudiante;
import com.agendadigital.clases.Globals;
import com.agendadigital.clases.MySingleton;
import com.agendadigital.clases.User;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FragmentTabDinamico extends Fragment {
    private ViewPager viewPager;
    private AdaptadorViewPager adaptadorViewPager;
    private AdminSQLite adm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adm = new AdminSQLite(getContext(),"agenda",null,1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_dinamico, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.viewPagerAvisos);
        TabLayout tabLayout = view.findViewById(R.id.tabLayoutAvisos);

        adaptadorViewPager = new AdaptadorViewPager(requireActivity().getSupportFragmentManager());

        tabLayout.setupWithViewPager(viewPager);

        Globals.notificacioness = adm.getNotificaciones(Globals.estudiante.getCodigo(),Globals.user.getCodigo());

  /*      cargarTabs();*/
        contadorNotificaciones(tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                adm.testEstados("1","1","1");
                tab.removeBadge();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

  /*  public void cargarTabs() {

        adaptadorViewPager = new AdaptadorViewPager(getChildFragmentManager());
        adaptadorViewPager.agregarFragmento(new FragmentNotificationContainer(0),"Notificaciones");
        Cursor cursor = adm.getMaterias(Globals.estudiante.getCodigo());
        if (cursor.moveToFirst()){
            *//*do {

           *//**//*     adaptadorViewPager.agregarFragmento(new FragmentNotificationContainer(cursor.getInt(2)))
                                                    ,cursor.getString(2));*//**//*
                )*//*
            }while (cursor.moveToNext());
        }
        viewPager.setAdapter(adaptadorViewPager);
    }*/

    private void contadorNotificaciones(TabLayout tabLayout) {

        int cursorContadorNotificaciones = adm.getCountNotificacion("1", "1", "1");
        tabLayout.getTabAt(1).getOrCreateBadge().setNumber(cursorContadorNotificaciones);
    }
}


















