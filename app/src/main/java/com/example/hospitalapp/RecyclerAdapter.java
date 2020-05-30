package com.example.hospitalapp;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView id, name , problem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textViewID);
            name = itemView.findViewById(R.id.textViewName);
            problem = itemView.findViewById(R.id.textViewProblem);
        }
    }

    public List<AppointmentObj> appointments;
    private Context context;

    public RecyclerAdapter(List<AppointmentObj> appointments, Context context) {
        this.appointments = appointments;
        this.context = context;
    }

    public void showDetails(int position){
        AppointmentObj appointment = appointments.get(position);
        String text = "Age: " + appointment.getAge() + "\nGender: " + appointment.getGender() + "\nAllergies: " + appointment.getAllergies() + "\nProblem: " + appointment.getProblem();
        new AlertDialog.Builder(context).setTitle(appointment.getName()).setMessage(text).setIcon(android.R.drawable.ic_dialog_alert).show();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.id.setText(appointments.get(position).getID());
        holder.name.setText(appointments.get(position).getName());
        holder.problem.setText(appointments.get(position).getProblem());

        holder.id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetails(position);
            }
        });
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetails(position);
            }
        });
        holder.problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetails(position);
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_appointment,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }
}
