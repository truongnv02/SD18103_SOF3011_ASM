package com.poly.SD18103_SOF3011_ASM.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "HoaDonChiTiet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonChiTiet implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "IdHoaDon", referencedColumnName = "id")
    private HoaDon hoaDon;

    @Id
    @ManyToOne
    @JoinColumn(name = "IdChiTietSP", referencedColumnName = "id")
    private ChiTietSP chiTietSP;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia", columnDefinition = "Decimal(20,0)")
    private BigDecimal donGia;
}
