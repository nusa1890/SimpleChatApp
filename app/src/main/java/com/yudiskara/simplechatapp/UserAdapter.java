package com.yudiskara.simplechatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    //(Context context, ArrayList<User> userList)
    ArrayList<User> userList;
    LayoutInflater inflater;

    public UserAdapter(Context context, ArrayList<User> userList){
        this.userList = userList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.user_layout, parent, false);
        return new UserViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User currentUser = userList.get(position);
        holder.txtData.setText(currentUser.name);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends  RecyclerView.ViewHolder{
        TextView txtData;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            txtData = itemView.findViewById(R.id.usr_name);
        }
    }

}
