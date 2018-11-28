package movesht.com.movesht.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import movesht.com.movesht.R;
import movesht.com.movesht.model.PersonType;

/**
 * Created by Admin on 04.04.2017.
 */

public class PersonPhotoAdapter extends RecyclerView.Adapter<PersonPhotoAdapter.ViewHolder> {

    List<PersonType> mPersonTypeList;

    public PersonPhotoAdapter(ArrayList<PersonType> mPersonType) {
        this.mPersonTypeList = mPersonType;
    }

    @Override
    public PersonPhotoAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_person_photo, viewGroup, false);
        return new PersonPhotoAdapter.ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(PersonPhotoAdapter.ViewHolder holder, int position) {

        PersonType personType = mPersonTypeList.get(position);
          holder.mPersonPhoto.setImageResource(personType.getImage().getResId());
    }

    @Override
    public int getItemCount() {
        if (mPersonTypeList == null || mPersonTypeList.size() == 0) {
            return 0;
        }
        return mPersonTypeList.size();
    }


    public void refreshList(List<PersonType> mPersonType) {
        mPersonTypeList = mPersonType;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.person_photo)
        ImageView mPersonPhoto;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

//        @OnClick(R.id.title_image)
//        public void onClick() {
////            if (mOnShowCardModel != null)
////                mOnShowCardModel.onShowCardModel(mModelList.get(getAdapterPosition()));
//        }
//
////        public void showImages() {
////            mTitleImage.setVisibility(View.VISIBLE);
////        }
    }
}
