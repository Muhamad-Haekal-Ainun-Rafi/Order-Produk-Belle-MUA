package com.melenia.makeup.Beli;
import java.io.Serializable;

public class BayarReq implements Serializable {
    private String nama_pembeli;
    private String nama_barang;
    private String harga_barang;
    private String alamat;
    private String no_telpon;
    private String metode_pembayaran;
    private String kurir_pengiriman;
    private String key;
    private String userId;
    private String date;

    public String getDate() {
        return date;
    }
    public void setDate(String date) { this.date = date; }

    public String getNama_pembeli() {
        return nama_pembeli;
    }
    public void setNama_pembeli(String nama_pembeli) { this.nama_pembeli = nama_pembeli; }

    public String getNama_barang() {
        return nama_barang;
    }
    public void setNama_barang(String nama_barang) { this.nama_barang = nama_barang; }

    public String getHarga_barang() {
        return harga_barang;
    }
    public void setHarga_barang(String harga_barang) { this.harga_barang = harga_barang; }

    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getNo_telpon() {
        return no_telpon;
    }
    public void setNo_telpon(String no_telpon) { this.no_telpon = no_telpon; }

    public String getMetode_pembayaran() {  return metode_pembayaran; }
    public void setMetode_pembayaran(String metode_pembayaran) { this.metode_pembayaran = metode_pembayaran; }

    public String getKurir_pengiriman() {
        return kurir_pengiriman;
    }
    public void setKurir_pengiriman(String kurir_pengiriman) { this.kurir_pengiriman = kurir_pengiriman; }

    public String getKey() {  return key; }
    public void setKey(String key) { this.key = key; }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) { this.userId = userId; }

    public BayarReq(){}

    public BayarReq(String nama_pembeli, String nama_barang, String harga_barang, String alamat, String no_telpon, String metode_pembayaran, String kurir_pengiriman){
    this.nama_pembeli = nama_pembeli;
    this.nama_barang = nama_barang;
    this.harga_barang = harga_barang;
    this.alamat = alamat;
    this.no_telpon = no_telpon;
    this.metode_pembayaran = metode_pembayaran;
    this.kurir_pengiriman = kurir_pengiriman;
    }


}
