package com.poly.SD18103_SOF3011_ASM.util;


import com.poly.SD18103_SOF3011_ASM.entities.ChiTietSP;
import com.poly.SD18103_SOF3011_ASM.entities.ChucVu;
import com.poly.SD18103_SOF3011_ASM.entities.CuaHang;
import com.poly.SD18103_SOF3011_ASM.entities.DongSP;
import com.poly.SD18103_SOF3011_ASM.entities.GioHang;
import com.poly.SD18103_SOF3011_ASM.entities.GioHangChiTiet;
import com.poly.SD18103_SOF3011_ASM.entities.HoaDon;
import com.poly.SD18103_SOF3011_ASM.entities.HoaDonChiTiet;
import com.poly.SD18103_SOF3011_ASM.entities.KhachHang;
import com.poly.SD18103_SOF3011_ASM.entities.MauSac;
import com.poly.SD18103_SOF3011_ASM.entities.NSX;
import com.poly.SD18103_SOF3011_ASM.entities.NhanVien;
import com.poly.SD18103_SOF3011_ASM.entities.SanPham;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName= FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        //Mapping
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(GioHang.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(NSX.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(DongSP.class);
        conf.addAnnotatedClass(ChiTietSP.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(GioHangChiTiet.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
    }
}

