package schoolofnet.com.clientesschoolofnet;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ClientHolder extends RecyclerView.ViewHolder{
    public TextView clientName;
    public String name, id;

    public ClientHolder(View item){
        super(item);
        clientName = item.findViewById(R.id.clientName);

        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"Nome: " + name + " ID: " + id, Toast.LENGTH_LONG).show();
                Intent editIntent = new Intent(view.getContext(),EditClientActivity.class);
                editIntent.putExtra("id",id);
                Activity activityAtual = (Activity) view.getContext();
                activityAtual.startActivity(editIntent);
            }
        });

    }
}
