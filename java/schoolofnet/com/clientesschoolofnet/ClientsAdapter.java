package schoolofnet.com.clientesschoolofnet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ClientsAdapter extends RecyclerView.Adapter<ClientHolder>{

    public List<Client> clientsList;


    public ClientsAdapter(List<Client> c){
        this.clientsList = c;
    }

    @Override
    public ClientHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.client_item,parent,false);
        return new ClientHolder(item);
    }

    @Override
    public void onBindViewHolder(ClientHolder holder, int position) {
        String name = clientsList.get(position).getName();
        holder.clientName.setText(name);
        holder.name = name;
        holder.id = clientsList.get(position).getId();
    }

    @Override
    public int getItemCount() {
        return clientsList.size();
    }
}
