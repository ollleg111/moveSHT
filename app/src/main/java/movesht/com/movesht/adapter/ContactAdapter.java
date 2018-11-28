package movesht.com.movesht.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import movesht.com.movesht.R;
import movesht.com.movesht.model.User;

/**
 * Created by Admin on 05.04.2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private List<User> userList;

    private PersonClickListener mPersonClickListener;

    public ContactAdapter(List<User> userList, PersonClickListener personClickListener) {
        this.mPersonClickListener = personClickListener;
        this.userList = userList;
    }

    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ContactAdapter.ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ContactAdapter.ViewHolder holder, int position) {

            User user = userList.get(position);

        holder.mTvUser.setText(user.getFirstname() + " " + user.getLastname());
    }

    @Override
    public int getItemCount() {
        if (userList == null || userList.size() == 0) {
            return 0;
        }
        return userList.size();
    }

    public void refreshList(List<User> mContactUser) {
        userList = mContactUser;
        notifyDataSetChanged();
    }

    public interface PersonClickListener {

        void onClick(User user);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_user)
        TextView mTvUser;
        @BindView(R.id.img_chaine)
        ImageView mImageChaine;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User user = userList.get(getAdapterPosition());
                    mPersonClickListener.onClick(user);
                }
            });
        }
    }
}
