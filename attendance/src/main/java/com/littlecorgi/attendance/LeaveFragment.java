package com.littlecorgi.attendance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.littlecorgi.attendance.tools.Leave;
import com.littlecorgi.attendance.tools.LeaveFragmentAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * 缺勤的Fragment
 */
public class LeaveFragment extends Fragment {

    private final List<Leave> mLeaveList = new ArrayList<>();
    private Button mReturnButton;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_leave, container, false);
        initData();
        RecyclerView recyclerView = view.findViewById(R.id.leave_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        LeaveFragmentAdapter adapter = new LeaveFragmentAdapter(mLeaveList);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        mReturnButton = view.findViewById(R.id.btn_return);
        mReturnButton.setOnClickListener(v -> {
            FragmentManager manager1 = requireActivity().getSupportFragmentManager();
            manager1.popBackStack();
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mReturnButton = requireActivity().findViewById(R.id.btn_return);
        mReturnButton.setOnClickListener(v -> {
            FragmentManager manager = requireActivity().getSupportFragmentManager();
            manager.popBackStack();
        });
    }

    private void initData() {
        Leave leave1 = new Leave("英语", "李明", "2020-12-20-10:00", "因发烧感冒而请假", "病假");
        mLeaveList.add(leave1);
        Leave leave2 = new Leave("数学", "李明", "2020-12-20-10:00", "因肚子疼而请假", "事假");
        mLeaveList.add(leave2);
    }
}
