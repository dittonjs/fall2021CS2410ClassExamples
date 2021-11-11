package com.usu.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.usu.recyclerview.databinding.ContactListItemBinding;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private int numViewHolders = 0;
    ArrayList<Contact> contacts;

    public ContactsAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item, parent, false);
        numViewHolders ++;
        System.out.println("VIEW HOLDERS: " + numViewHolders);
        return new ViewHolder(ContactListItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        System.out.println("View holder bound");
        Contact contact = contacts.get(position);
        holder.binding.name.setText(contact.name);
        holder.binding.phoneNumber.setText(contact.phoneNumber);
        holder.binding.getRoot().setOnClickListener((view) -> {

        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ContactListItemBinding binding;
        public ViewHolder(@NonNull ContactListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
