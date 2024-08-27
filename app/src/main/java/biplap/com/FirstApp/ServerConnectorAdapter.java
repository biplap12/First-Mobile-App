//package biplap.com.FirstApp;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class ServerConnectorAdapter extends RecyclerView.Adapter<ServerConnectorAdapter.ViewHolder>{
//    ArrayList<ServerResponseDTO>serverResponseDTOS;
//
//    public ServerConnectorAdapter(ArrayList<ServerResponseDTO> serverResponseDTOS) {
//        this.serverResponseDTOS = serverResponseDTOS;
//    }
//
//    @NonNull
//    @Override
//    public ServerConnectorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
//        View view = layoutInflater.inflate(R.layout.layout_server_item,parent,false);
//        ViewHolder viewHolder = new ViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ServerConnectorAdapter.ViewHolder holder, int position) {
//        holder.name.setText(serverResponseDTOS.get(position).getName());
//        holder.address.setText(serverResponseDTOS.get(position).getAddress());
//        holder.phone.setText(serverResponseDTOS.get(position).getPhone());
//        holder.email.setText(serverResponseDTOS.get(position).getEmail());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return serverResponseDTOS.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        TextView name,address,phone,email;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            this.name=itemView.findViewById(R.id.tvName);
//            this.address=itemView.findViewById(R.id.tvAddress);
//            this.phone=itemView.findViewById(R.id.tvPhone);
//            this.email=itemView.findViewById(R.id.tvEmail);
//        }
//    }
//}