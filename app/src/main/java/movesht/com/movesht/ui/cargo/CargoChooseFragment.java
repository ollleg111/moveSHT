package movesht.com.movesht.ui.cargo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import butterknife.BindView;
import movesht.com.movesht.CargoActivity;
import movesht.com.movesht.LoadAlertActivity;
import movesht.com.movesht.R;
import movesht.com.movesht.adapter.CargoAdapter;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;
import movesht.com.movesht.interfaces.InterfaceRV;
import movesht.com.movesht.model.cargo.CargoContainer;
import movesht.com.movesht.model.cargo.CargoType;
import movesht.com.movesht.ui.MockCargos;
import movesht.com.movesht.util.LogUtil;

public class CargoChooseFragment extends BaseFragment {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    protected CargoAdapter mCargoAdapter;
    List<CargoType> mTypes;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity() instanceof CargoActivity) {
            ((CargoActivity) getActivity()).colorChange();
        }
        if (getActivity() instanceof LoadAlertActivity) {
            ((LoadAlertActivity) getActivity()).colorChange();
        }

        initGridView();
        initRecyclerCargoFB();
//        initRecyclerCargo();

    }

    private void initGridView() {
        if (getResources().getConfiguration().screenLayout < DisplayMetrics.DENSITY_360) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        }
    }

    private void initRecyclerCargo() {
        mRecyclerView.getParent().requestDisallowInterceptTouchEvent(true);
        mCargoAdapter = new CargoAdapter(null);
        mRecyclerView.setAdapter(mCargoAdapter);
        InterfaceRV interfaceRV = new MockCargos();
        mTypes = interfaceRV.getListUser();
        mCargoAdapter.refreshList(mTypes);
    }

    private void initRecyclerCargoFB() {
        mRecyclerView.getParent().requestDisallowInterceptTouchEvent(true);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference menu = database.getReference("menu");

        menu.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                CargoContainer cargoContainer = dataSnapshot.getValue(CargoContainer.class);
                mTypes = cargoContainer.getCargoTypes();
                mCargoAdapter = new CargoAdapter(mTypes);
                mRecyclerView.setAdapter(mCargoAdapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                LogUtil.info(this, "Failed to read value." + error.toException());
            }
        });
    }

    public static CargoChooseFragment newInstance() {
        CargoChooseFragment fragment = new CargoChooseFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_cargo_choose_rv;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }

}
