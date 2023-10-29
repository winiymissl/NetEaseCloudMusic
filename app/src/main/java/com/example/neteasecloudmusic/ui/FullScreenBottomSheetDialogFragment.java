package com.example.neteasecloudmusic.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.neteasecloudmusic.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.w3c.dom.Text;

/**
 * @Author winiymissl
 * @Date 2023-10-28 21:07
 * @Version 1.0
 */
public class FullScreenBottomSheetDialogFragment extends BottomSheetDialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheetdialog, container, false);
        TextView textView = view.findViewById(R.id.tv_bottom);
        textView.setText(new String("wahah").repeat(100));
        return view;
    }

//    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
//        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
//            @Override
//            public void onShow(DialogInterface dialogInterface) {
//                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialogInterface;
//                BottomSheetBehavior bottomSheet = BottomSheetBehavior.from(bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet));
//                bottomSheet.setState(BottomSheetBehavior.STATE_EXPANDED);
//            }
//        });
//        return dialog;
//    }
}
