package com.example.ilijaangeleski.findpeople;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ilija Angeleski on 11/16/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<User> userList;

    public RecyclerViewAdapter(List<User> people) {
        this.userList = people;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        User user = userList.get(position);
        holder.firstName.setText(user.getFirstName());
        holder.lastName.setText(user.getLastName());
        holder.city.setText(user.getCity());
    }
    public void updateList (List<User> foundUsers) {
        if (foundUsers != null && foundUsers.size() > 0) {
            userList.clear();
            userList.addAll(foundUsers);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView firstName;
        TextView lastName;
        TextView city;

        public ViewHolder(View itemView) {
            super(itemView);
            firstName = (TextView)itemView.findViewById(R.id.firstName);
            lastName = (TextView)itemView.findViewById(R.id.lastName);
            city = (TextView)itemView.findViewById(R.id.city);
        }
    }
}
