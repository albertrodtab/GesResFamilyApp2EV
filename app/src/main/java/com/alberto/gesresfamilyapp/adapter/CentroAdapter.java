package com.alberto.gesresfamilyapp.adapter;



import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.alberto.gesresfamilyapp.R;
import com.alberto.gesresfamilyapp.RegisterCentroActivity;
import com.alberto.gesresfamilyapp.db.AppDatabase;
import com.alberto.gesresfamilyapp.domain.Centro;
import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputLayout;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager;


import java.util.List;

public class CentroAdapter extends RecyclerView.Adapter<CentroAdapter.CentroHolder>{

    private List<Centro> centroList;
    //esto sirve para guardar la posición para luego poder hacer cosas con ellos.
    private Context context;

    private int selectedPosition;

    private PointAnnotationManager pointAnnotationManager;

    public CentroAdapter(Context context, List<Centro> dataList) {
        this.context = context;
        this.centroList = dataList;

        //esto indica que no hay ninguno seleccionado
        selectedPosition = -1;
    }

    //Patron Holder (ESTO ESTOY OBLIGADO A HACERLO SIEMPRE)
    //metodo que crea cada estructura de layout donde iran los datos de cada cnetro.
    @Override
    public CentroHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_view_centro, parent, false);
        return new CentroHolder(view);
    }

    //hace corresponder cada elemento de la lista para decir como pintarlo en cada elemento del layout
    @Override
    public void onBindViewHolder(CentroHolder holder, int position){
        holder.centroNombre.getEditText().setText(centroList.get(position).getNombre());
        holder.centroDireccion.getEditText().setText(centroList.get(position).getDireccion());
        holder.centroMail.getEditText().setText(centroList.get(position).getEmail());
        holder.centroRegistro.getEditText().setText(centroList.get(position).getNumRegistro());
        holder.centroTelefono.getEditText().setText(centroList.get(position).getTelefono());
        boolean tieneWifi = centroList.get(position).getTieneWifi();
        String wifiStatus = tieneWifi ? "Tiene Wifi" : "No tiene Wifi";
        holder.centroWifi.setText(wifiStatus);


        Centro centro = centroList.get(position);

        // Cargar y mostrar la foto en el ImageView
        String photoUriString = centro.getPhotoUri();
        if (photoUriString != null) {
            Uri photoUri = Uri.parse(photoUriString);
            Glide.with(context)
                    .load(photoUri)
                    .into(holder.centroImagen);
        } else {
            // Mostrar una imagen de placeholder si no hay foto disponible
            Glide.with(context)
                    .load(R.drawable.icons8_city_buildings_100)
                    .into(holder.centroImagen);
        }
    }

    @Override
    public int getItemCount() {
        return centroList.size();
    }

    public class CentroHolder extends RecyclerView.ViewHolder{
        public TextInputLayout centroNombre;
        public TextInputLayout centroDireccion;
        public TextInputLayout centroTelefono;
        public TextInputLayout centroMail;
        public TextInputLayout centroRegistro;
        public TextView centroWifi;
        public ImageView centroImagen;
        public MapView centroMap;
        //public CheckBox taskDone;
        //public Button doTaskButton;
        //public Button seeDetailsButton;
        public Button btDelete;
        public View parentView;
        public Button btMod;


        public CentroHolder(View view) {
            super(view);
            parentView = view;

            centroNombre = view.findViewById(R.id.tilNombre);
            centroDireccion = view.findViewById(R.id.tilDireccion);
            centroRegistro = view.findViewById(R.id.tilNumRegistro);
            centroTelefono = view.findViewById(R.id.tilTelefono);
            centroMail = view.findViewById(R.id.tilEmail);
            centroWifi = view.findViewById(R.id.tvWifi);
            centroImagen = view.findViewById(R.id.ivCentro);
            //centroMap = view.findViewById(R.id.mvCentro);


            btDelete = view.findViewById(R.id.btDelete);

            btMod = view.findViewById(R.id.btMod);

//            doTaskButton = view.findViewById(R.id.do_task_button);




            //Programar boton ver detalles de la tarea
            //doTaskButton.setOnClickListener(v -> doTask(getAdapterPosition()));

            //Programar boton marcar tarea como hecha.
            //seeDetailsButton.setOnClickListener(v -> seeDetails(getAdapterPosition()));

            //click on button (remove task from de list).
            btDelete.setOnClickListener(v -> deleteCentro(getAdapterPosition()));

            btMod.setOnClickListener(v-> modifyCentro(getAdapterPosition()));
        }



/*        private void doTask(int position){
            Car car = carList.get(position);
            car.setDone(true);

            final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, "tasks")
                    .allowMainThreadQueries().build();
            db.taskDao().update(car);

            notifyItemChanged(position);

        }*/

   /*     private void seeDetails(int position){
            Centro centro = centroList.get(position);

            Intent intent = new Intent(context, ViewCentroActivity.class);
            intent.putExtra("name", centro.getNombre());
            context.startActivity(intent);


        }*/

        private void deleteCentro(int position){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(R.string.estasSeguroDeBorrarElCentro)
                    .setTitle(R.string.borrarCentro)
                    .setPositiveButton(R.string.si, (dialog, id) -> {
                        final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, "Gesresfamily")
                                .allowMainThreadQueries().build();
                        Centro centro = centroList.get(position);
                        db.centroDao().delete(centro);

                        centroList.remove(position);
                        notifyItemRemoved(position);
                    })
                    .setNegativeButton(R.string.no, (dialog, id) -> dialog.dismiss());
            AlertDialog dialog = builder.create();
            dialog.show();
        }

        private void modifyCentro(int position) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(R.string.deseasModificarElCentro)
                    .setTitle(R.string.confirmarModificación)
                    .setPositiveButton(R.string.si, (dialog, id) -> {
                        Centro centro = centroList.get(position);

                        Intent intent = new Intent(context, RegisterCentroActivity.class);
                        intent.putExtra("modify_centro", true);
                        intent.putExtra("id", centro.getId());
                        intent.putExtra("nombre", centro.getNombre());
                        intent.putExtra("direccion", centro.getDireccion());
                        intent.putExtra("num_registro", centro.getNumRegistro());
                        intent.putExtra("telefono", centro.getTelefono());
                        intent.putExtra("email", centro.getEmail());
                        intent.putExtra("tieneWifi", centro.getTieneWifi());

                        context.startActivity(intent);
                    })
                    .setNegativeButton(R.string.no, (dialog, id) -> dialog.dismiss());

            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }
}
