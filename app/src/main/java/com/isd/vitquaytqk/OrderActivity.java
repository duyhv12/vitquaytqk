package com.isd.vitquaytqk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.isd.vitquaytqk.Adapter.DSSanPhamAdapter;
import com.isd.vitquaytqk.Model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity implements TotalMoneyImp {
    List<SanPham> listSanPham;
    RecyclerView recyclerView;
    DSSanPhamAdapter dsSanPhamAdapter;
    TextView txtTotal;
    TotalMoneyImp thanhToan1;
    double Tong = 0;
    Button buttonThanhToan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_Home);
        txtTotal = (TextView) findViewById(R.id.txt_Total);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        SanPham sanPham = new SanPham("BB", "BB", 10000, 1, true);
        SanPham sanPham1 = new SanPham("VQ", "VQ", 350000, 1, true);
        SanPham sanPham2 = new SanPham("VQ", "1/2 VQ", 350000, 0.5, false);

        SanPham sanPham3 = new SanPham("DV", "Đầu Vịt", 10000, 1, true);
        SanPham sanPham4 = new SanPham("VQDG", "VQ DG", 400000, 1, true);
        SanPham sanPham5 = new SanPham("VQDG", "1/2 VQ DG", 400000, 0.5, false);

        SanPham sanPham6 = new SanPham("NHK", "Ngỗng HK", 900000, 1, true);
        SanPham sanPham7 = new SanPham("XX", "100g XX", 25000, 1, true);
        SanPham sanPham8 = new SanPham("XX", "500g XX", 25000, 5, false);

        SanPham sanPham9 = new SanPham("NTD", "Ngỗng TD", 900000, 1, true);
        SanPham sanPham10 = new SanPham("SN", "100g SN", 26000, 1, true);
        SanPham sanPham11 = new SanPham("SN", "500g SN", 26000, 5, false);

        SanPham sanPham12 = new SanPham("GL", "Gà Luộc", 320000, 1, true);
        SanPham sanPham13 = new SanPham("TQ", "100g TQ", 25000, 1, true);
        SanPham sanPham14 = new SanPham("TQ", "500g TQ", 25000, 5, false);

        SanPham sanPham15 = new SanPham("GXD", "Gà XD", 340000, 1, true);

        listSanPham = new ArrayList<>();
        listSanPham.add(sanPham);
        listSanPham.add(sanPham1);
        listSanPham.add(sanPham2);
        listSanPham.add(sanPham3);
        listSanPham.add(sanPham4);
        listSanPham.add(sanPham5);
        listSanPham.add(sanPham6);
        listSanPham.add(sanPham7);
        listSanPham.add(sanPham8);
        listSanPham.add(sanPham9);
        listSanPham.add(sanPham10);
        listSanPham.add(sanPham11);
        listSanPham.add(sanPham12);
        listSanPham.add(sanPham13);
        listSanPham.add(sanPham14);
        listSanPham.add(sanPham15);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        // khởi tạo DSSanPhamAdapter
        dsSanPhamAdapter = new DSSanPhamAdapter(this, listSanPham);
        // truyền adapter vào recyclerView
        recyclerView.setAdapter(dsSanPhamAdapter);

    }

    @Override
    public void ThanhToan(double thanhToan) {
        Tong += thanhToan;
        txtTotal.setText((Tong + "").replace(".0", ""));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        setMenuBackground();
        return true;
    }

    private void setMenuBackground() {
//        getLayoutInflater().setFactory(new LayoutInflater.Factory() {
//            @Override
//            public View onCreateView(String s, Context context, AttributeSet attributeSet) {
//                if (s.equalsIgnoreCase("com.isd.vitquaytqk.OrderActivity")) {
//                    LayoutInflater layoutInflater = getLayoutInflater();
//                    try {
//                        final View view = layoutInflater.createView(s, null, attributeSet);
//                        new Handler().post(new Runnable() {
//                            @Override
//                            public void run() {
//                                view.setBackgroundResource(R.color.colorAccent);
//                                ((TextView) view).setTextColor(Color.WHITE);
//                            }
//                        });
//                        return view;
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (InflateException e) {
//
//                    }
//                }
//                return null;
//            }
//        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item1:
                recyclerView.setAdapter(dsSanPhamAdapter);
                Tong = 0;
                txtTotal.setText("0");
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
    }
}
