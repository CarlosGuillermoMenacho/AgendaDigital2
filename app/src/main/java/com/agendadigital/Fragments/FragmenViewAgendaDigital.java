package com.agendadigital.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agendadigital.R;
import com.agendadigital.clases.AdaptadorViewPager;
import com.google.android.material.tabs.TabLayout;

public class FragmenViewAgendaDigital extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    AdaptadorViewPager adaptadorViewPager;
    private View vista;

    public FragmenViewAgendaDigital() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_fragmen_view_agenda_digital, container, false);




        return vista;
    }
}