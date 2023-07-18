package com.poly.SD18103_SOF3011_ASM.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietSP implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdSP", referencedColumnName = "id")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdNsx", referencedColumnName = "id")
    private NSX nsx;

    @ManyToOne
    @JoinColumn(name = "IdMauSac", referencedColumnName = "id")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP", referencedColumnName = "id")
    private DongSP dongSP;

    @Column(name = "NamBH")
    private int namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "GiaNhap", columnDefinition = "Decimal(20,0)")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan", columnDefinition = "Decimal(20,0)")
    private BigDecimal giaBan;

    @OneToMany(mappedBy = "chiTietSP", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHoaDonChiTiet;

    @OneToMany(mappedBy = "chiTietSP", fetch = FetchType.LAZY)
    private List<GioHangChiTiet> listGioHangChiTiet;
}
