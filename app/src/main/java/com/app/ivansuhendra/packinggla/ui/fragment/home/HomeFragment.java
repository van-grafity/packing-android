package com.app.ivansuhendra.packinggla.ui.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.app.ivansuhendra.packinggla.R;
import com.app.ivansuhendra.packinggla.databinding.FragmentHomeBinding;
import com.app.ivansuhendra.packinggla.net.API;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if (API.currentUser(getContext()) != null) {
            binding.tvName.setText(API.currentUser(getContext()).getName());
            binding.tvDept.setText(API.currentUser(getContext()).getRole());
        }

        binding.btnTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToTransferFragment();
            }
        });

        binding.btnReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToReceiveFragment();
            }
        });

        binding.btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToLoadFragment();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void navigateToTransferFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
        navController.navigate(R.id.action_nav_home_to_transferFragment);
    }

    private void navigateToReceiveFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
        // Use the appropriate action or destination ID to navigate to the ReceiveFragment
        navController.navigate(R.id.action_nav_home_to_receiveFragment);
    }

    private void navigateToLoadFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
        // Use the appropriate action or destination ID to navigate to the LoadFragment
        navController.navigate(R.id.action_nav_home_to_loadFragment);
    }
}