package com.agendadigital.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.agendadigital.R;
import com.agendadigital.clases.AdapterNotificaciones;
import com.agendadigital.clases.AdminSQLite;
import com.agendadigital.clases.Globals;

import java.util.ArrayList;

public class FragmentNotificationContainer extends Fragment {
    private View vista;
    private int codMateria;
    private RecyclerView rvNotificacionesContainer;
    private AdapterNotificaciones adapterNotificaciones;
    private AdminSQLite adm;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adm = new AdminSQLite(getContext(), "agenda", null, 1);
        if (getArguments() != null ) {
            codMateria = getArguments().getInt("codigoMateria");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_notification_container, container, false);

        cargarRecycler();
        return vista;
    }
    public void cargarRecycler(){
        rvNotificacionesContainer = vista.findViewById(R.id.rvNotificationContainer);
        ArrayList<String> notificaciones = new ArrayList<>();
        if (codMateria == 0 &&Globals.notificaciones != null){

            for (int i = 0 ; i < Globals.notificaciones.size(); i++){
                notificaciones.add(Globals.notificaciones.getNotificacion(i).getMensaje());
            }
            adapterNotificaciones = new AdapterNotificaciones(notificaciones);

            rvNotificacionesContainer.setLayoutManager(new LinearLayoutManager(getContext()));
            rvNotificacionesContainer.setAdapter(adapterNotificaciones);
        }else if(Globals.notificaciones!=null){
            for (int i = 0 ; i < Globals.notificaciones.size(); i++){
                if (Globals.notificaciones.getNotificacion(i).getEmisor()==codMateria){
                    notificaciones.add(Globals.notificaciones.getNotificacion(i).getMensaje());
                }
            }
            adapterNotificaciones = new AdapterNotificaciones(notificaciones);
            rvNotificacionesContainer.setLayoutManager(new LinearLayoutManager(getContext()));
            rvNotificacionesContainer.setAdapter(adapterNotificaciones);
        }else{
            adapterNotificaciones = new AdapterNotificaciones(notificaciones);
            adapterNotificaciones.clear();
            rvNotificacionesContainer.setLayoutManager(new LinearLayoutManager(getContext()));
            rvNotificacionesContainer.setAdapter(adapterNotificaciones);
        }
    }
}