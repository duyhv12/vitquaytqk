package com.isd.vitquaytqk.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.isd.vitquaytqk.R;
import com.isd.vitquaytqk.Model.SanPham;
import com.isd.vitquaytqk.TotalMoneyImp;

import java.util.List;

/**
 * Created by Admin on 11/6/2017.
 */

public class DSSanPhamAdapter extends RecyclerView.Adapter<DSSanPhamAdapter.Holder> {
    Context context;
    List<SanPham> listSanPham;
    double thanhToan;
    TotalMoneyImp thanhToan2;
    TextView textVQ, textVQDG, textXX, textSN, textTQ;
    Button buttonVQ, buttonVQDG, buttonXX, buttonSN, buttonTQ;
    Double a = 0d;

    public DSSanPhamAdapter(Context context, List<SanPham> listSanPham) {
        this.context = context;
        this.listSanPham = listSanPham;
        this.thanhToan2 = (TotalMoneyImp) context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.item_gridview_order, parent, false);
        // Holder: nắm giữ
        Holder holder = new Holder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        // truyền ds sản phẩm vào đối tượng sản phẩm
        // get(position): lấy ra sản phẩm thứ i=position
        final SanPham sanPham = listSanPham.get(position);
        holder.btnSanPham.setText(sanPham.getProductName() + "");
        if (sanPham.isView() == false) {
            holder.txtQty.setVisibility(View.INVISIBLE);
            holder.spinner.setVisibility(View.INVISIBLE);
        }
        switch (position) {
            case 1:
                textVQ = holder.txtQty;
                buttonVQ = holder.btnSanPham;
                break;
            case 4:
                textVQDG = holder.txtQty;
                buttonVQDG = holder.btnSanPham;
                break;
            case 7:
                textXX = holder.txtQty;
                buttonXX = holder.btnSanPham;
                break;
            case 10:
                textSN = holder.txtQty;
                buttonSN = holder.btnSanPham;
                break;
            case 13:
                textTQ = holder.txtQty;
                buttonTQ = holder.btnSanPham;
                break;
        }
        //Set button click
        holder.btnSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double Qty = 0;
                //Lấy giá trị ở TextView của item đang set
                try {
                    String strQty = holder.txtQty.getText().toString();
                    Qty = Double.parseDouble(strQty);
                } catch (Exception ex) {
                }

                // cộng thêm 1/2 vào 1 và đổi màu
                //sanPham.getQty() == 0.5 && sanPham.getProductCode().equals("VQ")
                if (sanPham.isView() == false) {
                    switch (sanPham.getProductCode()) {
                        case "VQ":
                            try {
                                String strQty = textVQ.getText().toString();
                                Qty = Double.parseDouble(strQty);
                            } catch (Exception ex) {
                            }
                            Qty += sanPham.getQty();
                            textVQ.setText((Qty + "").replace(".0", ""));
                            buttonVQ.setBackgroundResource(R.drawable.button_sanpham);
                            break;
                        case "VQDG":
                            try {
                                String strQty = textVQDG.getText().toString();
                                Qty = Double.parseDouble(strQty);
                            } catch (Exception ex) {
                            }
                            Qty += sanPham.getQty();
                            textVQDG.setText((Qty + "").replace(".0", ""));
                            buttonVQDG.setBackgroundResource(R.drawable.button_sanpham);
                            break;
                        case "XX":
                            try {
                                String strQty = textXX.getText().toString();
                                Qty = Double.parseDouble(strQty);
                            } catch (Exception ex) {
                            }
                            Qty += sanPham.getQty();
                            textXX.setText((Qty + "").replace(".0", ""));
                            buttonXX.setBackgroundResource(R.drawable.button_sanpham);
                            break;
                        case "SN":
                            try {
                                String strQty = textSN.getText().toString();
                                Qty = Double.parseDouble(strQty);
                            } catch (Exception ex) {
                            }
                            Qty += sanPham.getQty();
                            textSN.setText((Qty + "").replace(".0", ""));
                            buttonSN.setBackgroundResource(R.drawable.button_sanpham);
                            break;
                        case "TQ":
                            try {
                                String strQty = textTQ.getText().toString();
                                Qty = Double.parseDouble(strQty);
                            } catch (Exception ex) {
                            }
                            Qty += sanPham.getQty();
                            textTQ.setText((Qty + "").replace(".0", ""));
                            buttonTQ.setBackgroundResource(R.drawable.button_sanpham);
                            break;
                    }

                } else {
                    //Cộng thêm số lượng tương ứng
                    Qty += sanPham.getQty();
                    holder.txtQty.setText((Qty + "").replace(".0", ""));
                }

                //Đổi màu
                holder.btnSanPham.setBackgroundResource(R.drawable.button_sanpham);
            }
        });
        // set TextView
        holder.txtQty.addTextChangedListener(new TextWatcher() {
            // giá trị trước khi thay đổi của TextView
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (i1 != 0) {
                    a = Double.parseDouble(charSequence.toString());
                } else {
                    a = 0d;
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            // giá trị sau khi thay đổi của TextView
            @Override
            public void afterTextChanged(Editable editable) {
                thanhToan = Double.parseDouble(editable.toString());
                thanhToan2.ThanhToan((thanhToan - a) * sanPham.getPrice());
            }
        });

        EditText editText;
//        holder.btnSanPham.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Dialog dialog = new Dialog(context);
//                dialog.show();
//                return false;
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return listSanPham.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        Button btnSanPham;
        TextView txtQty;
        Spinner spinner;

        public Holder(View itemView) {
            super(itemView);
            btnSanPham = (Button) itemView.findViewById(R.id.btn_SanPham);
            txtQty = (TextView) itemView.findViewById(R.id.txt_Qty);
            spinner = (Spinner) itemView.findViewById(R.id.spn);
        }
    }
}
